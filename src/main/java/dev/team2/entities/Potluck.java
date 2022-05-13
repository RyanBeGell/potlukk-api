package dev.team2.entities;

import lombok.*;

import javax.persistence.*;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

@Entity
@Table(name="potluck")
//lombok @Data not recommended being used with spring
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Potluck {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="potluck_id")
    private int potluckID;

    @Column(name="datetime")
    private long dateTime;

    @Column(name="creator")
    private String creator;

    @Column(name="is_private")
    private boolean isPrivate;

    @Column(name="url")
    private String url;

    @Column(name = "description")
    private String description;
}
