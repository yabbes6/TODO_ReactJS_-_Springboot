package com.example.server.POJO;

import lombok.Data;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import java.io.Serializable;


@NamedQuery(name = "User.findByEmailId",query="select u from User u where u.email=:email")

@NamedQuery(name= "User.getAllUser" ,query="select new com.example.server.wrapper.UserMapper(u.id,u.name,u.email,u.contactNumber) from User u where u.role='user'")

@NamedQuery(name = "User.getAllAdmin",query="select u.email from User u where u.role='admin'")

@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name = "user")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy =GenerationType.IDENTITY)
    @Column(name = "id")
    private Integer id;

    @Column(name = "name")
    private String name;

    @Column(name = "contactNumber")
    private String contactNumber;

    @Column(name = "email")
    private String email;

    @Column(name = "password")
    private String password;

    @Column(name = "role")
    private String role;
}
