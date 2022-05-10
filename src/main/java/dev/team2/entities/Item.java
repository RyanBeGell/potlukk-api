package dev.team2.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Table(name = "item")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class Item {

    @Id //Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="item_id")
    int itemId;

    @Column(name="description")
    String description;

    @Column(name="status")
    String status;

    @Column(name="supplier")
    String supplier;

    @Column(name="potluck_id")
    int potluckId;
}
