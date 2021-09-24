package com.santiquiroz.restapi.models;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "category")
public class Category {

    @Id
    @Getter @Setter @Column(name = "id")
    private String id;

    public Category(){

    }

    public Category(String id){
        this.id=id;
    }

}
