package com.example.repository;

import com.example.domain.Node.Disease;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;

public interface DiseaseRepository extends Neo4jRepository<Disease, Long> {
    Disease findFirstByName(String name);

    @Query("CREATE (a:drug{name: $diseasename})-[r:leadto{name:'导致'}]->(b:symptom{name: $symptomname})")
    void creatLeadToSymptom(@Param("diseasename") String diseasename, @Param("symptomname") String symtomname);
}
