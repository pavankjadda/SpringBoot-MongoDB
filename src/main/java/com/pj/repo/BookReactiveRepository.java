package com.pj.repo;

import com.pj.model.Book;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookReactiveRepository extends ReactiveMongoRepository<Book, Long> {}
