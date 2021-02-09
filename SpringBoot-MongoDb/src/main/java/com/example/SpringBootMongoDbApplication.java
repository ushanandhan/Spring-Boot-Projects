package com.example;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMongoDbApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(SpringBootMongoDbApplication.class, args);
	}

	public MongoClient getClient(){
		return new MongoClient("mongo-db",27017);
	}


	@Override
	public void run(String... args) throws Exception {
		MongoClient mongoClient = getClient();
		MongoDatabase mongoDatabase = mongoClient.getDatabase("BookStore");
		MongoCollection<Document> employeeCollection = mongoDatabase.getCollection("employee");

		Document employee = new Document();
		employee.append("firstName","BAT");
		employee.append("lastName","MAN");
		employee.append("address","BAT CAVE");

		employeeCollection.insertOne(employee);
	}
}
