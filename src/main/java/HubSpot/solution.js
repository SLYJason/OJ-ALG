const axios = require('axios');

const datasetEndpoint = "https://candidate.hubteam.com/candidateTest/v3/problem/dataset?userKey=bc7d8712b664eadc7f9698f9b4a7"

axios.get(datasetEndpoint)
    .then(res => {
        console.log(`statusCode: ${res.status}`);
        console.log(res.data);
    })
    .catch(error => {
        console.error(error);
    });

function createSessions() {

}