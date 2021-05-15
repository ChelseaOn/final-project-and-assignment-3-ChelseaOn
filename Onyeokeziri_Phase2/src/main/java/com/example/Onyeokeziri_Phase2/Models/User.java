package com.example.Onyeokeziri_Phase2.Models;

import org.hibernate.query.criteria.internal.ValueHandlerFactory;

import javax.persistence.*;

@Entity
@Table (name="User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name= "userID")
    private int userid;
    @Column(name="UserName")
    private String username;
    @Column(name="password")
    private String password;
    @Column(name="Role")
    private String role;
    @Column (name="Email")
    private String email;

    public int getUserid() {
        return userid;
    }

    public void setUserid(int userid) {
        this.userid = userid;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}


