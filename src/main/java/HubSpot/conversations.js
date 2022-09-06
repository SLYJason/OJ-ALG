const axios = require('axios');

const datasetEndpoint = "https://candidate.hubteam.com/candidateTest/v3/problem/dataset"
const resultEndpoint  = "https://candidate.hubteam.com/candidateTest/v3/problem/result"
const userKey = "USER_KEY"

axios.get(`${datasetEndpoint}?userKey=${userKey}`)
    .then(res => {
        console.log(`datasetEndpoint statusCode: ${res.status}`);
        const messagesMap = createMessagesMap(res.data["messages"], res.data["userId"]);
        const userMap = createUserMap(res.data["users"]);
        const conversations = createConversations(messagesMap, userMap)
        axios.post(`${resultEndpoint}?userKey=${userKey}`, {conversations})
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

function createConversations(messagesMap, userMap) {
    let conversations = [];
    for (let user in userMap) {
        let messages = messagesMap[user]
        let conversation = {
            avatar: userMap[user]["avatar"],
            firstName: userMap[user]["firstName"],
            lastName: userMap[user]["lastName"],
            mostRecentMessage: {
                content: messages[messages.length - 1]["content"],
                timestamp: messages[messages.length - 1]["timestamp"],
                userId: messages[messages.length - 1]["userId"],
            },
            totalMessages: messages.length,
            userId: user
        }
        conversations.push(conversation)
    }
    conversations.sort((c1, c2) => c2.mostRecentMessage.timestamp - c1.mostRecentMessage.timestamp) // reverse chronological order
    return conversations
}

function createMessagesMap(messages, userId) {
    let messagesMap = {};
    for (let message of messages) {
        let fromUserId = message["fromUserId"];
        let toUserId = message["toUserId"];
        let timestamp = message["timestamp"];
        let content = message["content"];
        let key = fromUserId === userId ? toUserId : fromUserId
        if (!(key in messagesMap)) {
            messagesMap[key] = []
        }
        messagesMap[key].push({
            content,
            timestamp,
            userId: fromUserId,
        })
    }
    for (let key in messagesMap) {
        messagesMap[key].sort((a, b) => a.timestamp - b.timestamp);
    }
    return messagesMap;
}

function createUserMap(users) {
    let userMap = {}
    for (let user of users) {
        let avatar = user["avatar"];
        let firstName = user["firstName"];
        let lastName = user["lastName"];
        let id = user["id"];
        userMap[id] = {
            avatar,
            firstName,
            lastName,
        }
    }
    return userMap;
}