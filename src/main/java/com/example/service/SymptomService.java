package com.example.service;

import com.example.domain.Node.Drug;
import com.example.domain.Node.Symptom;
import com.example.repository.DrugRepository;
import com.example.repository.SymptomRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SymptomService {
    @Autowired
    private SymptomRepository symptomRepository;

    public List<Symptom> getAllSymptom(){
        return symptomRepository.findAll();
    }

    public Symptom getSymptomByName(String name){
        return symptomRepository.findFirstByName(name);
    }

    public Symptom addSymptom(String name){
        return symptomRepository.save(Symptom.builder().name(name).build());
    }

    public void deleteSymptom(String name){
        symptomRepository.delete(getSymptomByName(name));
    }

}
