package com.example.repository;

import com.example.model.Book;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.data.mongo.DataMongoTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

@RunWith(SpringRunner.class)
@DataMongoTest
public class BookRepositoryTest {

    @Autowired
    MongoTemplate mongoTemplate;

    @Autowired
    BookRepository bookRepository;

    @Test
    public void test1(){
        Book book = new Book();
        book.setName("Spring Boot");
        book.setAuthorName("Ravi");
        Book savedBook = bookRepository.save(book);

        assertEquals(book.getName(),savedBook.getName());
        assertNotNull(savedBook.getId());
    }
}
