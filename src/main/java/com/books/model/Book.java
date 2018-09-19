package com.books.model;

import lombok.Data;
import org.springframework.data.annotation.Id;


@Data
public class Book
{
    @Id
    private String id;

    private String title;

    private Integer numberOfPages;

    private Double cost;

    private String author;

    public Book()
    {
    }

    public Book(String title, Integer numberOfPages, Double cost, String author)
    {
        this.title = title;
        this.numberOfPages = numberOfPages;
        this.cost = cost;
        this.author = author;
    }
}
