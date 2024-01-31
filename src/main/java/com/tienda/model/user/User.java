package com.tienda.model.user;
import java.util.Date;

public class User {
    private final String id;
    private final Date createdAt;
    private String name;
    private String lastName;
    private String email;
    private String password;


    public User(String id, Date createdAt, String name, String lastName, String email, String password) {
        this.id = (id != null) ? id : generateId();
        this.createdAt = createdAt;
        this.name = name;
        this.lastName = lastName;
        this.email = email;
        this.password = password;
    }

    private String generateId(){
        int id = 0;
        return generateId().toString() + 1;
    }

    public String getId() {
        return id;
    }

    public Date getCreatedAt() {
        return createdAt;
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

}
