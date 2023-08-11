```markdown
# ELK using Docker Configuration with Spring Boot

## Overview

This repository provides a basic setup to integrate the ELK stack (Elasticsearch, Logstash, Kibana) with a Spring Boot application using Docker.

## Getting Started

Follow these steps to set up and run the project:

1. Clone the repository:
   ```bash
   git clone https://github.com/MohosinMiah/springboot-logging-elk.git
   ```

2. Navigate to the project directory:
   ```bash
   cd docker-logging-elk
   ```

3. Start the ELK stack using Docker Compose:
   ```bash
   docker-compose up -d
   ```

## Usage

After starting the ELK stack, you can access the following URLs in your browser:

- **Kibana Dashboard**: http://localhost:5601/
  Use this link to view and analyze logs stored in Elasticsearch.

- **Test API Endpoint**: http://localhost:8080/
  Access your Spring Boot application's test API endpoint.

## Notes

- This setup uses Docker Compose to manage the ELK stack containers.
- The Spring Boot application sends logs to Logstash, which processes and forwards them to Elasticsearch for storage.
- Kibana is used to visualize and analyze the stored logs.