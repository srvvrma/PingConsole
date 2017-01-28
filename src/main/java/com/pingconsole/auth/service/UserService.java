package com.pingconsole.auth.service;


import com.pingconsole.auth.model.User;

public interface UserService {
    void save(User user);

    User findByUsername(String username);
    User findById(Long id);
}