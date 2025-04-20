# Spring Boot Project with MongoDB

BookStore Spring Boot Project that demonstrates basic CRUD (Create, Read, Write and Delete) operations
using MongoDB database.

### Prerequisites:

1. Install Java 21
2. Open the project in Eclipse or IntelliJ IDE
3. Install [MongoDB from official docs](https://docs.mongodb.com/manual/installation/) or spin up a Docker container

      ```
      docker run  -p 27017:27017 --name mongodb -e MONGO_INITDB_ROOT_USERNAME=root -e MONGO_INITDB_ROOT_PASSWORD=Test#12345 -d mongo
      ```

4. Create `spring-boot-mongodb` database in MongoDB

### How to Run

1. Download the project
2. Import as Maven Project
3. Right click on `BookStoreApplication` java class and select `run`
4. Open browser and go to `http://localhost:8081/books.html` to see list of books
5. You can create/update/delete books