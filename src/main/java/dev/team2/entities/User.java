package dev.team2.entities;


import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "registereduser")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class User {
    @Id// this is the field that is the primary key
    @Column(name = "username")
    private String username;

    @Column(name = "first_name")
    private String firstName;

    @Column(name = "last_name")
    private String lastName;

    @Column(name = "password")
    private String password;

}