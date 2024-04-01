package com.example.springboot_project.model;

import javax.persistence.*;


@Entity
@Table(
        name = "dataClient", uniqueConstraints = {@UniqueConstraint(columnNames = {"id"})}
)
public class Client {
    //(que incluya id, nombre, apellido, telefono, numeroCliente, email)
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(name = "name", nullable = false)
    private String name;
    @Column(name = "lastName", nullable = false)
    private String lastName;
    @Column(name = "phoneNumber", nullable = false)
    private String phoneNumber;
    @Column(name = "clientNum", nullable = false)
    private int clientNum;
    @Column(name = "email", nullable = false)
    private String email;


    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public int getClientNum() {
        return clientNum;
    }

    public String getEmail() {
        return email;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setClientNum(int clientNum) {
        this.clientNum = clientNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
