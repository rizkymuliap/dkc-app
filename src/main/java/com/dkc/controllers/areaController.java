package com.dkc.controllers;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dkc.models.entities.area;
import com.dkc.services.areaService;

@RestController
@RequestMapping("/api/areas")
public class areaController {
    
    @Autowired 
    private areaService areaService; 

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody area data)
    {
        Map<String, Object> responseMap =  new HashMap<>();
        area areas = areaService.save(data);
        responseMap.put("message", "Area successfully uploaded!");
        responseMap.put("data", areas);
        return new ResponseEntity<>(responseMap,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        area areas = areaService.findOne(id);
        responseMap.put("message", "Area found!");
        responseMap.put("data", areas);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
    
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responseMap = new HashMap<>();
        List<area> areas = (List<area>) areaService.findAll();
        if(areas.isEmpty())
        {
            return new ResponseEntity<>("Area not found!", HttpStatus.NOT_FOUND);
        }
        responseMap.put("message", "Area found");
        responseMap.put("data", areas);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Object> update(@RequestBody area data)
    {
        Map<String, Object> responseMap = new HashMap<>();
        area areas = areaService.save(data);
        responseMap.put("message", "Area successfully updated!");
        responseMap.put("data", areas);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        areaService.removeOne(id);
        responseMap.put("message", "Area successfully deleted!");
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
}
