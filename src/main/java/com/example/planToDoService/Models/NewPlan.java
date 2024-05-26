package com.example.planToDoService.Models;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@Document("newPlan")
public class NewPlan {
    public String taskNo;
    public String plan;
    public Boolean status;
    public String addedBy;
}
