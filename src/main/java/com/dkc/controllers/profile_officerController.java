package com.dkc.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dkc.models.entities.profile_officer;
import com.dkc.services.profile_officerService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/officers")
public class profile_officerController {

    @Autowired 
    private profile_officerService Profile_officerService;

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody profile_officer data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        if(bindingResult.hasErrors())
        {
            responseMap.put("message", "All field required!");
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
        profile_officer profile_officers = Profile_officerService.save(data);
        responseMap.put("message", "Officer successfully uploaded!");
        responseMap.put("data", profile_officers);
        return new ResponseEntity<>(responseMap,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            profile_officer profile_officers = Profile_officerService.findOne(id);
            if(profile_officers.getOfficer_id() == null)
            {
                responseMap.put("message", "Officer not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            responseMap.put("message", "Officer found!");
            responseMap.put("data", profile_officers);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("message", "Officer not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
       
    }
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responsMap = new HashMap<>();
        List<profile_officer> profile_officers = (List<profile_officer>) Profile_officerService.findAll();
        if(profile_officers.isEmpty())
        {
            return new ResponseEntity<>("Officer not found!", HttpStatus.NOT_FOUND);
        }
            responsMap.put("message", "Officer found!");
            responsMap.put("data", profile_officers);
            return new ResponseEntity<>(responsMap, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @Valid @RequestBody profile_officer data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            profile_officer profile_officer = Profile_officerService.findOne(id);
            if(profile_officer.getOfficer_id() == null)
            {
                responseMap.put("message", "Officer not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            } 
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            profile_officer profile_officers = Profile_officerService.save(data);
            responseMap.put("message", "Officer successfully updated!");
            responseMap.put("data", profile_officers);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while updating Officer");
            responseMap.put("message", "Officer not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        Profile_officerService.removeOne(id);
        responseMap.put("message", "Officer successfully deleted!");
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    } 
    
}
