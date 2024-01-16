package com.example.server.controller;

import com.example.server.wrapper.UserMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;
import java.util.Map;


@RequestMapping(path = "/user")
public interface UserController {

    @PostMapping(path = "/signup")
    public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String,String> requestMap);

    @PostMapping(path = "/login")
    public ResponseEntity<String> login (@RequestBody(required = true) Map<String , String> requestMap);

    @GetMapping(path = "/get")
    public ResponseEntity<List<UserMapper>> getAllUser();

    /*@PostMapping(path = "/update")
    public ResponseEntity<String> update(@RequestBody(required = true) Map<String,String> requestMap);*/


    @GetMapping(path = "/checkToken")
    ResponseEntity<String> checkToken();

    @PostMapping(path = "/changePassword")
    ResponseEntity<String> changerPassword(@RequestBody Map<String,String> requestMap);


    @PostMapping(path = "/forgetPassword")
    ResponseEntity<String> forgetPassword(@RequestBody Map<String,String> requestMap);
}
