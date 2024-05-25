package com.example.planToDoService.Services;

import com.example.planToDoService.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    @Autowired
    MongoTemplate mongoTemplate;
    public ResponseEntity<?> register(User user)
    {
        String message;
        if(user.getEmail()=="" || user.getPassword()=="")
        {
            message="Email or password is empty";
        }
        else
        {
            mongoTemplate.save(user);
            message="user saved successfully";
        }
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
