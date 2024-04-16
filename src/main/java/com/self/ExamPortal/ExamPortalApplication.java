package com.self.ExamPortal;

import com.self.ExamPortal.models.Role;
import com.self.ExamPortal.models.User;
import com.self.ExamPortal.models.UserRole;
import com.self.ExamPortal.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

@SpringBootApplication
public class ExamPortalApplication {

	@Autowired
	UserService userService;
	@Autowired
	private PasswordEncoder passwordEncoder;

	public static void main(String[] args) {
		SpringApplication.run(ExamPortalApplication.class, args);
	}

//	@Override
//	public void run(String... args) throws Exception {
//
//		System.out.println("Creating Admin account.....");
//
//		User user=new User();{
//			user.setUsername("Maverick");
//			user.setFirstName("Kaustubh");
//			user.setLastName("Tripathi");
//			user.setEmail("kaustubh.tripathi6798@gmail.com");
//			user.setPassword(passwordEncoder.encode("Mav@ExamPortal#11"));
//			user.setPhone("7897868012");
//		}
//
//		Role role=new Role();
//		role.setRoleName("Admin");
//		role.setRoleId(77);
//
//		Set<UserRole> userRole=new HashSet<>();
//		UserRole userRole1=new UserRole();
//		userRole1.setRole(role);
//		userRole1.setUser(user);
//		userRole.add(userRole1);
//		userService.createUser(user,userRole);
//	}
}
