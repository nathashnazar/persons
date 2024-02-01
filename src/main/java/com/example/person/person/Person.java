package com.example.person.person;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Person {

    @Id
    private Integer id;
    private String name;
    private String mobile;
    private String email;

}
