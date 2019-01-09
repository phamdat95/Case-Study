package com.example.bootemo.service.imp;

import com.example.bootemo.model.InoteType;
import com.example.bootemo.repository.NoteTypeRepository;
import com.example.bootemo.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;

public class NoteTypeServiceImp implements NoteTypeService {
    @Autowired
    private NoteTypeRepository noteTypeRepository;

    @Override
    public Iterable<InoteType> findAll() {
        return noteTypeRepository.findAll();
    }

    @Override
    public InoteType findById(Integer id) {
        return noteTypeRepository.findById(id).get();
    }

    @Override
    public void save(InoteType inoteType) {
        noteTypeRepository.save(inoteType);
    }

    @Override
    public void remove(Integer id) {
        noteTypeRepository.delete(findById(id));
    }
}
