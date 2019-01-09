package com.example.bootemo.controller;

import com.example.bootemo.model.Inote;
import com.example.bootemo.model.InoteType;
import com.example.bootemo.service.NoteService;
import com.example.bootemo.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class InoteController {
    @Autowired
    private NoteTypeService noteTypeService;

    @Autowired
    private NoteService noteService;

    @ModelAttribute("noteType")
    public Iterable<InoteType> inoteTypes(){
        return noteTypeService.findAll();
    }

    @GetMapping("list")
    public ModelAndView showList(@PageableDefault(size = 5) Pageable pageable){
        Page<Inote> inotes = noteService.findAll(pageable);
        return new ModelAndView("inote/list","inote",inotes);
    }

    @GetMapping("create")
    public ModelAndView showForm(){
        return new ModelAndView("inote/create", "inote",new Inote());
    }
    @PostMapping("create")
    public ModelAndView createInote(@ModelAttribute("inote") Inote inote){
        noteService.save(inote);
        return new ModelAndView("inote/create","message","success");
    }
    @GetMapping("delete/{id}")
    public ModelAndView showDeleteFrom(@PathVariable Integer id){
        Inote inote = noteService.findById(id);
        return new ModelAndView("inote/delete", "inote",inote);
    }
    @PostMapping("delete")
    public ModelAndView deleteInote(@ModelAttribute Inote inote) {
        noteService.remove(inote.getId());
        return new ModelAndView("redirect:list");
    }

    @GetMapping("list-search")
    public ModelAndView showListSearch(@RequestParam("s") String a, @PageableDefault(size = 5) Pageable pageable){
        Page<Inote> inotes = noteService.findAllByTitleContaining(a,pageable);
        ModelAndView modelAndView = new ModelAndView("inote/list-search");
        modelAndView.addObject("inote",inotes);
        modelAndView.addObject("s",a);
        return modelAndView;
    }

    @GetMapping("edit/{id}")
    public ModelAndView showFromEdit(@PathVariable Integer id){
        Inote inote = noteService.findById(id);
        return new ModelAndView("inote/edit", "inote",inote);
    }
    @PostMapping("edit")
    public ModelAndView editInote(@ModelAttribute Inote inote){
        noteService.save(inote);
        return new ModelAndView("inote/edit","message","success");
    }
}
