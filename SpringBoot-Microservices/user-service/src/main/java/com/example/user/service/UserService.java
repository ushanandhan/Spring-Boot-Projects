package com.example.user.service;

import com.example.user.dto.Department;
import com.example.user.dto.UserResponse;
import com.example.user.entity.User;
import com.example.user.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserService {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;

    public User saveUser(User user) {
        log.info("Inside saveUser of User UserService");
        return userRepository.save(user);
    }

    public UserResponse findUserById(Long userId) {
        UserResponse userResponse = new UserResponse();
        log.info("Inside findUserById of User UserService");
        User user =  userRepository.findUserByUserId(userId);
        userResponse.setUser(user);
        Department department = restTemplate.getForObject("http://DEPARTMENT-SERVICE/departments/"+user.getDepartmentId(),Department.class);
        userResponse.setDepartment(department);
        return userResponse;
    }
}
