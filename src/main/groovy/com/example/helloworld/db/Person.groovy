package com.example.helloworld.db

import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.Id
import javax.persistence.Table
import groovy.transform.ToString

@Entity
@Table(name = 'people')
@ToString
public class Person {

    @Id
    String name

    @Column
    String email

}
