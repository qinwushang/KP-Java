package com.example.controller;


import com.example.domain.Node.Drug;
import com.example.service.DrugService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/drug")
public class DrugController {
    @Autowired
    private DrugService drugService;

    @GetMapping
    public void GetAllByName(@RequestParam("aname")String aname){
        System.out.println(drugService.getRelationshipByName(aname).toString());
    }

    @GetMapping("/get_all_drug")
    public List<Drug> getAllDrug(){
        return drugService.getAllDrug();
    }

    @GetMapping("/get_drug")
    public Drug getDrug(@RequestParam("name")String name){
        return drugService.getDrugByName(name);
    }

    @PostMapping("/add_drug")
    public Drug addDrug(@RequestParam("name")String name){
        return drugService.addDrug(name);
    }

    @DeleteMapping("/delete_drug")
    public void deleteDrug(@RequestParam("name")String name){
        drugService.deleteDrug(name);
    }

    @PostMapping("/add_lead_relationship")
    public void addLeadRelationship(
            @RequestParam("drug")String drugname,
            @RequestParam("symptom")String symptomname
    ){
        drugService.addLeadRelationship(drugname, symptomname);
    }

    @PostMapping("/add_cured_relationship")
    public void addCureDRelationship(
            @RequestParam("drug")String drugname,
            @RequestParam("diseasename")String diseasename
    ){
        drugService.addCureDRelationship(drugname, diseasename);
    }

    @PostMapping("/add_cures_relationship")
    public void addCureSRelationship(
            @RequestParam("drug")String drugname,
            @RequestParam("symptom")String symptomname
    ){
        drugService.addCureSRelationship(drugname, symptomname);
    }

    @PostMapping("/add_avoid_relationship")
    public void addAvoidRelationship(
            @RequestParam("drug")String drugname,
            @RequestParam("symptom")String symptomname
    ){
        drugService.addAvoidRelationship(drugname, symptomname);
    }


//    MATCH (n) OPTIONAL MATCH (n)-[r]-() DELETE n,r

}
