package main.java.com.example.journal_app_firstproject.repository;

import org.springframework.data.mongodb.repository.MongoRepository;

import main.java.com.example.journal_app_firstproject.entity.JournalEntity;

public interface JournalEntryRepo extends MongoRepository<JournalEntity, String> {

}