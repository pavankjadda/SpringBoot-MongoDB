package com.pj;

import com.mongodb.client.MongoClients;
import com.pj.model.Book;
import com.pj.util.JsonUtil;
import org.bson.Document;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.ArrayList;
import java.util.List;

public class NonSpringDataMongoDBTest {
    public static void main(String[] args) throws IOException {
        var mongoClient = MongoClients.create("mongodb://localhost:27017");
        var mongoDatabase = mongoClient.getDatabase("nonspringdatamongo");
        var mongoCollection = mongoDatabase.getCollection("book");

        var book = new Book();
        book.setId("B1002");
        book.setAuthor("Spring Essentials");
        book.setCost(12.34);
        book.setNumberOfPages(345);

        var startArrayListDateTime = LocalDateTime.now();
        List<Document> bookList = new ArrayList<>(10000000);
        for (int i = 0; i < 10000000L; i++) {
            bookList.add(Document.parse(JsonUtil.toJsonString(book)));
        }
        var endArrayListDateTime = LocalDateTime.now();
        calculateDifferenceInDates(startArrayListDateTime, endArrayListDateTime, "Time took to create Array List of billion records==> ");

        var startDateTime = LocalDateTime.now();
        mongoCollection.insertMany(bookList);
        var endDateTime = LocalDateTime.now();
        calculateDifferenceInDates(startDateTime, endDateTime, "Time took to insert billion records into DB ==> ");


        /*
        FindIterable<Document> retrievedDocuments=mongoCollection.find(and(eq("id","B1001"),gt("cost",9)));
        for(Document retrievedDocument:retrievedDocuments)
        {
            System.out.println("Retrieved Document ==> "+retrievedDocument.toString());
        }
        */

    }

    private static void calculateDifferenceInDates(LocalDateTime startDateTime, LocalDateTime endDateTime, String messsage) {
        long hours = startDateTime.until(endDateTime, ChronoUnit.HOURS);
        long minutes = startDateTime.until(endDateTime, ChronoUnit.MINUTES);
        long seconds = startDateTime.until(endDateTime, ChronoUnit.SECONDS);
        long milliSeconds = startDateTime.until(endDateTime, ChronoUnit.MILLIS);
        long microSeconds = startDateTime.until(endDateTime, ChronoUnit.MICROS);
        long nanoSeconds = startDateTime.until(endDateTime, ChronoUnit.NANOS);
        System.out.printf("%s%d hours %d minutes %d seconds %d milliSeconds %d microSeconds %d nanoSeconds%n", messsage, hours, minutes, seconds, milliSeconds,
                microSeconds, nanoSeconds);
    }
}