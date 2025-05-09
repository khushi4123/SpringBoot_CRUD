package main.java.com.example.journal_app_firstproject.Controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import main.java.com.example.journal_app_firstproject.entity.JournalEntity;

@RestController
@RequestMapping("/journal")
public class journalEntryControllerV2
{

    @GetMapping
    public List<JournalEntity> getall() {
        return null;
    }

    @PostMapping
    public boolean display(@RequestBody JournalEntity myEntity) {
        return true;
    }

    @DeleteMapping("/id/{myid}")
    public String delete(@PathVariable Long myid) {

        return "Deleted successfully";
    }

    @GetMapping("id/{myid}")
    public JournalEntity search(@PathVariable Long myid) {
        return null;
    }

    @PutMapping("/id/{myid}")
    public JournalEntity update(@PathVariable Long myid, @RequestBody JournalEntity myEntity) {

        return null;
    }
}
