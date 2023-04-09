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

import com.dkc.models.entities.school;
import com.dkc.services.schoolService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/schools")
public class schoolController {
    
    @Autowired 
    private schoolService SchoolService;

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody school data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        if( bindingResult.hasErrors())
        {
            responseMap.put("message", "All field required!");
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST); 
        }
        school schools = SchoolService.save(data);
        responseMap.put("message", "School successfully uploaded!");
        responseMap.put("data", schools);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            school schools = SchoolService.findOne(id);
            if(schools.getSchool_id() == null)
            {
                responseMap.put("message", "School not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            responseMap.put("message", "School found!");
            responseMap.put("data", schools);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("message", "School not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responseMap =  new HashMap<>();
        List<school> schools = (List<school>) SchoolService.findAll();
        if(schools.isEmpty())
        {
            return new ResponseEntity<>("School not found!", HttpStatus.NOT_FOUND);
        }
            responseMap.put("message", "School found!");
            responseMap.put("data", schools);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @Valid @RequestBody school data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            school school = SchoolService.findOne(id);
            if(school.getSchool_id() == null)
            {
                responseMap.put("message", "School not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message","All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            school schools = SchoolService.save(data);
            responseMap.put("message", "School successfully updated!");
            responseMap.put("data", schools);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while updating School!");
            responseMap.put("message", "School not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            school school = SchoolService.findOne(id);
            if(school.getSchool_id() == null)
            {
                responseMap.put("message", "School not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            SchoolService.removeOne(id);
            responseMap.put("message", "School successfully deleted!");
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while deleting School!");
            responseMap.put("message", "School not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }
}
