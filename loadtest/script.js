import http from 'k6/http';
import { check } from 'k6';
import { randomString } from 'https://jslib.k6.io/k6-utils/1.0.0/index.js';


export const options = {
  stages: [
    { duration: '30s', target: 2 },
    { duration: '1m30s', target: 20 },
    { duration: '20s', target: 0 },
  ],
};

const targetUrl = 'http://demo-Publi-1G6MQ127LQ4TP-1098564578.us-east-1.elb.amazonaws.com'

export default function () {
  const list = {
    method: 'GET',
    url: targetUrl + '/tokens'
  };
  
  let data = { name: `${randomString(10)}@example.com`, description: 'noSpecificData', category: 'Sometest'};
  const create = {
    method: 'POST',
    url: targetUrl + '/create',
    body: JSON.stringify(data),
    params: {
      headers: { "Content-Type": "application/json" }
    }
  };
  const responses = http.batch([list, create]);
  const resp = responses[1]
  let passed = check(resp, {
    "status is 200": (r) => r.status === 200,
  })
  
}