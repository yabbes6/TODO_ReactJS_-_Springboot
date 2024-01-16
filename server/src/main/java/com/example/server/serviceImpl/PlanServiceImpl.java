package com.example.server.serviceImpl;

import com.example.server.Dao.PlanRepos;
//import com.example.server.JWT.JwtFilter;
import com.example.server.POJO.Plan;
import com.example.server.constants.PlanConstant;
import com.example.server.services.PlanService;
import com.example.server.utils.PlanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Service
public class PlanServiceImpl implements PlanService {

    @Autowired
    private PlanRepos planRepos ;
    /*@Autowired
    JwtFilter jwtFilter;*/

    @Override
    public ResponseEntity<List<Plan>> getAllPlan() {
        try {
            if (true){
                return new ResponseEntity<>(planRepos.findAll(), HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new ArrayList<>(),HttpStatus.UNAUTHORIZED);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>() , HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> addPlan(Map<String, String> requestMap) {

        try{
            if (true){
                if (validatePlan(requestMap,false)){
                    planRepos.save(getPlanFromMap(requestMap,false));
                    return PlanUtils.getResponseEntity("successfully registred" , HttpStatus.OK);
                }else {
                    return PlanUtils.getResponseEntity(PlanConstant.INVALID_DATA , HttpStatus.BAD_REQUEST);
                }
            }else {
                return PlanUtils.getResponseEntity(PlanConstant.UNAUTHORIZED_ACCESS,HttpStatus.UNAUTHORIZED);
            }

        }catch(Exception e){
            e.printStackTrace();
        }
        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR , HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private boolean validatePlan(Map<String,String> requestMap,boolean validateId){
        if (requestMap.containsKey("comment")) {
            if (requestMap.containsKey("id") && validateId) {
                return true;
            } else if (!validateId)
                return true;
        }
        return false;
    }

    private Plan getPlanFromMap(Map<String,String> requestMap,Boolean isAdd){
        Plan plan = new Plan();
        if (isAdd){
            plan.setId(Integer.valueOf(requestMap.get("id")));
        }
        plan.setComment(requestMap.get("comment"));
        plan.setDate(LocalDate.parse(requestMap.get("date")));
        plan.setTime(LocalTime.parse(requestMap.get("time")));

        return plan;
    }

    @Override
    public ResponseEntity<String> deletePlan(Integer id) {

        try{
            if (true){
                Optional optional = planRepos.findById(id);
                if (!optional.isEmpty()){
                    planRepos.deleteById(id);
                    return PlanUtils.getResponseEntity("has been deleted successfuly",HttpStatus.OK);
                }else {
                    return PlanUtils.getResponseEntity("Plan id doesn't exist",HttpStatus.OK);
                }
            }else {
                return PlanUtils.getResponseEntity(PlanConstant.UNAUTHORIZED_ACCESS,HttpStatus.UNAUTHORIZED);
            }
        }catch(Exception ex){
            ex.printStackTrace();
        }

        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> updatePlan(Map<String, String> requestMap) {
        try {
            if (true){
                if (validatePlan(requestMap,true)) {
                    Optional optional = planRepos.findById(Integer.valueOf(requestMap.get("id")));
                    if (!optional.isEmpty()) {
                        planRepos.save(getPlanFromMap(requestMap,true));
                        return PlanUtils.getResponseEntity("comment plan updated successfully", HttpStatus.OK);
                    } else {
                        return PlanUtils.getResponseEntity("plan id doesn't exist", HttpStatus.OK);
                    }
                }else{
                    return PlanUtils.getResponseEntity(PlanConstant.INVALID_DATA,HttpStatus.BAD_REQUEST);
                }
            }else {
                return PlanUtils.getResponseEntity(PlanConstant.UNAUTHORIZED_ACCESS,HttpStatus.UNAUTHORIZED);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}
