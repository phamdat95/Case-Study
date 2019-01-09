package com.example.bootemo.formatter;

import com.example.bootemo.model.InoteType;
import com.example.bootemo.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import java.text.ParseException;
import java.util.Locale;

@Component
public class InoteTypeFormatter implements Formatter<InoteType> {

    private NoteTypeService noteTypeService;

    @Autowired
    public InoteTypeFormatter(NoteTypeService noteTypeService) {
        this.noteTypeService = noteTypeService;
    }

    @Override
    public InoteType parse(String text, Locale locale) throws ParseException {
        return noteTypeService.findById(Integer.parseInt(text));
    }

    @Override
    public String print(InoteType object, Locale locale) {
        return null;
    }

}