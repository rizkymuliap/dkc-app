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

import com.dkc.models.entities.dkr;
import com.dkc.services.dkrService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/dkr")
public class dkrController {
    
    @Autowired 
    private dkrService DkrService; 
    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody dkr data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            if(bindingResult.hasErrors()){
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            dkr dkrs = DkrService.save(data);
            responseMap.put("message", "DKR successfully uploaded!");
            responseMap.put("data", dkrs);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }catch (Exception e)
        {   
            responseMap.put("error", "Error occured while posting DKR");
            responseMap.put("message", "All field required!");
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
    }
   
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap =  new HashMap<>();
        try
        {
            dkr dkrs = DkrService.findOne(id);
            if(dkrs == null){
                responseMap.put("message", "DKR not found");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            responseMap.put("message", "DKR found!");
            responseMap.put("data", dkrs);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("message", "DKR not found");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }

    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
       Map<String, Object> responseMap = new HashMap<>();
       List<dkr> dkrs = (List<dkr>) DkrService.findAll();
       if(dkrs.isEmpty())
       {
        return new ResponseEntity<>("DKR not found!", HttpStatus.NOT_FOUND);
       }
        responseMap.put("message", "DKR found!");
        responseMap.put("data", dkrs);
        return new ResponseEntity<>(responseMap,HttpStatus.OK);

    }
  

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@Valid @RequestBody dkr data, @PathVariable("id") String id,BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try
        {
            dkr dkr = DkrService.findOne(id);
            if(dkr == null)
            {
                responseMap.put("message", "DKR not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            dkr dkrs = DkrService.save(data);
            responseMap.put("message", "DKR successfully updated!");
            responseMap.put("data", dkrs);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch(Exception e)
        {
            responseMap.put("error", "Error occured while updating DKR");
            responseMap.put("message", "DKR not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try
        {
            dkr dkrs = DkrService.findOne(id);
            if(dkrs == null)
            {
                responseMap.put("message", "DKR not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            DkrService.removeOne(id);
            responseMap.put("message", "DKR successfully deleted!");
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch(Exception e)
        {
            responseMap.put("error", "Error occured while deleting DKR");
            responseMap.put("message", "DKR not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }
}
