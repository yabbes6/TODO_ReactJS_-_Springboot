/*package com.example.server.controllerImpl;

import com.example.server.constants.PlanConstant;
import com.example.server.controller.UserController;
import com.example.server.services.UserService;
import com.example.server.utils.PlanUtils;
import com.example.server.wrapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserControllerImpl implements UserController {

    @Autowired
    UserService userService;

    //ResponseEntity represents the whole HTTP response: status code, headers, and body
    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {

        try {
            return userService.signUp(requestMap);
        }catch (Exception e){
            e.printStackTrace();
        }
        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        try{
            return userService.login(requestMap);
        }catch(Exception e ){
            e.printStackTrace();
        }
        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<UserMapper>> getAllUser() {
        try{
            return userService.getAllUser();
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        try{
            return userService.update(requestMap);
        }catch(Exception e){
            e.printStackTrace();
        }
        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> checkToken() {
        try{
            return userService.checkToken();
        }catch(Exception e){
            e.printStackTrace();
        }
        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> changerPassword(Map<String, String> requestMap) {
        try{
            return userService.changePassword(requestMap);
        }catch(Exception e){
            e.printStackTrace();
        }
        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> forgetPassword(Map<String, String> requestMap) {
        try{

        }catch(Exception e){
            e.printStackTrace();
        }
        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}*/
