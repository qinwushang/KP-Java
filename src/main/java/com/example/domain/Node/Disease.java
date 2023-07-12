package com.example.domain.Node;

//import com.example.domain.Relationship.Lead;
import lombok.Builder;
import lombok.Data;
import org.springframework.data.neo4j.core.schema.*;

import java.util.*;

@Node(primaryLabel = "disease")
@Data
@Builder
public class Disease {
    @Id
    @GeneratedValue
    Long id;

    @Property(name = "name")
    private String name;

//    @Relationship(type = "lead", direction = Relationship.Direction.OUTGOING)
//    private List<Lead> lead;
}
