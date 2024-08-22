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
4 **Run the Application:**

  ```bash
  go run main.go
  ```
5 **Docker Setup** (optional):

  - Build the Docker image and Run :
    ```bash
    docker build -t httpcoffee . && docker-compose up
    ```

6 **Building the Application:**

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

## API Endpoints
### API Specification Documentation

#### Base URL
The API base URL will be assumed as:
```
http://localhost:6969/
```

### Endpoints

#### Coffee

1. **Create Coffee**
   - **Endpoint:** `POST /coffees`
   - **Request Payload:**
     ```json
     {
       "name": "Espresso",
       "description": "Strong and bold coffee",
       "origin": "Ethiopia",
       "contents": ["Water", "Coffee Beans"],
       "cost": 300
     }
     ```
   - **Response:** 
     - **201 Created**
     - **Payload:**
       ```json
       {
         "id": 1,
         "name": "Espresso",
         "description": "Strong and bold coffee",
         "origin": "Ethiopia",
         "contents": ["Water", "Coffee Beans"],
         "cost": 300
       }
       ```

2. **Get Coffee by ID**
   - **Endpoint:** `GET /coffees/{id}`
   - **Response:** 
     - **200 OK**
     - **Payload:**
       ```json
       {
         "id": 1,
         "name": "Espresso",
         "description": "Strong and bold coffee",
         "origin": "Ethiopia",
         "contents": ["Water", "Coffee Beans"],
         "cost": 300
       }
       ```

3. **Update Coffee**
   - **Endpoint:** `PUT /coffees/{id}`
   - **Request Payload:**
     ```json
     {
       "name": "Espresso",
       "description": "Strong and bold coffee",
       "origin": "Ethiopia",
       "contents": ["Water", "Coffee Beans"],
       "cost": 350
     }
     ```
   - **Response:** 
     - **200 OK**
     - **Payload:**
       ```json
       {
         "id": 1,
         "name": "Espresso",
         "description": "Strong and bold coffee",
         "origin": "Ethiopia",
         "contents": ["Water", "Coffee Beans"],
         "cost": 350
       }
       ```

4. **Delete Coffee**
   - **Endpoint:** `DELETE /coffees/{id}`
   - **Response:** 
     - **204 No Content**

#### CoffeeHouse

1. **Create CoffeeHouse**
   - **Endpoint:** `POST /coffeehouses`
   - **Request Payload:**
     ```json
     {
       "house_name": "Downtown Coffee",
       "coffees": [
         {
           "id": 1,
           "name": "Espresso",
           "description": "Strong and bold coffee",
           "origin": "Ethiopia",
           "contents": ["Water", "Coffee Beans"],
           "cost": 300
         }
       ]
     }
     ```
   - **Response:** 
     - **201 Created**
     - **Payload:**
       ```json
       {
         "id": 1,
         "house_name": "Downtown Coffee",
         "user_count": 0,
         "top_coffee": "Espresso",
         "revenue": 0,
         "coffees": [
           {
             "id": 1,
             "name": "Espresso",
             "description": "Strong and bold coffee",
             "origin": "Ethiopia",
             "contents": ["Water", "Coffee Beans"],
             "cost": 300
           }
         ],
         "payments": []
       }
       ```

2. **Get CoffeeHouse by ID**
   - **Endpoint:** `GET /coffeehouses/{id}`
   - **Response:** 
     - **200 OK**
     - **Payload:**
       ```json
       {
         "id": 1,
         "house_name": "Downtown Coffee",
         "user_count": 10,
         "top_coffee": "Espresso",
         "revenue": 3000,
         "coffees": [
           {
             "id": 1,
             "name": "Espresso",
             "description": "Strong and bold coffee",
             "origin": "Ethiopia",
             "contents": ["Water", "Coffee Beans"],
             "cost": 300
           }
         ],
         "payments": [
           {
             "id": 1,
             "user_id": 2,
             "coffee_house_id": 1,
             "cost": 300,
             "date": "2024-08-22T00:00:00Z",
             "items": [
               {
                 "id": 1,
                 "name": "Espresso",
                 "description": "Strong and bold coffee",
                 "origin": "Ethiopia",
                 "contents": ["Water", "Coffee Beans"],
                 "cost": 300
               }
             ]
           }
         ]
       }
       ```

