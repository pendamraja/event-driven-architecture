package com.learnjava.cloud.stream.api.resource;

import com.learnjava.cloud.stream.api.SpringCloudStreamConsumerApplication;
import com.learnjava.cloud.stream.api.model.Book;
import com.learnjava.cloud.stream.api.respository.BookRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BookResource {
    private Logger logger = LoggerFactory.getLogger(SpringCloudStreamConsumerApplication.class);

    @Autowired
    private BookRepository repository;

    @StreamListener("input")
    public void consumeMessage(Book book) {
        logger.info("Consume payload : " + book);
        repository.save(book);
        logger.info("Added In DB,Book id :"+book.getId());
    }
}
