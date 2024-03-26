package com.example.SoftwareEngineeringProject.Service;


import com.example.SoftwareEngineeringProject.Entity.Appointment;
import com.example.SoftwareEngineeringProject.Repository.AppointmentRepository;
import com.example.SoftwareEngineeringProject.exception.IdNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AppointmentService {

    private final AppointmentRepository appointmentRepository;

    public AppointmentService(AppointmentRepository appointmentRepository) {
        this.appointmentRepository = appointmentRepository;
    }


    public List<Appointment> getAllAppointment(){
        return appointmentRepository.findAll();
    }

    public Appointment findById(int appointmentId) throws IdNotFoundException {
            return appointmentRepository.findById(appointmentId).orElseThrow(() -> new IdNotFoundException("Id Not Found Appointment :"+appointmentId));

    }

    public Appointment createAppointment(Appointment appointment){
        Appointment savedAppointment = Appointment.builder()
                .appointmentDate(appointment.getAppointmentDate())
                .isEnabled(appointment.isEnabled())
                .subject(appointment.getSubject())
                .student(appointment.getStudent())
                .tutor(appointment.getTutor())
                .build();


            return appointmentRepository.save(savedAppointment);
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
