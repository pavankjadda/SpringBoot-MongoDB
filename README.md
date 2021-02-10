# Spring Boot Project with MongoDB
BookStore Spring Boot Project that demonstrates basic CRUD (Create, Read, Write and Delete) operations
using MongoDB database. 

### Prerequsites:
1. Install [Java](http://docs.oracle.com/javase/8/docs/technotes/guides/install/install_overview.html)
2. Install Eclipse or IntelliJ IDE
3. Install [MongoDB from official docs](https://docs.mongodb.com/manual/installation/) or spin up a Docker container
```
docker run -v <Local Directory>:/data/db -d mongo
```

### How to Run
1. Download the project
2. Import as Maven Project
3. Right click on `BookStoreApplication` java class and select `run`
4. Open browser and go to `http://localhost:8081/books.html` to see list of books
5. You can create/update/delete books
