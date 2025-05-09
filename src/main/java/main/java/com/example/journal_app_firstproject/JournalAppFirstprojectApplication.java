package main.java.com.example.journal_app_firstproject;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@SpringBootApplication
@EnableMongoRepositories
public class JournalAppFirstprojectApplication {
	public static void main(String[] args) {
		SpringApplication.run(JournalAppFirstprojectApplication.class, args);
	}
}