package se.timberline.skeleton.spring.model;

import javax.persistence.*;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    @Column
    private String title;
    @Column
    private String content;

    public Note() {
        this.title = "";
        this.content = "";
    }

    public long id() {
        return id;
    }
}
