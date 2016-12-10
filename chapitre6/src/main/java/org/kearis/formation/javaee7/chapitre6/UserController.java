package org.kearis.formation.javaee7.chapitre6;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.bean.ManagedBean;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class UserController implements Serializable {

    @EJB
    private UserEJB userEJB;
    private static final long serialVersionUID = 1L;

    private JsfUser jsfUser = new JsfUser();
    private boolean isError;

    public String doCreateUser() {
        userEJB.createUser(jsfUser);
        return "listeUser.xhtml";
    }

    public String pageCreateUser() {
        return "bonjour.xhtml";
    }

    public JsfUser getJsfUser() {
        return jsfUser;
    }

    public String doFindUser(){

        jsfUser = userEJB.getUser(jsfUser.getId());
        isError = jsfUser == null ? true : false;
        return "viewUser.xhtml";
    }

    public boolean isError() {
        return isError;
    }
}