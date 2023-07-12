package com.example.controller;

import com.example.service.NodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

@RestController
@RequestMapping
public class NodeController {

    @Autowired
    private NodeService nodeService;


    @GetMapping
    public void get_query_onestart_relationship(@Param("number") Integer num,@Param("name") String name){
        ArrayList<String> a = new ArrayList<>();

        System.out.println(nodeService.query_onestart_relationship(name,num));
    }
}
