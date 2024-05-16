package com.example.SoftwareEngineeringProject;

import com.example.SoftwareEngineeringProject.Entity.Role;
import com.example.SoftwareEngineeringProject.Entity.Student;
import com.example.SoftwareEngineeringProject.Entity.Tutor;
import com.example.SoftwareEngineeringProject.Entity.User;
import com.example.SoftwareEngineeringProject.Repository.StudentRepository;
import com.example.SoftwareEngineeringProject.Repository.TutorRepository;
import com.example.SoftwareEngineeringProject.Repository.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class SoftwareEngineeringProjectApplication implements CommandLineRunner{


	private final TutorRepository tutorRepository;
	private final StudentRepository studentRepository;

	public SoftwareEngineeringProjectApplication(TutorRepository tutorRepository, StudentRepository studentRepository, UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
		this.tutorRepository = tutorRepository;
		this.studentRepository = studentRepository;
		this.userRepository = userRepository;
		this.passwordEncoder = passwordEncoder;
	}

	public static void main(String[] args) {
		SpringApplication.run(SoftwareEngineeringProjectApplication.class, args);
	}


	@Override
	public void run(String... args) throws Exception {
	}

	private final UserRepository userRepository;
	private final BCryptPasswordEncoder passwordEncoder;
	public void CreateDummyData(){

	User user = User.builder()
			.username("samet")
			.password(passwordEncoder.encode("admin"))
			.authorities(Set.of(Role.ROLE_ADMIN))
			.isEnabled(true)
			.accountNonLocked(true)
			.isCredentialsNonExpired(true)
			.accountNonExpired(true)
			.build();

			Tutor student = Tutor.builder()
					.firstName("asda")
					.lastName("asdsad")
					.user(user)
					.subject("math")
					.build();

			tutorRepository.save(student);




	}
}
