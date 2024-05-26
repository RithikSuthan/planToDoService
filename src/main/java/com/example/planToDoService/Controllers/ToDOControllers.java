package com.example.planToDoService.Controllers;

import com.example.planToDoService.Models.NewPlan;
import com.example.planToDoService.Models.User;
import com.example.planToDoService.Services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
public class ToDOControllers {

    @Autowired
    ToDoService service;
    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody (required=false) User user )
    {
        return service.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody(required = false) User user)
    {
        return service.login(user);
    }

    @PostMapping("/add")
    public ResponseEntity<?> addTask(@RequestBody(required = false)NewPlan newPlan)
    {
        return service.addTask(newPlan);
    }
}
