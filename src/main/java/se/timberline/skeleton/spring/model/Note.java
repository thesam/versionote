package se.timberline.skeleton.spring.model;

import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @JsonProperty
    private long id;
    @Column
    @JsonProperty
    private String title;
    @Column
    @JsonProperty
    private String content;

    public Note() {
        this.title = "";
        this.content = "";
    }

    public long id() {
        return id;
    }

    public void updateFrom(Note note) {
        this.title = note.title;
        this.content = note.content;
    }

    public String title() {
        return this.title;
    }
}
