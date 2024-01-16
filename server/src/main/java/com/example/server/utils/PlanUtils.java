package com.example.server.utils;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class PlanUtils {
    private PlanUtils(){
    }
    public static ResponseEntity<String> getResponseEntity(String responseMessage, HttpStatus httpStatus){
        return new ResponseEntity<String>("{ \"messsage\" : \"" + responseMessage + " \"} ", httpStatus);
    }
}