3. **Update CoffeeHouse**
   - **Endpoint:** `PUT /coffeehouses/{id}`
   - **Request Payload:**
     ```json
     {
       "house_name": "Downtown Coffee Revamped",
       "coffees": [
         {
           "id": 1,
           "name": "Espresso",
           "description": "Strong and bold coffee",
           "origin": "Ethiopia",
           "contents": ["Water", "Coffee Beans"],
           "cost": 300
         },
         {
           "id": 2,
           "name": "Latte",
           "description": "Smooth and creamy coffee",
           "origin": "Colombia",
           "contents": ["Milk", "Coffee Beans"],
           "cost": 400
         }
       ]
     }
     ```
   - **Response:** 
     - **200 OK**
     - **Payload:**
       ```json
       {
         "id": 1,
         "house_name": "Downtown Coffee Revamped",
         "user_count": 15,
         "top_coffee": "Latte",
         "revenue": 4500,
         "coffees": [
           {
             "id": 1,
             "name": "Espresso",
             "description": "Strong and bold coffee",
             "origin": "Ethiopia",
             "contents": ["Water", "Coffee Beans"],
             "cost": 300
           },
           {
             "id": 2,
             "name": "Latte",
             "description": "Smooth and creamy coffee",
             "origin": "Colombia",
             "contents": ["Milk", "Coffee Beans"],
             "cost": 400
           }
         ],
         "payments": []
       }
       ```

4. **Delete CoffeeHouse**
   - **Endpoint:** `DELETE /coffeehouses/{id}`
   - **Response:** 
     - **204 No Content**

#### Payment

1. **Create Payment**
   - **Endpoint:** `POST /payments`
   - **Request Payload:**
     ```json
     {
       "user_id": 2,
       "coffee_house_id": 1,
       "cost": 300,
       "date": "2024-08-22T00:00:00Z",
       "items": [
         {
           "id": 1,
           "name": "Espresso",
           "description": "Strong and bold coffee",
           "origin": "Ethiopia",
           "contents": ["Water", "Coffee Beans"],
           "cost": 300
         }
       ]
     }
     ```
   - **Response:** 
     - **201 Created**
     - **Payload:**
       ```json
       {
         "id": 1,
         "user_id": 2,
         "coffee_house_id": 1,
         "cost": 300,
         "date": "2024-08-22T00:00:00Z",
         "items": [
           {
             "id": 1,
             "name": "Espresso",
             "description": "Strong and bold coffee",
             "origin": "Ethiopia",
             "contents": ["Water", "Coffee Beans"],
             "cost": 300
           }
         ]
       }
       ```

2. **Get Payment by ID**
   - **Endpoint:** `GET /payments/{id}`
   - **Response:** 
     - **200 OK**
     - **Payload:**
       ```json
       {
         "id": 1,
         "user_id": 2,
         "coffee_house_id": 1,
         "cost": 300,
         "date": "2024-08-22T00:00:00Z",
         "items": [
           {
             "id": 1,
             "name": "Espresso",
             "description": "Strong and bold coffee",
             "origin": "Ethiopia",
             "contents": ["Water", "Coffee Beans"],
             "cost": 300
           }
         ]
       }
       ```

3. **Update Payment**
- **Endpoint:** `PUT /payments/{id}`
- **Request Payload:**
  ```json
  {
    "user_id": 2,
    "coffee_house_id": 1,
    "cost": 350,
    "date": "2024-08-22T00:00:00Z",
    "items": [
      {
        "id": 1,
        "name": "Espresso",
        "description": "Strong and bold coffee",
        "origin": "Ethiopia",
        "contents": ["Water", "Coffee Beans"],
        "cost": 300
      }
    ]
  }
  ```
- **Response:**
  - **200 OK**
  - **Payload:**
    ```json
    {
      "id": 1,
      "user_id": 2,
      "coffee_house_id": 1,
      "cost": 350,
      "date": "2024-08-22T00:00:00Z",
      "items": [
        {
          "id": 1,
          "name": "Espresso",
          "description": "Strong and bold coffee",
          "origin": "Ethiopia",
          "contents": ["Water", "Coffee Beans"],
          "cost": 300
        }
      ]
    }
    ```

#### Delete Payment
- **Endpoint:** `DELETE /payments/{id}`
- **Response:**
  - **204 No Content**
 

## Thanks for using httpcoffee.
