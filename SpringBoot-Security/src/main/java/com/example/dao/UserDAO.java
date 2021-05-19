package com.example.dao;

import com.example.model.User;

import java.util.Optional;

public interface UserDAO {
    public Optional<User> selectUserByUsername(String username);
}
