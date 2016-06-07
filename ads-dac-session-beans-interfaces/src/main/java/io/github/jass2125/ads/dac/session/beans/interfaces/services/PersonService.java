/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.ads.dac.session.beans.interfaces.services;

import io.github.jass2125.ads.dac.session.beans.interfaces.entity.Person;
import java.sql.SQLException;
import java.util.List;

/**
 *
 * @author Anderson Souza
 */
public interface PersonService {

    public void save(Person person) throws SQLException, ClassNotFoundException;

    public List<Person> list() throws SQLException, ClassNotFoundException;

}
