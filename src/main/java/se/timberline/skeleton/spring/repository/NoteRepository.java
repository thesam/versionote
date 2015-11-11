package se.timberline.skeleton.spring.repository;

import org.springframework.data.repository.CrudRepository;
import se.timberline.skeleton.spring.model.Note;

import java.util.List;

public interface NoteRepository extends CrudRepository<Note, Long> {

    List<Note> findAll();
}