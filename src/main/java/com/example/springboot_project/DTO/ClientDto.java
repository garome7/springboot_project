package com.example.springboot_project.DTO;

public class ClientDto {
    private Long id;
    private String name;
    private String lastName;
    private String phoneNum;
    private String email;
    private int clientNum;
    public Long getId() {
        return id;
    }

    public int getClientNum() {return clientNum;}
    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNum() {
        return phoneNum;
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

    public void setPhoneNum(String phoneNum) {
        this.phoneNum = phoneNum;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setClientNum(int clientNum) {this.clientNum = clientNum;}
}
