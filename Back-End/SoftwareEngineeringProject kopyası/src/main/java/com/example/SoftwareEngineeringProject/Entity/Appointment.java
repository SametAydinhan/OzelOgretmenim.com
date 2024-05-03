package com.example.SoftwareEngineeringProject.Entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.context.annotation.Primary;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@Table(name = "tbl_appointment")
public class Appointment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private LocalDate appointmentDate;

    private boolean isEnabled;

    private String subject;

    @ManyToOne(cascade = CascadeType.ALL)
    private Tutor tutor;

    @ManyToOne(cascade = CascadeType.ALL)
    private Student student;

}
