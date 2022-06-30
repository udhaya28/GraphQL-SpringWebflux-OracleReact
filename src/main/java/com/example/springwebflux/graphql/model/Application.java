package com.example.springwebflux.graphql.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;

@Setter
@Getter
@Table("application")
public class Application {


    @Id
    @Column( "ID")
    private Long appId;

    @Column( "CODE")
    private String code;

    @Column( "DESCRIPTION")
    private String description;

    @Column( "NAME")
    private String name;
}
