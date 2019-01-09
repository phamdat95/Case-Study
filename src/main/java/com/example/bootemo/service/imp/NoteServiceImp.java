package com.example.bootemo.service.imp;

import com.example.bootemo.model.Inote;
import com.example.bootemo.repository.NoteRepository;
import com.example.bootemo.service.NoteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public class NoteServiceImp implements NoteService {
    @Autowired
    private NoteRepository noteRepository;

    @Override
    public Page<Inote> findAll(Pageable pageable) {
        return noteRepository.findAll(pageable);
    }

    @Override
    public Inote findById(Integer id) {
        return noteRepository.findById(id).get();
    }

    @Override
    public void save(Inote inote) {
        noteRepository.save(inote);
    }

    @Override
    public void remove(Integer id) {
        noteRepository.delete(findById(id));
    }

    @Override
    public Page<Inote> findAllByTitleContaining(String title, Pageable pageable) {
        return noteRepository.findAllByTitleContaining(title,pageable);
    }
}
