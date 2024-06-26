package com.example.planToDoService.Controllers;

import com.example.planToDoService.Models.NewPlan;
import com.example.planToDoService.Models.User;
import com.example.planToDoService.Services.ToDoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @GetMapping("/fetch")
    public ResponseEntity<?> getTask(@RequestParam String email)
    {
        return service.fetchTask(email);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> deleteTask(@RequestParam String taskNo)
    {
        return service.deleteTask(taskNo);
    }

    @PatchMapping("/edit")
    public ResponseEntity<?> editTask(@RequestParam String taskNo,@RequestParam String plan)
    {
         return service.editTask(taskNo,plan);
    }

    @PatchMapping("/status")
    public ResponseEntity<?> editStatus(@RequestParam String taskNo)
    {
        return service.editStatus(taskNo);
    }
}
