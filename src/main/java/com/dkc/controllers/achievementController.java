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

import com.dkc.models.entities.achievement;
import com.dkc.services.achievementService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/achievements")
public class achievementController {
    
    @Autowired 
    private achievementService AchievementService;

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody achievement data, BindingResult bindingResult){
        Map<String, Object> responseMap = new HashMap<>();
        if(bindingResult.hasErrors())
        {
            responseMap.put("message", "Description or type required!");
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }

        achievement achievements = AchievementService.save(data);
        responseMap.put("message", "Achievement successfully uploaded!");
        responseMap.put("data", achievements);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Object> getOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            achievement achievements = AchievementService.findOne(id);
            
            if(achievements == null)
            {
                responseMap.put("message", "Achievement not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            responseMap.put("message", "Achievement found!");
            responseMap.put("data", achievements);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("message", "Achievement not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping
    public ResponseEntity<Object> getAllAchievements() {
        Map<String, Object> responseMap = new HashMap<>();
        List<achievement> achievements = (List<achievement>) AchievementService.findAll();
        if (achievements.isEmpty()) {
            
            return new ResponseEntity<>("Achievements not found!", HttpStatus.NOT_FOUND);
        }
        
        responseMap.put("message", "Achievement found!");
        responseMap.put("data", achievements);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @Valid @RequestBody achievement data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            achievement achievements = AchievementService.findOne(id);
            if(achievements == null)
            {
                responseMap.put("message", "Achievement not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "Title or description required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            achievement achievement = AchievementService.save(data);
            responseMap.put("message", "Achievement successfully updated!");
            responseMap.put("data", achievement);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }catch (Exception e){
            responseMap.put("error", "Error occurred while updating achievement!");
            responseMap.put("message", "Achievement not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            achievement achievements = AchievementService.findOne(id);
            if(achievements == null)
            {
                responseMap.put("message", "Achievement not found!");
                return new ResponseEntity<>(responseMap,HttpStatus.NOT_FOUND);
            }
            AchievementService.removeOne(id);
            responseMap.put("message", "Success");
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch(Exception e)
        {
            responseMap.put("error", "Error occurred while deleting achievement!");
            responseMap.put("message", "Achievement not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }

}
