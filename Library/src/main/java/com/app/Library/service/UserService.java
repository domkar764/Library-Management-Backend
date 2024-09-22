package com.app.Library.service;

import com.app.Library.model.User;

import java.util.Optional;

public interface UserService {
    void saveUser(User user);

    Optional<User> auth(String userName, String password);
}
