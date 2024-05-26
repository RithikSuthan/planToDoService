package com.example.planToDoService.Services;

import com.example.planToDoService.Models.NewPlan;
import com.example.planToDoService.Models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import org.springframework.data.mongodb.core.query.Query;

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
    public ResponseEntity<?> login(User user)
    {
        String message;
        User existing=new User();
        Query query=new Query(Criteria.where("email").is(user.getEmail()).and("password").is(user.getPassword()));
        existing=mongoTemplate.findOne(query,User.class);
        if(existing==null)
        {
            message="User doesn't exist";
        }
        else
        {
            message="User exist";
        }
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
    public ResponseEntity<?> addTask(NewPlan newPlan)
    {
        String message="";
        if(newPlan.getTaskNo()=="" || newPlan.getPlan()=="" || newPlan.getAddedBy()=="" )
        {
            message="Any of the given field is empty";
        }
        else
        {
            newPlan.setStatus(false);
            mongoTemplate.save(newPlan);
            message="Plan saved successfully";
        }
        return ResponseEntity.status(HttpStatus.OK).body(message);
    }
}
