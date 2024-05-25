package com.example.planToDoService.Models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("users")
public class User {
    String email;
    String password;
}
