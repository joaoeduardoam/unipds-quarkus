package com.joaoeduardoam;

import jakarta.transaction.*;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.*;
import org.slf4j.*;

import java.util.*;

@Path("/person")

@Produces(MediaType.APPLICATION_JSON)
@Consumes(MediaType.APPLICATION_JSON)
public class PersonResource {

    private static final Logger log = LoggerFactory.getLogger(PersonResource.class);

    @GET
    public List<Person> getPerson() {
        return Person.listAll();
    }

    @GET
    @Path("findByBirthdayYear")
    public List<Person> findByBirthdayYear(@QueryParam("birthdayYear") int birthdayYear) {
        return Person.findByBirthdayYear(birthdayYear);
    }

    @POST
    @Transactional
    public Person addPerson(Person person) {
        person.id = null;
        person.persist();
        return person;
    }

    @PUT
    @Transactional
    public Person updatePerson(Person person) {
        Person p = Person.findById(person.id);
        p.name = person.name;
        p.birthdayYear = person.birthdayYear;
        p.persist();
        return person;
    }

    @DELETE
    @Transactional
    public void deletePerson(int id) {
        Person.deleteById(id);
    }

}
