package com.minidfull.backend.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import java.sql.Time;

@Entity(name = "steps") //JPA
@Setter @Getter @ToString @NoArgsConstructor //Lombok
public class Steps {

    @SequenceGenerator(
            name = "stepSequence",
            sequenceName = "stepSeq",
            allocationSize = 1
    )

    @Id @GeneratedValue(
            strategy = GenerationType.SEQUENCE,
            generator = "stepSeq"
    )
    private long stepId;

    // Column
    String motivation;
    @JsonFormat(pattern = "HH:mm:ss")
    @Temporal(TemporalType.TIME)
    Time dailyTime;

    @ManyToOne
    @JoinColumn(name = "goalId", referencedColumnName = "goalId")
    @JsonIgnoreProperties("steps")
    private Goals goal;
}
