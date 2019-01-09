package com.example.bootemo.service;

import com.example.bootemo.model.Inote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface NoteService {
    Page<Inote> findAll(Pageable pageable);

    Inote findById(Integer id);

    void save(Inote inote);

    void remove(Integer id);

    Page<Inote> findAllByTitleContaining(String title, Pageable pageable);
}
