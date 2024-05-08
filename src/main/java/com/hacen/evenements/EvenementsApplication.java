package com.hacen.evenements;


import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.hacen.evenements.model.Evenement;
import com.hacen.evenements.model.Role;
import com.hacen.evenements.model.User;
import com.hacen.evenements.service.EvenementService;
import com.hacen.evenements.service.UserService;

import jakarta.annotation.PostConstruct;


@SpringBootApplication
public class EvenementsApplication  implements CommandLineRunner{
	
	@Autowired
	private RepositoryRestConfiguration repositoryRestConfiguration;
	@Autowired
    EvenementService evenementservice;
	@Autowired
	PasswordEncoder passwordEncoder;
	@Autowired
	UserService userService;

	public static void main(String[] args) {
		SpringApplication.run(EvenementsApplication.class, args);
		
	}
	
	/*@PostConstruct
	void init_users() {
	//ajouter les rôles
	userService.addRole(new Role(null,"ADMIN"));
	userService.addRole(new Role(null,"AGENT"));
	userService.addRole(new Role(null,"USER"));
	//ajouter les users
	userService.saveUser(new User(null,"admin","123",true,null));
	userService.saveUser(new User(null,"hacen","123",true,null));
	userService.saveUser(new User(null,"user1","123",true,null));
	//ajouter les rôles aux users
	userService.addRoleToUser("admin", "ADMIN");
	userService.addRoleToUser("hacen", "USER");
	userService.addRoleToUser("hacen", "AGENT");
	userService.addRoleToUser("user1", "USER");
	}*/
	
	@Override
	public void run(String... args) throws Exception {
		//System.out.println("Password Encoded BCRYPT :******************** ");
		// System.out.println(passwordEncoder.encode("123"));
		repositoryRestConfiguration.exposeIdsFor(Evenement.class);
		
	}

}
