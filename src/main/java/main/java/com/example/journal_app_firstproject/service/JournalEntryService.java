package main.java.com.example.journal_app_firstproject.service;

import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import main.java.com.example.journal_app_firstproject.entity.JournalEntity;
import main.java.com.example.journal_app_firstproject.repository.JournalEntryRepo;

@Component
public class JournalEntryService {

    @Autowired
    private JournalEntryRepo journalentryrepo;

    public void saveEntry(JournalEntity journalentity) {
        journalentryrepo.save(journalentity);
    }

    public List<JournalEntity> getall() {
        return journalentryrepo.findAll();
    }

     public Optional<JournalEntity> findById(ObjectId myid) {
        return journalentryrepo.findById(myid);
    }

     public void deleteById(ObjectId myid) {
         journalentryrepo.deleteById(myid);
         }

   

}
