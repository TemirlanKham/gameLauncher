package com.example.GameSiteProject.service;


import com.example.GameSiteProject.models.entity.User;

public interface UserService {
    User getById(Long id);

    User getByUsername(String username);

    void update(User user);

    User create(User user);

    void delete(Long id);
}
