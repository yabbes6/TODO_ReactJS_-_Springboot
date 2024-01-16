package com.example.server.services;

import com.example.server.POJO.Plan;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface PlanService {

    ResponseEntity<String> addPlan(Map<String,String> requestMap);
    ResponseEntity<List<Plan>> getAllPlan();
    ResponseEntity<String> deletePlan(Integer id);

    ResponseEntity<String> updatePlan(Map<String,String> requestMap);

    //ResponseEntity<String> deleteAllPlans(Map<String,String> requestMap);

}
