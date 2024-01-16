/*package com.example.server.serviceImpl;



import com.example.server.Dao.UserRepository;
import com.example.server.JWT.CustomerUsersDetailsService;
import com.example.server.JWT.JwtFilter;
import com.example.server.JWT.JwtUtil;
import com.example.server.POJO.User;
import com.example.server.constants.PlanConstant;
import com.example.server.services.UserService;
import com.example.server.utils.PlanUtils;
import com.example.server.wrapper.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Service;

import java.util.*;


@Slf4j
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    UserRepository userRepository;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    CustomerUsersDetailsService customerUsersDetailsService;

    @Autowired
    JwtUtil jwtUtil;

    @Autowired
    JwtFilter jwtFilter;



    @Override
    public ResponseEntity<String> signUp(Map<String, String> requestMap) {
        log.info("Inside signup {}",requestMap);
        try{
            if (validateSignUp(requestMap)){
                User user = userRepository.findByEmailId(requestMap.get("email"));
                if (Objects.isNull(user)){
                    userRepository.save(getUserFromMap(requestMap));
                    return PlanUtils.getResponseEntity("Successfully registered ",HttpStatus.OK);
                }else {
                    return PlanUtils.getResponseEntity("Email already exists",HttpStatus.BAD_REQUEST);
                }
            }
            else {
                return PlanUtils.getResponseEntity(PlanConstant.INVALID_DATA, HttpStatus.BAD_REQUEST);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
    }
    private boolean validateSignUp(Map<String ,String> requestMap){
        if (requestMap.containsKey("name") &&
            requestMap.containsKey("contactNumber") &&
            requestMap.containsKey("email") &&
            requestMap.containsKey("password") )
            return true;
        else
            return false;
    }
    private User getUserFromMap(Map<String,String> requestMap){
        User user = new User();
        user.setName(requestMap.get("name"));
        user.setContactNumber(requestMap.get("contactNumber"));
        user.setEmail(requestMap.get("email"));
        user.setPassword(requestMap.get("password"));
        user.setRole("user");

        return user;
    }


    @Override
    public ResponseEntity<String> login(Map<String, String> requestMap) {
        log.info("Inside login");
        try{
            Authentication auth = authenticationManager.authenticate(
                    new UsernamePasswordAuthenticationToken(requestMap.get("email"),requestMap.get("password"))
            );
            if(auth.isAuthenticated()){

                    return new ResponseEntity<String>("/{\"token\":\'"
                            + jwtUtil.generateToken(
                                    customerUsersDetailsService.getUserDetail().getEmail(),
                                    customerUsersDetailsService.getUserDetail().getRole()) + "\"}",
                            HttpStatus.OK);
            }
        }catch(Exception e){
           log.error("{}",e);
        }
        return new ResponseEntity<String>("{\"message\":\""+ "Bad Credentials"+"\"}",HttpStatus.BAD_REQUEST);

    }

    @Override
    public ResponseEntity<List<UserMapper>> getAllUser() {
        try{
            if(jwtFilter.isAdmin()){
                return new ResponseEntity<>(userRepository.getAllUser(),HttpStatus.OK);
            }else{
                return new ResponseEntity<>(new ArrayList<>(),HttpStatus.UNAUTHORIZED);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(),HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requestMap) {
        try{
            if (jwtFilter.isAdmin()){
                Optional<User> optional=userRepository.findById(Integer.parseInt(requestMap.get("id")));
                if(!optional.isEmpty()){
                    userRepository.updateStatus(requestMap.get("status"),Integer.parseInt(requestMap.get("id")));
                    return PlanUtils.getResponseEntity("User status updated successfully",HttpStatus.OK);
                }else{
                    PlanUtils.getResponseEntity("User id does not exist",HttpStatus.OK);
                }
            }else {
                return PlanUtils.getResponseEntity(PlanConstant.UNAUTHORIZED_ACCESS,HttpStatus.UNAUTHORIZED);
            }
        }catch(Exception e){
            e.printStackTrace();
        }
        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
    }



    @Override
    public ResponseEntity<String> checkToken() {
        return PlanUtils.getResponseEntity("true",HttpStatus.OK);
    }

    @Override
    public ResponseEntity<String> changePassword(Map<String, String> requestMap) {
        try {
            User userObj = userRepository.findByEmail(jwtFilter.getCurrentUser());
            if (!userObj.equals(null)){
                if (userObj.getPassword().equals(requestMap.get("oldPassword"))){
                    userObj.setPassword(requestMap.get("newPassword"));
                    userRepository.save(userObj);
                    return PlanUtils.getResponseEntity("password updated Successfully",HttpStatus.OK);
                }
                return PlanUtils.getResponseEntity("Incorrect old Password",HttpStatus.BAD_REQUEST);
            }
            return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
        }catch(Exception e){
            e.printStackTrace();
        }
        return PlanUtils.getResponseEntity(PlanConstant.PLAN_ERROR,HttpStatus.INTERNAL_SERVER_ERROR);
    }

}*/





















