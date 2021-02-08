package com.example.model;

import lombok.Data;
import lombok.ToString;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@ToString
@Document(collection = "Book")
public class Book {

    @Id
    private int id;
    private String name;
    private String authorName;
}
