package com.example.server.controllerImpl;

import com.example.server.POJO.Plan;
import com.example.server.constants.PlanConstant;
import com.example.server.controller.PlanController;
import com.example.server.services.PlanService;
import com.example.server.utils.PlanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class PlanControllerImpl implements PlanController {

    @Autowired
    PlanService planService;

    @Override
    public ResponseEntity<String> addNewPlan(Map<String, String> requestMap) {
        try{
            return planService.addPlan(requestMap);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<Plan>> getAllPlan() {
        try{
            return planService.getAllPlan();
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<Plan>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> deletePlan(Integer id) {

        try{
            return planService.deletePlan(id);
        }catch(Exception ex){
            ex.printStackTrace();
        }
        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<String> updatePlan(Map<String, String> requestMap) {

        try{
            return planService.updatePlan(requestMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
