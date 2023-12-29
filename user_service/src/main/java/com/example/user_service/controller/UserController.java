package com.example.user_service.controller;

import com.example.user_service.entity.User;
import com.example.user_service.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @Autowired
    private RestTemplate restTemplate;
    @GetMapping("/{userId}")
    public User getUset(@PathVariable("userId")Long userId){
        User user=this.userService.getUser(userId);
        List contacts=this.restTemplate.getForObject("http://contact-service/contact/user/"+user.getUserId(), List.class);

        user.setContacts(contacts);

        return user;
    }
}
