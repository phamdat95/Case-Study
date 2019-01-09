package com.example.bootemo.controller;

import com.example.bootemo.model.Inote;
import com.example.bootemo.model.InoteType;
import com.example.bootemo.service.NoteTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class NoteTypeController {
    @Autowired
    private NoteTypeService noteTypeService;

    @GetMapping("list-type")
    public ModelAndView showList(@PageableDefault(size = 5) Pageable pageable){
        Iterable<InoteType> inotes = noteTypeService.findAll();
        return new ModelAndView("noteType/list","type",inotes);
    }

    @GetMapping("create-type")
    public ModelAndView showForm(){
        return new ModelAndView("noteType/create", "type",new InoteType());
    }
    @PostMapping("create-type")
    public ModelAndView createInote(@ModelAttribute("type") InoteType inote){
        noteTypeService.save(inote);
        return new ModelAndView("noteType/create","message","success");
    }
    @GetMapping("delete-type/{id}")
    public ModelAndView showDeleteFrom(@PathVariable Integer id){
        InoteType inote = noteTypeService.findById(id);
        return new ModelAndView("noteType/delete", "type",inote);
    }
    @PostMapping("delete-type")
    public ModelAndView deleteInote(@ModelAttribute InoteType inote) {
        noteTypeService.remove(inote.getId());
        return new ModelAndView("redirect:list-type");
    }
    @GetMapping("edit-type/{id}")
    public ModelAndView showFromEdit(@PathVariable Integer id){
        InoteType inote = noteTypeService.findById(id);
        return new ModelAndView("noteType/edit", "inote",inote);
    }
    @PostMapping("edit-type")
    public ModelAndView editInote(@ModelAttribute InoteType inote){
        noteTypeService.save(inote);
        return new ModelAndView("noteType/edit","message","success");
    }
}
