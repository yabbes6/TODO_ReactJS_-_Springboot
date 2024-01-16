package com.example.server.POJO;

import jdk.jfr.Name;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Name("planning")
@Entity
public class Plan implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id ;
    @Column(name = "comment")
    private String comment;
    @Column(name = "date")
    private LocalDate date;
    @Column(name = "Time")
    private LocalTime time;

}
