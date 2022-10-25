package com.tesco.store.cqrs;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity

public class Store {
    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    private String name;
//    @NotNull
//    private Integer numberOfTills;
//    @NotNull
//    private String type;

    public Long getId() {return id;}

    public void setId(Long id) {this.id = id;}

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

//    public Integer getNumberOfTills() {
//        return numberOfTills;
//    }
//
//    public void setNumberOfTills(Integer numberOfTills) {
//        this.numberOfTills = numberOfTills;
//    }
//
//    public String getType() {
//        return type;
//    }
//
//    public void setType(String type) {
//        this.type = type;
//    }
}
