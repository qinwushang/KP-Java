package com.example.repository;

import com.example.domain.Node.Drug;
import com.example.domain.Node.Symptom;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SymptomRepository extends Neo4jRepository<Symptom, Long>{
    Symptom findFirstByName(@Param("name") String name);

}
