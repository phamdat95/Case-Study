package com.example.bootemo.repository;

import com.example.bootemo.model.Inote;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface NoteRepository extends PagingAndSortingRepository<Inote,Integer> {

    Page<Inote> findAllByTitleContaining(String title, Pageable pageable);


}
