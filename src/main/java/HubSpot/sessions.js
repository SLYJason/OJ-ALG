const axios = require('axios');

const datasetEndpoint = "https://candidate.hubteam.com/candidateTest/v3/problem/dataset"
const resultEndpoint  = "https://candidate.hubteam.com/candidateTest/v3/problem/result"
const userKey = "USER_KEY"
const sessionLimit = 600000

axios.get(`${datasetEndpoint}?userKey=${userKey}`)
    .then(res => {
        console.log(`datasetEndpoint statusCode: ${res.status}`);
        const visitorMap = createVisitorMap(res.data.events);
        const sessionsByUser = createSessions(visitorMap)
        axios.post(`${resultEndpoint}?userKey=${userKey}`, {sessionsByUser})
            .then((response) => {
                console.log(`resultEndpoint statusCode: ${res.status}`);
            })
            .catch((error) => {
                console.log(error);
            })
    })
    .catch(error => {
        console.error(error);
    });

/**
 * Create sessionsByUser by visitorMap. The logic is: start from each visitor events at index 1, compare the adjacent event as long as they under the session limit,
 * keeping adding the url to the pages array, if not under single session break the loop. There has a corner case need to be handled is the last event can be alone.
 * @param visitorMap
 * @returns {{visitorId: [{duration, pages, startTime}]}}
 */
function createSessions(visitorMap) {
    let sessionsByUser = {}
    for (let visitorId in visitorMap) {
        // for each visitorId, create each session.
        sessionsByUser[visitorId] = []
        let events = visitorMap[visitorId]
        let i = 1;
        while (i < events.length) {
            let startTime = events[i - 1].timestamp
            let pages = [events[i - 1].url]
            let duration = 0;
            while (i < events.length && events[i].timestamp - events[i - 1].timestamp <= sessionLimit) {
                pages.push(events[i].url)
                i++;
            }
            if (i - 1 > 0) {
                duration = events[i - 1].timestamp - startTime
            }
            let session = {
                duration: duration,
                pages: pages,
                startTime: startTime,
            }
            sessionsByUser[visitorId].push(session)
            i++;
        }
        // corner case: the last event can be alone
        if (events[events.length - 1].timestamp - events[events.length - 2].timestamp > sessionLimit) {
            sessionsByUser[visitorId].push({
                duration: 0,
                pages: [events[events.length - 1].url],
                startTime: events[events.length - 1].timestamp,
            })
        }
        sessionsByUser[visitorId].sort((a, b) => a.startTime - b.startTime)
    }
    // debug
    // console.log(JSON.stringify((sessionsByUser)))
    return sessionsByUser
}

/**
 * Create a visitorMap by paring the response data. Key: visitorId, Value: an array contains {url, timestamp} object, it is sorted by timestamp in ascending order.
 * @param events
 * @returns {{visitorId: [{url, timestamp}]}}
 */
function createVisitorMap(events) {
    let visitorMap = {}
    for (let event of events) {
        let url = event["url"];
        let visitorId = event["visitorId"];
        let timestamp = event["timestamp"];
        if (!(visitorId in visitorMap)) {
            visitorMap[visitorId] = []
        }
        visitorMap[visitorId].push({
            url,
            timestamp,
        })
    }
    // sort each {url, timestamp} based on timestamp.
    for (let visitor in visitorMap) {
        visitorMap[visitor].sort((a, b) => a.timestamp - b.timestamp)
    }
    return visitorMap;
}