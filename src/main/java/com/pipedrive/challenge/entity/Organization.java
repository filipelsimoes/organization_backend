package com.pipedrive.challenge.entity;

import lombok.Data;
import javax.persistence.*;

@Entity
@Table(name = "organization")
@Data
public class Organization {

    @Id
    private Long id;

    @Column(name="name")
    private String name;

    @Column(name="parent")
    private String parent;

    public Organization(Long id, String name, String parent) {
    this.id = id;
    this.name = name;
    this.parent = parent;
    }

    public Organization() {}
}
