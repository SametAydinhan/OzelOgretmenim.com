package com.example.SoftwareEngineeringProject.Repository;

import com.example.SoftwareEngineeringProject.Entity.Notice;
import com.example.SoftwareEngineeringProject.Entity.Tutor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository

public interface NoticeRepository extends JpaRepository<Notice,Integer>, JpaSpecificationExecutor<Notice> {



}
