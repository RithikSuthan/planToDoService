package com.example.planToDoService.Services;

import com.example.planToDoService.Models.User;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class ToDoService {
    public ResponseEntity<?> register(User user)
    {
        return ResponseEntity.status(HttpStatus.OK).body("Hi");
    }
}
