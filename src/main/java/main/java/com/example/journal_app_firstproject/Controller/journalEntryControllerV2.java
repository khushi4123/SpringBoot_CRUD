package main.java.com.example.journal_app_firstproject.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.example.journal_app_firstproject.entity.JournalEntity;
import main.java.com.example.journal_app_firstproject.service.JournalEntryService;

@RestController
@RequestMapping("/journal")
public class journalEntryControllerV2 {

    @Autowired
    private JournalEntryService journalEntryService;

    @GetMapping
    public ResponseEntity<?> getall() {
        List<JournalEntity> all = journalEntryService.getall();
        if (all != null && !all.isEmpty()) {
            return new ResponseEntity(all, HttpStatus.OK);
        }
        return new ResponseEntity(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<JournalEntity> create(@RequestBody JournalEntity myEntity) {
        try {
            myEntity.setDate(LocalDateTime.now());
            journalEntryService.saveEntry(myEntity);
            return new ResponseEntity<>(myEntity, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }
    }

    @DeleteMapping("/id/{myid}")
    public ResponseEntity<?> delete(@PathVariable ObjectId myid) {

        journalEntryService.deleteById(myid);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping("id/{myid}")
    public ResponseEntity<JournalEntity> search(@PathVariable ObjectId myid) {
        Optional<JournalEntity> journalentity = journalEntryService.findById(myid);
        if (journalentity.isPresent()) {
            return new ResponseEntity<>(journalentity.get(), HttpStatus.OK);
        }
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PutMapping("/id/{myid}")
    public ResponseEntity<?> update(@PathVariable ObjectId myid, @RequestBody JournalEntity newEntity) {
        JournalEntity old = journalEntryService.findById(myid).orElse(null);
        if (old != null) {
            old.setTitle(newEntity.getTitle() != null && !newEntity.getTitle().equals("") ? newEntity.getTitle()
                    : old.getTitle());
            old.setDesc(newEntity.getDesc() != null && !newEntity.equals("") ? newEntity.getDesc() : old.getDesc());
        }
        journalEntryService.saveEntry(newEntity);
        return new ResponseEntity<>(old, HttpStatus.OK);
    }
}
