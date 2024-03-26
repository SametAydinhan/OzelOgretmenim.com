package com.example.SoftwareEngineeringProject.Repository;

import com.example.SoftwareEngineeringProject.Entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TutorRepository extends JpaRepository<Tutor,Integer> {


        @Query("SELECT t FROM Tutor t WHERE t.subject LIKE %:subject%")
        List<Tutor> findBySubject(String subject);




}
