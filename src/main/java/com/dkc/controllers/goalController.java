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

import com.dkc.models.entities.goal;
import com.dkc.services.goalService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/goals")
public class goalController {
    
    @Autowired 
    private goalService GoalService; 
    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody goal data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "Description or type required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            goal goals = GoalService.save(data);
            responseMap.put("message", "Goal successfully uploaded!");
            responseMap.put("data", goals);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while posting DKR");
            responseMap.put("message", "Description or type required!");
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
       
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try
        {
            goal goal = GoalService.findOne(id);
            if(goal == null){
                responseMap.put("message", "Goal not found");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "Title or schedule date required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            goal goals = GoalService.findOne(id);
            responseMap.put("message", "Goal found!");
            responseMap.put("data", goals);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("message", "Goal not found");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responseMap = new HashMap<>();
        List<goal> goals = (List<goal>) GoalService.findAll();
        responseMap.put("message", "Goal found!");
        responseMap.put("data", goals);
        return new ResponseEntity<>(responseMap,HttpStatus.OK);
    }

    @GetMapping("/visi")
    public ResponseEntity<Object> getAllVisi() {
        Map<String, Object> responseMap = new HashMap<>();
        Iterable<goal> goals = GoalService.findByType("VISI");
        if (!goals.iterator().hasNext()) {
            responseMap.put("message", "Goals with type VISI not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        responseMap.put("message", "Goals with type VISI found!");
        responseMap.put("data", goals);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @GetMapping("/misi")
    public ResponseEntity<Object> getAllMisi() {
        Map<String, Object> responseMap = new HashMap<>();
        Iterable<goal> goals = GoalService.findByType("MISI");
        if (!goals.iterator().hasNext()) {
            responseMap.put("message", "Goals with type MISI not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        responseMap.put("message", "Goals with type MISI found!");
        responseMap.put("data", goals);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id,@Valid @RequestBody goal data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            goal goals = GoalService.findOne(id);
            if(goals == null)
            {
                responseMap.put("message", "Goal not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "Title or schedule date required!");
                return new ResponseEntity<>(responseMap,HttpStatus.BAD_REQUEST);
            }
            goal goal = GoalService.save(data);
            responseMap.put("message", "Goal successfully updated!");
            responseMap.put("data", goal);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while updating goal");
            responseMap.put("message", "Goal not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            goal goal  = GoalService.findOne(id);
            if(goal == null)
            {
                responseMap.put("message", "Goal not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            GoalService.removeOne(id);
            responseMap.put("message", "Goal successfully deleted!");
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch(Exception e)
        {
            responseMap.put("error", "Error occured while deleting Goal");
            responseMap.put("message", "Goal not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
                
    }
}
