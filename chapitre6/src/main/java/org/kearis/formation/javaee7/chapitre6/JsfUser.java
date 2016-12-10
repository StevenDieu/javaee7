package org.kearis.formation.javaee7.chapitre6;

import javax.persistence.*;

import static org.kearis.formation.javaee7.chapitre6.JsfUser.*;

/**
 * Created by steven on 08/12/2016.
 */
@Entity
@NamedQuery(name = FIND_ALL, query = "SELECT b FROM JsfUser b")
public class JsfUser {

    public static final String FIND_ALL = "User.findAllUser";


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private String name;
    private String lastName;
    private String mail;
    private String password;

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

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
