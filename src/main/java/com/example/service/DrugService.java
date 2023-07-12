package com.example.service;

import com.example.domain.Node.Drug;
import com.example.domain.kp;
import com.example.repository.DrugRepository;
import com.example.repository.SymptomRepository;
import org.neo4j.driver.Result;
import org.neo4j.driver.internal.value.ListValue;
import org.neo4j.driver.internal.value.MapValue;
import org.neo4j.driver.internal.value.PathValue;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Service;

import java.nio.file.Path;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Service
public class DrugService {
    @Autowired
    private DrugRepository drugRepository;

    @Autowired
    private SymptomRepository symptomRepository;

    public List<Drug> getAllDrug(){
        return drugRepository.findAll();
    }
    public void getALLByName(String name, Integer num){
        List<Drug> ret = drugRepository.query_onestart_relationship(name,num);
        System.out.println(ret);
    }

    public PathValue getRelationshipByName(String aname){
        return drugRepository.getRelationshipByName(aname);
    }

//    Collection<Map<String, Object>> all = neo4jClient
//            .query("match (n:People) return n.group as `group`,count(n) as `num`")
//            .fetch().all();


    public Drug getDrugByName(String name){
        Drug ret = drugRepository.findFirstByName(name);
        System.out.println(ret.getName());
        return ret;
    }

    public Drug addDrug(String name){
        return drugRepository.save(Drug.builder().name(name).build());
    }

    public void deleteDrug(String name){
        drugRepository.delete(getDrugByName(name));
    }

    public void addLeadRelationship(String drugName, String symptomName){
        drugRepository.creatLeadToSymptom(drugName,symptomName);
        System.out.println(drugName+" +导致+ "+symptomName+" 添加成功！");
    }

    public void addCureDRelationship(String drugName, String diseasename){
        drugRepository.creatCureDSymptom(drugName,diseasename);
        System.out.println(drugName+" +治愈+ "+diseasename+" 添加成功！");
    }

    public void addCureSRelationship(String drugName, String symptomName){
        drugRepository.creatCureSSymptom(drugName,symptomName);
        System.out.println(drugName+" +治疗+ "+symptomName+" 添加成功！");
    }

    public void addAvoidRelationship(String drugName, String symptomName){
        drugRepository.creatAvoidSymptom(drugName,symptomName);
        System.out.println(drugName+" +避免+ "+symptomName+" 添加成功！");
    }

}


