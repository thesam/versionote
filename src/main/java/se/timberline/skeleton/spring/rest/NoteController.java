package se.timberline.skeleton.spring.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
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

    @RequestMapping(value = "/notes",method = RequestMethod.POST)
    public void createNote(@RequestBody Note note) {
        noteRepository.save(note);
    }

    @RequestMapping(value = "/notes/{id}",method = RequestMethod.PUT)
    public void updateNote(@PathVariable Long id, @RequestBody Note note) {
        Note noteInRepository = noteRepository.findOne(id);
        noteInRepository.updateFrom(note);
        noteRepository.save(noteInRepository);
    }
}