package com.books.repo;

import com.books.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;
import java.util.Optional;


public interface BookRepository extends MongoRepository<Book,Long>
{
    List<Book> findAll();

    Optional<Book> findById(Long id);

    <S extends Book> List<S> saveAll(Iterable<S> var1);

    <S extends Book> S saveAndFlush(S var1);

}
