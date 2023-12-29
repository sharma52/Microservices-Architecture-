package com.example.user_service.service;


import com.example.user_service.entity.User;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class UserServiceImpl implements UserService{
    List<User> list=List.of(
            new User(1311L,"Rishabh Sharma","8958464310"),
            new User(1312L,"Kartik Iyer","8072658943"),
            new User(1314L,"Stayam Saha","54676134896")
    );
    @Override
    public User getUser(Long id){
        return list.stream().filter(user ->user.getUserId().equals(id)).findAny().orElse(null);
    }
}
