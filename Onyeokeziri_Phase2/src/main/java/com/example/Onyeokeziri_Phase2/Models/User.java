package com.example.Onyeokeziri_Phase2.Models;

import org.hibernate.query.criteria.internal.ValueHandlerFactory;

import javax.persistence.*;

@Entity
@Table(name= "User")
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)

    @Column(name= "userID")
    private ValueHandlerFactory.LongValueHandler userID;
    @Column(name="username")
    private String userName;
    @Column(name="password")
    private String password;
    @Column(name="Role")
    private String Role;
    @Column (name="Email")
    private String Email;

    public User(ValueHandlerFactory.LongValueHandler userID, String userName, String password, String role, String email) {
        this.userID = userID;
        this.userName = userName;
        this.password = password;
        Role = role;
        Email = email;
    }

    public User() {

    }


    public ValueHandlerFactory.LongValueHandler getUserID() {
        return userID;
    }

    public void setUserID(ValueHandlerFactory.LongValueHandler userID) {
        this.userID = userID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRole() {
        return Role;
    }

    public void setRole(String role) {
        Role = role;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
