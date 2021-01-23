package com.api.nuvu.NuvuAPI.controller;

import com.api.nuvu.NuvuAPI.model.Person;
import com.api.nuvu.NuvuAPI.service.api.IPersonServiceAPI;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PersonController {

    @Autowired
    private IPersonServiceAPI personServiceAPI;

    @RequestMapping("/")
    public String index(Model model) {
        model.addAttribute("list",personServiceAPI.getAll());
        return "index";
    }

    @GetMapping("/save/{id}")
    public String showSave(@PathVariable("id") Integer id, Model model){
        if(id != null && id != 0) {
            model.addAttribute("person", personServiceAPI.get(id));
        } else {
            model.addAttribute("person", new Person());
        }
        return "save";
    }

    @PostMapping("/save")
    public String save(Person person, Model model) {
        personServiceAPI.save(person);
        return "redirect:/";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable Integer id, Model model) {
        personServiceAPI.delete(id);
        return "redirect:/";
    }
}
