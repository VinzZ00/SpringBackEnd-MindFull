package com.minidfull.backend.entity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Date;
import java.util.List;


@Entity(name = "goals")
@Setter @Getter @NoArgsConstructor @ToString
public class Goals {
    @SequenceGenerator(
            name = "goalIdSequence",
            sequenceName = "goalSeq",
            allocationSize = 1
    )

    @Id
    @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "goalSeq"
    )
    private long goalId;

    // Column
    private String name;
    private String goalIndicator;
    private Date timeBound;
    private Date dateCreatedAt;
    private int priority;

    // Relationship
    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.EAGER)
    @JoinColumn(name = "GoalId", referencedColumnName = "goalId")
    private List<Steps> steps;
}
