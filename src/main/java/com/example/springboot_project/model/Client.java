package com.example.springboot_project.model;

import lombok.*;

import javax.persistence.*;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(
        name = "dataClient", uniqueConstraints = {@UniqueConstraint(columnNames = {"clientNum"})}
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
    private int phoneNumber;
    @Column(name = "clientNum", nullable = false)
    private int clientNum;
    @Column(name = "email", nullable = false)
    private String email;




}
