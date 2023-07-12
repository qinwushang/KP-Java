package com.example.service;

import com.example.domain.Node.Drug;
import com.example.repository.DrugRepository;
import com.example.repository.NodeRepository;
import com.example.repository.SymptomRepository;
import org.neo4j.driver.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Dictionary;
import java.util.HashMap;
import java.util.List;

@Service
public class NodeService {
    @Autowired
    private NodeRepository nodeRepository;

    public Result query_onestart_relationship(String name, Integer num){
        return nodeRepository.query_onestart_relationship(name,num);
    }
}
