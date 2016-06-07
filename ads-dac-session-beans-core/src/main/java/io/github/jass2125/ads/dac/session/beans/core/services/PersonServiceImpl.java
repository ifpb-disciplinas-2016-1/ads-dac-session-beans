/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.ads.dac.session.beans.core.services;

import io.github.jass2125.ads.dac.session.beans.interfaces.entity.Person;
import io.github.jass2125.ads.dac.session.beans.interfaces.services.PersonService;
import io.github.jass2125.sistema.alocacao.core.factory.ConnectionFactory;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author Anderson Souza
 */
@Stateless
@Remote(PersonService.class)
public class PersonServiceImpl implements PersonService {

    private final ConnectionFactory connectionFactory;

    public PersonServiceImpl() {
        connectionFactory = new ConnectionFactory();
    }

    @Override
    public void save(Person person) throws SQLException, ClassNotFoundException {
        Connection con = connectionFactory.getConnection();
        String sql = "insert into person(name, nickname, email) values(?, ?, ?);";
        PreparedStatement ps = con.prepareStatement(sql);
        ps.setString(1, person.getName());
        ps.setString(2, person.getNickname());
        ps.setString(3, person.getEmail());
        ps.execute();
    }

    @Override
    public List<Person> list() throws SQLException, ClassNotFoundException {
        Connection con = connectionFactory.getConnection();
        String sql = "select * from person;";
        PreparedStatement ps = con.prepareStatement(sql);
        ResultSet rs = ps.executeQuery();
        List<Person> listPerson = new ArrayList<>();
        Person person = null;
        while (rs.next()) {
            int id = rs.getInt("id");
            String name = rs.getString("name");
            String nickname = rs.getString("nickname");
            String email = rs.getString("email");
            person = new Person(id, name, nickname, email);
            listPerson.add(person);
        }
        return listPerson;
    }

}

//create table person(
//    id int auto_increment,
//    name varchar(40),
//    nickname varchar(40),
//    email varchar(40),
//    age int,
//    primary key(id)
//);
