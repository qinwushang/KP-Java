package com.example.repository;

import com.example.domain.Node.Drug;
import org.neo4j.driver.Result;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@Repository
public interface NodeRepository extends Neo4jRepository<Drug, Long> {


//    @Query("MATCH (a{name: $start_node_name})-[r]->(b) RETURN id(a),labels(a),properties(a),id(r),type(r),properties(r) ,id(b), labels(b),properties(b) limit 15")
    @Query("MATCH (a{name: $start_node_name})-[r]->(b) RETURN a,r,b limit 1")
    Result query_onestart_relationship(@Param("start_node_name") String start_node_name, @Param("num") Integer num);

//    @Query("CREATE (a:drug{name: $drugname})-[r:cureS{name:'治疗'}]->(b:symptom{name: $symptomname})")
//    void creatCureSSymptom(@Param("drugname") String drugname, @Param("symptomname") String symtomname);
//
//    @Query("CREATE (a:drug{name: $drugname})-[r:avoid{name:'避免'}]->(b:symptom{name: $symptomname})")
//    void creatAvoidSymptom(@Param("drugname") String drugname, @Param("symptomname") String symtomname);
//
//    @Query("CREATE (a:drug{name: $drugname})-[r:cureD{name:'治愈'}]->(b:symptom{name: $diseasename})")
//    void creatCureDSymptom(@Param("drugname") String drugname, @Param("diseasename") String diseasename);

}
