package se.timberline.skeleton.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import se.timberline.skeleton.spring.model.Note;
import se.timberline.skeleton.spring.repository.NoteRepository;

import java.util.List;

@RestController
public class NoteController {

    private static final String template = "Hello, %s!";

    @Autowired
    private NoteRepository noteRepository;

    @RequestMapping("/notes")
    public List<Note> findAllNotes() {
        return noteRepository.findAll();
    }
}