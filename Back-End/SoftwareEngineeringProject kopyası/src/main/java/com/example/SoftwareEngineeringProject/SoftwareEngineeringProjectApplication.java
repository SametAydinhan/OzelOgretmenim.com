package com.example.SoftwareEngineeringProject;

import com.example.SoftwareEngineeringProject.Entity.Role;
import com.example.SoftwareEngineeringProject.Entity.User;
import com.example.SoftwareEngineeringProject.Repository.UserRepository;
import com.example.SoftwareEngineeringProject.Service.TutorService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.util.Set;

@SpringBootApplication
public class SoftwareEngineeringProjectApplication implements CommandLineRunner{


	public SoftwareEngineeringProjectApplication(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder) {
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
			.username("deneme")
			.password(passwordEncoder.encode("deneme"))
			.authorities(Set.of(Role.ROLE_ADMIN))
			.isEnabled(true)
			.accountNonLocked(true)
			.isCredentialsNonExpired(true)
			.accountNonExpired(true)
			.build();


	userRepository.save(user);





	}
}
