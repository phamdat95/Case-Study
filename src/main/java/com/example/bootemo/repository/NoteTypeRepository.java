package com.example.bootemo.repository;

import com.example.bootemo.model.InoteType;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteTypeRepository extends PagingAndSortingRepository<InoteType,Integer> {
}
