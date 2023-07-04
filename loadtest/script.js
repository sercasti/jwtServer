import http from 'k6/http';
import { check } from 'k6';

export const options = {
  stages: [
    { duration: '30s', target: 2 },
    { duration: '1m30s', target: 20 },
    { duration: '20s', target: 0 },
  ],
};

const targetUrl = 'https://5gfwv2utec.us-east-1.awsapprunner.com'

export default function () {
  const list = {
    method: 'GET',
    url: targetUrl + '/tokens'
  };
  const create = {
    method: 'POST',
    url: targetUrl + '/create',
    body: {
        name: 'world!',
        description: 'noSpecificData',
        category: 'Sometest'
    }
  };

  const responses = http.batch([list, create]);
  check(responses[0], {
      'page status was 200': (res) => res.status === 200,
  });
}