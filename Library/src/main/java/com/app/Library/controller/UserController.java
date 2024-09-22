package com.app.Library.controller;

import com.app.Library.model.LoginRequest;
import com.app.Library.model.User;
import com.app.Library.service.UserService;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/")
public class UserController {

    @Autowired
    private UserService userService;

//  Creating User
    @PostMapping("/create")
    public void createUser(@RequestBody User user) {
        userService.saveUser(user);
    }


//  login user
    @PostMapping("/login")
    public String loginUser(@RequestBody LoginRequest loginRequest, HttpSession session) {

        String userName = loginRequest.getUserName();
        String password = loginRequest.getPassword();
        Optional<User> userOptional = userService.auth(userName, password);
        if (userOptional.isPresent()) {
            User user = userOptional.get();

            // If the user is an admin
            if (user.getRole().equals("admin")) {
                session.setAttribute("user_id", user.getUserId());
                System.out.println("Admin logged in");
                return "redirect:/admin"; // Redirect to admin page
            }
            // If the user is not an admin
            else {
                session.setAttribute("user_id", user.getUserId());
                System.out.println("User logged in");
                return "redirect:/user/" + user.getUserId(); //gets the userId in the url
            }
        }

        // If authentication fails
        System.out.println("Login failed");
        return "Login failed"; // Could be redirecting to login error page or return error message
    }
}
