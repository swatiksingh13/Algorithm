# Digantara Backend Developer Assignment

## Overview
This project is a Spring Boot application that provides APIs for three fundamental algorithms:
1. **Binary Search**
2. **Quick Sort**
3. **Breadth-First Search (BFS)**

Each API logs every request, including:
- Algorithm Name
- Input Data
- Output Data

Logs are stored in **MySQL Database**.

## 🚀 Setup & Installation

### **1. Prerequisites**
Ensure you have the following installed:
- **Java 17+**
- **Maven**
- **MySQL**
- **Postman (optional, for API testing)**

### **2. Clone the Repository**
```sh
git clone https://github.com/swatiksingh13/Algorithm.git
cd digantara-backend-assignment

### Configure MySQL
Open MySQL and create a database:
CREATE DATABASE algorithm_logs;
Update application.properties in src/main/resources/ with your database credentials.

### Build and Run the Project
mvn clean install
mvn spring-boot:run

- **API Endpoints**
1. Binary Search
Endpoint: POST /api/binary-search
Request:
{
  "array": [1, 3, 5, 7, 9],
  "target": 5
}
Response:
{
  "index": 2
}
2. Quick Sort
Endpoint: POST /api/quick-sort
Request:
json
Copy
Edit
{
  "array": [9, 3, 7, 1, 5]
}
Response:
{
  "sortedArray": [1, 3, 5, 7, 9]
}
3. Breadth-First Search (BFS)
Endpoint: POST /api/bfs
Request:
{
  "graph": {
    "A": ["B", "C"],
    "B": ["D", "E"],
    "C": ["F"],
    "D": [],
    "E": ["F"],
    "F": []
  },
  "start": "A"
}
Response:
{
  "bfsTraversal": ["A", "B", "C", "D", "E", "F"]
}
 - Accessing Logs
Logs are stored in the algorithm_logs MySQL database.

To retrieve logs, use:

SELECT * FROM logs;

