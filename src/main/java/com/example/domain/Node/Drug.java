package com.example.domain.Node;

import com.example.domain.Relationship.Lead;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.*;

@Node(primaryLabel = "drug")
@Data
@Builder
public class Drug {
    @Id
    @GeneratedValue
    Long id;

    @Property(name = "name")
    private String name;

    @Property(name = "properties")
    Dictionary<String,String> properties;

    @Property(name = "labels")
    List<String> labels;




    @Relationship(type = "drug_lead_symptom",direction = Relationship.Direction.OUTGOING)
    private List<Lead> drug_lead_symptom;
//
//    @Relationship(type = "avoid", direction = Relationship.Direction.OUTGOING)
//    private List<Avoid> avoid;
//
//    @Relationship(type = "cures", direction = Relationship.Direction.OUTGOING)
//    private List<CureS> cureS;
//
//    @Relationship(type = "cured", direction = Relationship.Direction.OUTGOING)
//    private List<CureD> cureD;



}
