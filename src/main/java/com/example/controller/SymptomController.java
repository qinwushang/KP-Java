package com.example.controller;

import com.example.domain.Node.Drug;
import com.example.domain.Node.Symptom;
import com.example.service.SymptomService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/symptom")
public class SymptomController {
    @Autowired
    private SymptomService symptomService;

    @GetMapping("/get_all_symptom")
    public List<Symptom> getAllSymptom(){
        return symptomService.getAllSymptom();
    }

    @GetMapping("/get_symptom")
    public Symptom getSymptom(@RequestParam("name")String name){
        return symptomService.getSymptomByName(name);
    }

    @PostMapping("/add_symptom")
    public Symptom addSymptom(@RequestParam("name")String name){
        return symptomService.addSymptom(name);
    }

    @DeleteMapping("/delete_symptom")
    public void deleteSymptom(@RequestParam("name")String name){
        symptomService.deleteSymptom(name);
    }

}