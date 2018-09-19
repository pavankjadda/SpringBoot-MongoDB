package com.books;
import com.books.model.Book;
import com.books.util.JsonUtil;
import com.mongodb.MongoClient;

import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

public class NonSpringDataMongoDBTest
{
    public static void main(String[] args) throws IOException
    {
        MongoClient mongoClient=new MongoClient("localhost",27017);
        MongoDatabase   mongoDatabase=mongoClient.getDatabase("nonspringdatamongo");
        MongoCollection<Document>   mongoCollection=mongoDatabase.getCollection("book");

        Book book=new Book();
        book.setId("B1002");
        book.setAuthor("Spring Essentials");
        book.setCost(12.34);
        book.setNumberOfPages(345);

        LocalDateTime   startArrayListDateTime=LocalDateTime.now();
        List<Document>  bookList=new ArrayList<>(10000000);
        for (int i = 0; i< 10000000L; i++)
        {
            bookList.add(Document.parse(JsonUtil.toJsonString(book)));
        }
        LocalDateTime   endArrayListDateTime=LocalDateTime.now();
        calculateDifferenceInDates(startArrayListDateTime,endArrayListDateTime,"Time took to create Array List of billion records==> ");

        LocalDateTime   startDateTime=LocalDateTime.now();
        mongoCollection.insertMany(bookList);
        LocalDateTime   endDateTime=LocalDateTime.now();
        calculateDifferenceInDates(startDateTime,endDateTime,"Time took to insert billion records into DB ==> ");


        /*
        FindIterable<Document> retrievedDocuments=mongoCollection.find(and(eq("id","B1001"),gt("cost",9)));
        for(Document retrievedDocument:retrievedDocuments)
        {
            System.out.println("Retrieved Document ==> "+retrievedDocument.toString());
        }
        */

    }

    private static void calculateDifferenceInDates(LocalDateTime startDateTime,LocalDateTime endDateTime,String messsage)
    {
        long hours = startDateTime.until( endDateTime, ChronoUnit.HOURS);
        long minutes = startDateTime.until( endDateTime, ChronoUnit.MINUTES);
        long seconds=startDateTime.until(endDateTime,ChronoUnit.SECONDS);
        long milliSeconds=startDateTime.until(endDateTime,ChronoUnit.MILLIS);
        long microSeconds=startDateTime.until(endDateTime,ChronoUnit.MICROS);
        long nanoSeconds=startDateTime.until(endDateTime,ChronoUnit.NANOS);
        System.out.println(messsage+hours+" hours "+minutes+" minutes "+seconds+" seconds "+milliSeconds+" milliSeconds "+microSeconds+" microSeconds "+nanoSeconds+" nanoSeconds");
    }


}
