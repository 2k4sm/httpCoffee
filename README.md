# _httpcoffee_

## Description
httpcoffee is a designed to help manage coffee chains, developed using Go, PostgreSQL, GORM, and go-fiber. This project features RESTful APIs for coffee, user, coffeeHouse, and payment management. Currently, payment management only stores payments manually, with plans to integrate Stripe API for actual payment processing in the next version.

# Setup Guide

1. **Install Go**: Make sure Go is installed on your system. You can download it from [golang.org](https://golang.org/dl/).

2. **Clone the Repository**:
   ```bash
   git clone https://github.com/2k4sm/httpcoffee.git
   cd httpcoffee
   ```
3. **Install Dependencies**:
   ```bash
   go mod tidy
   ```
4. **env variables.**
      ```json
      HOST=<host>
      PORT=<server_port>
      USERNAME=<db_uname>
      PASSWORD=<db_passwd>
      DB=<db_name>
      DBPORT=5432
      SSLMODE=disable
      VERSION=v0
      ```
      - Then Run
        ```bash
        export $(cat .env | xargs)
        ```
5. **Start PostgreSQL using compose.yaml**
   ```bash
   docker compose up --build
   ```
6 **Run the Application:**

  ```bash
  go run main.go
  ```
7 **Docker Setup** (optional):

  - Build the Docker image and Run :
    ```bash
    docker build -t httpcoffee . && docker-compose up
    ```

8 **Building the Application:**

  ```bash
  go build -o bin/httpcoffee main.go
  ```


## Version 0
The initial release includes foundational APIs and manual payment recording, focusing on a clean, decoupled architecture using dependency injection.

## Version 1 Roadmap
- Implement authentication mechanisms.
- Introduce rate limiting for API endpoints.
- Overhaul the payment service to process payments via Stripe API.
## Version 2 Roadmap
- Incorporate unit, end-to-end (e2e), and integration tests using the Go test suite.
## Deployment
Docker and Docker Compose are used for simplified deployment and configuration.

## Thanks for using httpcoffee.
