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

import com.dkc.models.entities.area_coordinator;
import com.dkc.services.area_coordinatorService;
import com.dkc.services.authService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/area-coordinators")
public class area_coordinatorController {

    @Autowired 
    private area_coordinatorService Area_coordinatorService;
    @Autowired 
    private authService AuthService; 

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody area_coordinator data, BindingResult bindingResult, HttpServletRequest request)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            String token = request.getHeader("token");
            boolean checkValid = AuthService.checkValid(token);
            if(!checkValid) {
                responseMap.put("message", "Not authorize!");
                responseMap.put("data", checkValid);
                return new ResponseEntity<>(responseMap, HttpStatus.OK);
            }

            area_coordinator area_coordinators = Area_coordinatorService.save(data);
            if(bindingResult.hasErrors())
            {
                responseMap.put("message","Area coordinator required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            responseMap.put("message", "Area coordinator successfully uploaded!");
            responseMap.put("data", area_coordinators);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }
        catch (Exception e)
        {
                responseMap.put("error", "Error occured while Posting Area Coordinator");
                responseMap.put("message","Area coordinator required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST); 
        }   
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            area_coordinator area_coordinators = Area_coordinatorService.findOne(id);
            if(area_coordinators == null){
                responseMap.put("message", "Area Coordinator not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            responseMap.put("message", "Area Coordinator found!");
            responseMap.put("data", area_coordinators);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }
        catch (Exception e)
        {
                responseMap.put("message", "Area Coordinator not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responseMap = new HashMap<>();
        List<area_coordinator> area_coordinators = (List<area_coordinator>) Area_coordinatorService.findAll();
        if(area_coordinators.isEmpty())
        {
            return new ResponseEntity<>("Area Coordinator not found", HttpStatus.NOT_FOUND);
        }

        responseMap.put("message", "Area Coordinator found!");
        responseMap.put("data", area_coordinators);
        return new ResponseEntity<>(responseMap,HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id,@Valid @RequestBody area_coordinator data, BindingResult bindingResult, HttpServletRequest request)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            String token = request.getHeader("token");
            boolean checkValid = AuthService.checkValid(token);
            if(!checkValid) {
                responseMap.put("message", "Not authorize!");
                responseMap.put("data", checkValid);
                return new ResponseEntity<>(responseMap, HttpStatus.OK);
            }
            
            area_coordinator area_coordinator = Area_coordinatorService.findOne(id);
            if(area_coordinator == null){
                responseMap.put("message", "Area Coordinator not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "Area coordinator required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            area_coordinator area_coordinators = Area_coordinatorService.save(data);
            responseMap.put("message", "Area Coordinator successfully updated!");
            responseMap.put("data", area_coordinators);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while updating Area Coordinator");
            responseMap.put("message", "Area Coordinator not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOne(@PathVariable("id") String id, HttpServletRequest request)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            String token = request.getHeader("token");
            boolean checkValid = AuthService.checkValid(token);
            if(!checkValid) {
                responseMap.put("message", "Not authorize!");
                responseMap.put("data", checkValid);
                return new ResponseEntity<>(responseMap, HttpStatus.OK);
            }
            
            area_coordinator area_coordinators =  Area_coordinatorService.findOne(id);
            if(area_coordinators == null)
            {
                responseMap.put("message", "Area Coordinator not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            Area_coordinatorService.removeOne(id);
            responseMap.put("message", "Area coordinator successfully deleted!");
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while deleting Area Coordinator");
            responseMap.put("message", "Area Coordinator not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
    }
    
}
