package com.example;

import com.example.model.Role;
import com.example.model.User;
import com.example.repository.RoleRepository;
import com.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;

@SpringBootApplication
public class SecurityJpaApplication implements ApplicationRunner {

    public static void main(String[] args) {
        SpringApplication.run(SecurityJpaApplication.class, args);
    }

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    public void run(ApplicationArguments args) throws Exception {
//        User user1 = new User();
//        user1.setUsername("ushan");
//        user1.setPassword("pass");
//        user1.setActive(true);
//        User user2 = new User();
//        user2.setUsername("ariya");
//        user2.setPassword("pass");
//        user2.setActive(true);
//        User user3 = new User();
//        user3.setUsername("vardhan");
//        user3.setPassword("pass");
//        user3.setActive(false);
//
//        Role role1 = new Role();
//        role1.setName("ROLE_ADMIN");
//        role1.setUser(user1);
//        Role role2 = new Role();
//        role2.setName("ROLE_USER");
//        role2.setUser(user2);
//        Role role3 = new Role();
//        role3.setName("ROLE_USER");
//        role3.setUser(user3);
//
//        userRepository.saveAll(Arrays.asList(user1,user2,user3));
//        roleRepository.saveAll(Arrays.asList(role1,role2,role3));
    }
}
