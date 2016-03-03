package beans;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

/**
 *
 * @author User
 */
@ManagedBean(name = "loginBean")
@SessionScoped
public class loginBean implements Serializable {

    private String name;
    private String password;
    private boolean isLogged = false;

    public boolean getIsLogged() {
        return isLogged;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
    
    public void logout(){
        isLogged=false;
        name=null;
        password=null;
    }
    
    public String login(){
        if(name.equals("Dima") || password.equals("jhfg51"))
        {
            isLogged=true;//Логика провери с базой данных
            return "forum.xhtml?faces-redirect=true";
        }
        return "login.xhtml?faces-redirect=true";
    }
    
    public loginBean() {
    }
    
}