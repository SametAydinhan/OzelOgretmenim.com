package com.example.SoftwareEngineeringProject.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Not;

import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tbl_tutor")
public class Tutor {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String firstName;

    private String lastName;

    private String subject;

    private String RegisterDate;

    private String city;

    private String image;

    private String gender;

    @Lob
    private String description;

    private String email;

    private String telephoneNumber;

    @OneToMany
    private List<Appointment> appointmentList;

    @OneToMany
    private List<Notice> noticeList;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private User user;





}
