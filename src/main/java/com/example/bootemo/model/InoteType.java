package com.example.bootemo.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "noteType")
public class InoteType {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    private String name;
    private String description;

    @OneToMany(targetEntity = Inote.class)
    private List<Inote> inote;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Inote> getInote() {
        return inote;
    }

    public void setInote(List<Inote> inote) {
        this.inote = inote;
    }

    public InoteType() {
    }

    public InoteType(String name, String description, List<Inote> inote) {
        this.name = name;
        this.description = description;
        this.inote = inote;
    }
}
