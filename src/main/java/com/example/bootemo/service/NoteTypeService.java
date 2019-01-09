package com.example.bootemo.service;

import com.example.bootemo.model.InoteType;

public interface NoteTypeService {

    Iterable<InoteType> findAll();

    InoteType findById(Integer id);

    void save(InoteType inoteType);

    void remove(Integer id);
}
