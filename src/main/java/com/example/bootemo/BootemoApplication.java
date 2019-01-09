package com.example.bootemo;

import com.example.bootemo.service.NoteService;
import com.example.bootemo.service.NoteTypeService;
import com.example.bootemo.service.imp.NoteServiceImp;
import com.example.bootemo.service.imp.NoteTypeServiceImp;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class BootemoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BootemoApplication.class, args); }

@Bean
	public NoteService noteService(){
		return new NoteServiceImp();
}
@Bean
	public NoteTypeService noteTypeService(){
		return new NoteTypeServiceImp();
}
}

