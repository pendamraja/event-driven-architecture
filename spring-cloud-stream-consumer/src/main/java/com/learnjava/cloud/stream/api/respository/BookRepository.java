package com.learnjava.cloud.stream.api.respository;

import com.learnjava.cloud.stream.api.model.Book;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface BookRepository extends MongoRepository<Book, Integer> {
}
