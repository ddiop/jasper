package com.diop.jasper.domain;

import lombok.*;

import javax.persistence.*;

@Getter
@Builder(toBuilder = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
//@Table(name = "EMPLOYEE")
public class Employee {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    private String oraganization;

    private String designation;

    private int salary;

}
