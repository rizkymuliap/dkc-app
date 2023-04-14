package com.dkc.controllers;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dkc.models.entities.dkr;
import com.dkc.models.repos.authRepos;
import com.dkc.models.entities.auth;
import com.dkc.services.authService;

import jakarta.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/api")
public class authController {
    
    @Autowired 
    private authService AuthService; 

    @PostMapping("/login")
    public ResponseEntity<Object> create(@RequestBody dkr data, BindingResult bindingResult)
    {
        String message;
        Map<String, Object> responseMap = new HashMap<>();

        auth loginDkr = AuthService.loginDkr(data.getUsername(), data.getPassword());

        message = "Gagal!";
        if(loginDkr.getDkr_id() != null){
            message = "Berhasil";
        }

        responseMap.put("message", message);
        responseMap.put("data", loginDkr);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @DeleteMapping("/logout")
    public ResponseEntity<Object> logout(@RequestHeader("token") String token)
    {
        Map<String, Object> responseMap =  new HashMap<>();
        try{
            // if token not valid
            boolean checkValid = AuthService.checkValid(token);
            if(!checkValid) {
                responseMap.put("message", "Not authorize!");
                responseMap.put("data", checkValid);
                return new ResponseEntity<>(responseMap, HttpStatus.OK);
            }

            // logout
            AuthService.logoutDkr(token);

            responseMap.put("message", "Logout success!");
            responseMap.put("data", checkValid);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }catch (Exception e)
        {
            responseMap.put("error", "Error occured while logout");
            responseMap.put("message", "Error!");
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
    }
}
