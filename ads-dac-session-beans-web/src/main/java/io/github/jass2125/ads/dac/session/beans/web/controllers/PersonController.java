/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.ads.dac.session.beans.web.controllers;

import io.github.jass2125.ads.dac.session.beans.interfaces.entity.Person;
import io.github.jass2125.ads.dac.session.beans.interfaces.services.PersonService;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.bean.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Anderson Souza
 */
@Named
@ViewScoped
public class PersonController {

    private Person person;
    private List<Person> listPerson;
    @EJB
    private PersonService personService;

    public PersonController() {
        this.person = new Person();
        this.listPerson = new ArrayList<>();
    }

    public List<Person> getListPerson() {
        return listPerson;
    }

    public void setListPerson(List<Person> listPerson) {
        this.listPerson = listPerson;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }

    public void persistPerson() {
        try {
            this.personService.save(person);
        } catch (SQLException | ClassNotFoundException e) {
        }
    }

    public List<Person> getPersons() {
        return null;
    }
}
