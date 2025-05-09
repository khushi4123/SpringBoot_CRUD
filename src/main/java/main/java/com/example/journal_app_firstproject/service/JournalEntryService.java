package main.java.com.example.journal_app_firstproject.service;

import org.springframework.beans.factory.annotation.Autowired;

import main.java.com.example.journal_app_firstproject.repository.JournalEntryRepo;

public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalentityrepo;
}
