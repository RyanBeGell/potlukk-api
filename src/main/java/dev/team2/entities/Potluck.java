package dev.team2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name="potluck")
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
}
