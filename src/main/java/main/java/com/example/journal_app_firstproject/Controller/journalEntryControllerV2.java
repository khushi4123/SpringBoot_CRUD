package main.java.com.example.journal_app_firstproject.Controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
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
    public List<JournalEntity> getall() {
        return journalEntryService.getall();
    }

    @PostMapping
    public JournalEntity create(@RequestBody JournalEntity myEntity) {
        myEntity.setDate(LocalDateTime.now());
        journalEntryService.saveEntry(myEntity);
        return myEntity;
    }

    @DeleteMapping("/id/{myid}")
    public boolean delete(@PathVariable ObjectId myid) {

        journalEntryService.deleteById(myid);
        return true;
    }

    @GetMapping("id/{myid}")
    public JournalEntity search(@PathVariable ObjectId myid) {
        return journalEntryService.findById(myid).orElse(null);
    }

    @PutMapping("/id/{myid}")
    public JournalEntity update(@PathVariable ObjectId myid, @RequestBody JournalEntity newEntity) {
        JournalEntity old = journalEntryService.findById(myid).orElse(null);
        if (old != null) {
            old.setTitle(newEntity.getTitle() != null && !newEntity.getTitle().equals("") ? newEntity.getTitle():old.getTitle());
            old.setDesc(newEntity.getDesc() != null && !newEntity.equals("")?newEntity.getDesc():old.getDesc());
        }
        journalEntryService.saveEntry(newEntity);
        return newEntity;
    }
}
