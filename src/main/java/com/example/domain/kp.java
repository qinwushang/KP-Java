package com.example.domain;

import lombok.Data;

import java.util.Dictionary;
import java.util.List;

//MATCH (a{name:''})-[r]->(b) RETURN id(a),labels(a),properties(a),id(r),type(r),properties(r),id(b), labels(b),properties(b)
@Data

public class kp {
    private Integer id_a;
    private Integer id_r;
    private Integer id_b;
    private String type_r;
    private List<String> labels_a;
    private List<String> labels_b;
    private Dictionary<String,String> properties_a;
    private Dictionary<String,String> properties_b;

    public Integer getID_a() {
        return id_a;
    }
    public void setID_a(Integer id_a) {
        this.id_a = id_a;
    }
//    public List getAll() {
//
//        return ;
//    }
}
