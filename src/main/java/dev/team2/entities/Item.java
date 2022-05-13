package dev.team2.entities;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "item")
//lombok @Data not recommended being used with spring
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
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
