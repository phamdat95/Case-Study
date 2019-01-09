package com.example.bootemo.model;

import javax.persistence.*;

@Entity
@Table(name = "inote")
public class Inote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private String title;
    private String content;

    @ManyToOne(targetEntity = InoteType.class)
    @JoinColumn(name = "notetype_id")
    private InoteType inoteType;

    public InoteType getInoteType() {
        return inoteType;
    }

    public void setInoteType(InoteType inoteType) {
        this.inoteType = inoteType;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Inote(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public Inote() {
    }
}
