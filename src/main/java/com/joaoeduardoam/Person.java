package com.joaoeduardoam;

import io.quarkus.hibernate.orm.panache.*;
import jakarta.persistence.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;

import java.util.*;

@Entity
public class Person extends PanacheEntity {

    public String name;
    public int birthdayYear;

    public static List<Person> findByBirthdayYear(int birthdayYear){

        return find("birthdayYear", birthdayYear).list();

    }


}
