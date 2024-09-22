package com.app.Library.service.impl;

import com.app.Library.model.User;
import com.app.Library.repo.UserRepo;
import com.app.Library.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepo userRepo;

    @Override
    public void saveUser(User user) {
        userRepo.save(user);
    }

    @Override
    public Optional<User> auth(String userName, String password) {
        Optional<User> user = userRepo.findByUserName(userName);
        if (user.isPresent()) {
            User user1 = user.get();
            if (user1.getPassword().equals(password)) {
                return Optional.of(user1);
            }
        }
        return Optional.empty();
    }


}
