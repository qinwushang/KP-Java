package com.example.repository;

import com.example.domain.Node.Drug;
import com.example.domain.kp;
import org.neo4j.driver.Result;
import org.neo4j.driver.internal.value.ListValue;
import org.neo4j.driver.internal.value.MapValue;
import org.neo4j.driver.internal.value.PathValue;
import org.springframework.data.neo4j.repository.Neo4jRepository;
import org.springframework.data.neo4j.repository.query.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.data.neo4j.core.Neo4jClient;
import java.util.Collection;
import java.util.List;
import java.util.Map;

@Repository
public interface DrugRepository extends Neo4jRepository<Drug, Long> {


//    @Query("match (a{name:$aname})-[r{name:$rname}]-(b) return properties(b)")
//    List<Object> getRelationshipByName(@Param("aname") String aname,@Param("rname") String rname);
    
    @Query(value = "match (a{name:$aname})-[r]-(b) return id(a),labels(a),properties(a),id(r),type(r),properties(r),id(b), labels(b),properties(b) limit 1")
    PathValue getRelationshipByName(@Param("aname") String aname);

    @Query("match (a{name:$name})-[r]-(b) return a")
    Drug findFirstByName(@Param("name") String name);

    @Query("MATCH (a:drug{name: $start_node_name})-[r]->(b) RETURN id(a),labels(a),properties(a),id(r),type(r),properties(r) limit $num")
    List<Drug> query_onestart_relationship(@Param("start_node_name") String start_node_name, @Param("num") Integer num);

    @Query("CREATE (a:drug{name: $drugname})-[r:leadto{name:'导致'}]->(b:symptom{name: $symptomname})")
    void creatLeadToSymptom(@Param("drugname") String drugname, @Param("symptomname") String symtomname);

    @Query("CREATE (a:drug{name: $drugname})-[r:cureS{name:'治疗'}]->(b:symptom{name: $symptomname})")
    void creatCureSSymptom(@Param("drugname") String drugname, @Param("symptomname") String symtomname);

    @Query("CREATE (a:drug{name: $drugname})-[r:avoid{name:'避免'}]->(b:symptom{name: $symptomname})")
    void creatAvoidSymptom(@Param("drugname") String drugname, @Param("symptomname") String symtomname);

    @Query("CREATE (a:drug{name: $drugname})-[r:cureD{name:'治愈'}]->(b:symptom{name: $diseasename})")
    void creatCureDSymptom(@Param("drugname") String drugname, @Param("diseasename") String diseasename);


}
