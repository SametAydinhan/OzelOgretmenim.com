package com.example.SoftwareEngineeringProject.Service;


import com.example.SoftwareEngineeringProject.Entity.*;
import com.example.SoftwareEngineeringProject.Repository.AppointmentRepository;
import com.example.SoftwareEngineeringProject.Exception.IdNotFoundException;
import com.example.SoftwareEngineeringProject.Repository.StudentRepository;
import com.example.SoftwareEngineeringProject.Repository.TutorRepository;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;
    private final TutorService tutorService;

    private final StudentRepository studentRepository;

    private final TutorRepository tutorRepository;

    public AppointmentService(AppointmentRepository appointmentRepository, TutorService tutorService, StudentRepository studentRepository, TutorRepository tutorRepository) {
        this.appointmentRepository = appointmentRepository;
        this.tutorService = tutorService;
        this.studentRepository = studentRepository;
        this.tutorRepository = tutorRepository;
    }


    public List<Appointment> getAllAppointment(){
        return appointmentRepository.findAll();
    }

    public Appointment findById(int appointmentId) throws IdNotFoundException {
            return appointmentRepository.findById(appointmentId).orElseThrow(() -> new IdNotFoundException("Id Not Found Appointment :"+appointmentId));

    }

    public Appointment createAppointment(Appointment appointment) throws IdNotFoundException {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        User loggedInUser = (User) authentication.getPrincipal();

        // Giriş yapan kullanıcının öğrenci rolüne sahip olup olmadığını kontrol et
        if (!loggedInUser.getAuthorities().contains(Role.ROLE_STUDENT)) {
            throw new RuntimeException("Sadece öğrenciler randevu oluşturabilir.");
        }

        // Öğrenci bilgisini al
        Student student = studentRepository.findByUser((User) loggedInUser.getAuthorities());

        // Randevu için seçilen öğretmenin bilgilerini al (Burada appointment nesnesinde tutulmuş olmalı)
        Tutor selectedTutor = appointment.getTutor();

        // Randevu oluştur
        appointment.setStudent(student);
        appointment.setEnabled(true); // Varsayılan olarak etkin

        // İlgili öğretmene atama işlemi yapılabilir
        // Örneğin, tutor nesnesine randevuyu ekleyebiliriz:
        // selectedTutor.getAppointments().add(appointment);

        // Randevuyu kaydet
        return appointmentRepository.save(appointment);
    }




    public Appointment updateAppointment(int appointmentId,Appointment appointment) throws IdNotFoundException {
        Optional<Appointment> savedAppointment = appointmentRepository.findById(appointmentId);

            if(savedAppointment.isPresent()){
                    Appointment tempAppointment = savedAppointment.get();
                    tempAppointment.setAppointmentDate(appointment.getAppointmentDate());
                    tempAppointment.setEnabled(appointment.isEnabled());
                    tempAppointment.setSubject(appointment.getSubject());
                    appointmentRepository.save(tempAppointment);

                    return tempAppointment;
            }

            else {
                    throw new IdNotFoundException("Id Not Found Appointment : "+appointmentId);
            }

    }


    public void deleteAppointment(int appointmentId) throws IdNotFoundException {
        Appointment appointment = appointmentRepository.findById(appointmentId).orElseThrow( () -> new IdNotFoundException("Id Not Found Appointment"+appointmentId));
        appointmentRepository.deleteById(appointment.getId());
    }


}
