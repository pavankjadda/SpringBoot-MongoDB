package com.books;
import com.books.model.Book;
import com.books.util.JsonUtil;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import com.mongodb.ServerAddress;

import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.MongoCollection;

import org.bson.Document;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;
import java.util.*;

import com.mongodb.Block;

import com.mongodb.client.MongoCursor;
import static com.mongodb.client.model.Filters.*;
import com.mongodb.client.result.DeleteResult;
import static com.mongodb.client.model.Updates.*;
import com.mongodb.client.result.UpdateResult;

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

        List<Document>  bookList=new ArrayList<>();
        for (int i = 0; i< 5000000L; i++)
        {
            bookList.add(Document.parse(JsonUtil.toJsonString(book)));
        }

        LocalDateTime   startDateTime=LocalDateTime.now();
        System.out.println("Before Inserting Million Records, Time: "+startDateTime.toString());

        mongoCollection.insertMany(bookList);

        LocalDateTime   endDateTime=LocalDateTime.now();
        System.out.println("After Inserting Million Records, Time: "+endDateTime.toString());

        long hours = startDateTime.until( endDateTime, ChronoUnit.HOURS);
        long minutes = startDateTime.until( endDateTime, ChronoUnit.MINUTES);
        long seconds=startDateTime.until(endDateTime,ChronoUnit.SECONDS);
        long milliSeconds=startDateTime.until(endDateTime,ChronoUnit.MILLIS);
        long microSeconds=startDateTime.until(endDateTime,ChronoUnit.MICROS);
        long nanoSeconds=startDateTime.until(endDateTime,ChronoUnit.NANOS);
        System.out.println("Time took to insert million records==> "+hours+" hours "+minutes+" minutes "+seconds+" seconds "+milliSeconds+" milliSeconds "+microSeconds+" microSeconds "+nanoSeconds+" nanoSeconds");


        /*
        FindIterable<Document> retrievedDocuments=mongoCollection.find(and(eq("id","B1001"),gt("cost",9)));
        for(Document retrievedDocument:retrievedDocuments)
        {
            System.out.println("Retrieved Document ==> "+retrievedDocument.toString());
        }
        */

    }


}
