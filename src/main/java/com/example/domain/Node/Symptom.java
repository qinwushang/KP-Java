package com.example.domain.Node;

//import com.example.domain.Relationship.CureS;
//import com.example.domain.Relationship.Lead;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.*;

@Node(primaryLabel = "symptom")
@Data
@Builder
public class Symptom {
    @Id
    @GeneratedValue
    Long id;

    @Property(name = "name")
    private String name;

    @Property(name = "properties")
    private Dictionary<String,String> properties;

    @Property(name = "labels")
    private List<String> labels;

}
