package com.pj.repo;

import com.pj.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;


public interface BookRepository extends MongoRepository<Book,String>
{
        //MongoRepository provides methods for CRUD operation
}
