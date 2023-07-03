# JWT Server App Example

This is a sample application using java 17, spring 3, and mongodb, to generate and save JWT tokens
It can be deployed with Copilot to Fargate ARM and it includes a load testing benchmark tool.

## AWS Copilot

### Pre-requisites

- aws cli installed and configured with credentials
- aws copilot installed: <https://docs.aws.amazon.com/AmazonECS/latest/developerguide/AWS_Copilot.html>

### Deploy

To run on Fargate, use this command:

```shell
copilot init --app demo --name api --type 'Load Balanced Web Service' --deploy
```

### Configuration

- Copilot config is here: [/copilot/api/manifest.yml](/copilot/api/manifest.yml)
- Cloudformation to create DocumentDB y is on [/copilot/api/addons/database.yml](/copilot/api/addons/database.yml) and it is run automatically by _copilot init_

### Design

- First, copilot as the main tool for deploy. Everything begins when copilot init executes:
  
  1. It reads the manifest.yml file to look for config values
  2. It creates a VPC, subnets, roles, ECS Service automatically on the account
  3. It builds the Dockerfile and uploads the results to an ECR registry on the account
  4. It executes the attached cloudformation template on the addons folder to:
     - create the Database, 
     - sets the environment variable with host and credentials
  5. Copilot deploys the container as an ECS task with the environment variables set as configured on the manifest.yml

- The endpoints published on the app can be accesed publicly and benchmarked

### Benchmarks

Use [K6](https://k6.io/docs/getting-started/running-k6/) to run the test on /loadtest. See [README.md](/loadtest/README.md) for instructions.

### Customization

You can use this project as is, but the idea is for you to extend this by doing the following:

- replace the code with your own,
- use the Database instance to load a dataset for your code to read/write,
- test that the URL is working,
- use that URL on the load test tool at the /loadtest folder to get benchmarks