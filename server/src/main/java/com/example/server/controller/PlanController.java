package com.example.server.controller;

import com.example.server.POJO.Plan;
import com.example.server.services.PlanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.xml.xpath.XPath;
import java.nio.file.Path;
import java.util.List;
import java.util.Map;

@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping(path = "/api/v1/plans")
public interface PlanController {

    @PostMapping(path = "/add")
    ResponseEntity<String> addNewPlan(@RequestBody(required = true)Map<String,String> requestMap);

    @GetMapping("/all")
    ResponseEntity<List<Plan>> getAllPlan();

    @PostMapping("/delete/{id}")
    ResponseEntity<String> deletePlan(@PathVariable Integer id);

    @PostMapping(path = "/update")
    ResponseEntity<String> updatePlan(@RequestBody(required = true)Map<String,String> requestMap);

}
