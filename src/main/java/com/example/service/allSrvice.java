package com.example.service;
import com.example.domain.kp;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.springframework.data.neo4j.core.ReactiveNeo4jClient;
import reactor.core.publisher.Flux;

import java.util.Collection;
import java.util.List;
import java.util.Map;

public class allSrvice {
    Driver driver = GraphDatabase.driver("neo4j://localhost:7687");

    ReactiveNeo4jClient client = ReactiveNeo4jClient.create(driver);
    Flux<Map<String, Object>> all =  client
            .query("MATCH (a{name:'独一味胶囊'})-[r]->(b) RETURN id(a),labels(a),properties(a),id(r),type(r),properties(r),id(b), labels(b),properties(b)")
            .fetch()
            .all();
    public String ret(){
        return new String(String.valueOf(all));
    }
    public static void main(String...args){
        System.out.println(new allSrvice().ret());
    }
}
