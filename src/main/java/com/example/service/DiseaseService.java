package com.example.service;

import com.example.domain.Node.Disease;
//import com.example.domain.Node.Symptom;
//import com.example.domain.Relationship.Lead;
import com.example.repository.DiseaseRepository;
import com.example.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiseaseService {
    @Autowired
    private DiseaseRepository diseaseRepository;

    @Autowired
    private SymptomRepository symptomRepository;

    public List<Disease> getAllDisease(){
        return diseaseRepository.findAll();
    }

    public Disease getDiseaseByName(String name){
        return diseaseRepository.findFirstByName(name);
    }

    public Disease addDisease(String name){
        return diseaseRepository.save(Disease.builder().name(name).build());
    }

    public void deleteDisease(String name){
        diseaseRepository.delete(getDiseaseByName(name));
    }

    public void addLeadRelationship(String drugName, String symptomName){
        diseaseRepository.creatLeadToSymptom(drugName,symptomName);
        System.out.println(drugName+" +导致+ "+symptomName+" 添加成功！");
    }
}


