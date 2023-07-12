package com.example.controller;

import com.example.domain.Node.Disease;
import com.example.service.DiseaseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/disease")
public class DiseaseController {
    @Autowired
    private DiseaseService diseaseService;

    @GetMapping("/get_all_disease")
    public List<Disease> getAllDrug(){
        return diseaseService.getAllDisease();
    }

    @GetMapping("/get_disease")
    public Disease getDrug(@RequestParam("name")String name){
        return diseaseService.getDiseaseByName(name);
    }

    @PostMapping("/add_disease")
    public Disease addDrug(@RequestParam("name")String name){
        return diseaseService.addDisease(name);
    }

    @DeleteMapping("/delete_disease")
    public void deleteDrug(@RequestParam("name")String name){
        diseaseService.deleteDisease(name);
    }

    @PostMapping("/add_lead_relationship")
    public void addLeadRelationship(
            @RequestParam("disease")String diseasename,
            @RequestParam("symptom")String symptomname
    ){
        diseaseService.addLeadRelationship(diseasename, symptomname);
    }
}
