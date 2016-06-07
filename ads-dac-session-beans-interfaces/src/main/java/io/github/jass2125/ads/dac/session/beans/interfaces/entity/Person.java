/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.ads.dac.session.beans.interfaces.entity;

import java.io.Serializable;

/**
 *
 * @author Anderson Souza
 */
//create table person(
//    id int auto_increment,
//    name varchar(40),
//    nickname varchar(40),
//    email varchar(40),
//    age int,
//    primary key(id)
//);
public class Person implements Serializable {

    private int id;
    private String name;
    private String nickname;
    private String email;

    public Person() {
    }

    public Person(String name, String nickname, String email) {
        this.name = name;
        this.nickname = nickname;
        this.email = email;
    }

    public Person(int id, String name, String nickname, String email) {
        this(name, nickname, email);
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}
