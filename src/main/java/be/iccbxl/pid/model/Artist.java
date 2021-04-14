package be.iccbxl.pid.model;

import lombok.Data;

import javax.persistence.*;
@Data //no setter no getter ,with this annotation is inside
@Entity
@Table(name="artists")
public class Artist {
    @Id //clef primaire, identifiant unique
    @GeneratedValue(strategy=GenerationType.AUTO) //auto generate
    private Long id;
    private String firstname;
    private String lastname;


}
