package com.example.domain.Relationship;


import com.example.domain.Node.Disease;
import com.example.domain.Node.Drug;
import com.example.domain.Node.Symptom;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.Dictionary;


@RelationshipProperties
@Data
@Builder
public class Lead {
    @Id
    @GeneratedValue
    Long id;

    @Property(name = "type")
    private String type;

    @Property(name = "properties")
    private Dictionary<String,String> properties;

    @TargetNode
    private Symptom symptom;

}
