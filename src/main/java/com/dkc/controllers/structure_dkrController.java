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

import com.dkc.models.entities.structure_dkr;
import com.dkc.services.structure_dkrService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/structures-dkr")
public class structure_dkrController {
    
    @Autowired 
    private structure_dkrService Structure_dkrService;

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody structure_dkr data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        if(bindingResult.hasErrors())
        {
            responseMap.put("message", "All field required!");
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
        structure_dkr structure_dkrs = Structure_dkrService.save(data);
        responseMap.put("message", "Structure DKR successfully uploaded!");
        responseMap.put("data", structure_dkrs);
        return new ResponseEntity<>(responseMap,HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap =  new HashMap<>();
        try{
            structure_dkr structure_dkrs = Structure_dkrService.findOne(id);
            if(structure_dkrs.getStructure_id() == null)
            {
                responseMap.put("message", "Structure DKR not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            responseMap.put("message", "Structure DKR found!");
            responseMap.put("data", structure_dkrs);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("message", "Structure DKR not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    } 
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responseMap =  new HashMap<>();
        List<structure_dkr> structure_dkrs = (List<structure_dkr>) Structure_dkrService.findAll();
        if(structure_dkrs.isEmpty())
        {
            return new ResponseEntity<>("Structure DKR not found!", HttpStatus.NOT_FOUND);
        }
            responseMap.put("message", "Structure DKR found!");
            responseMap.put("data", structure_dkrs);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @Valid @RequestBody structure_dkr data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            structure_dkr structure_dkr = Structure_dkrService.findOne(id);
            if(structure_dkr.getStructure_id() == null)
            {
                responseMap.put("message", "Structure DKR not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            structure_dkr structure_dkrs = Structure_dkrService.save(data);
            responseMap.put("message", "Structure DKR successfully updated!");
            responseMap.put("data", structure_dkrs);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while updating Structure DKR");
            responseMap.put("message", "Structure DKR not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            structure_dkr structure_dkr = Structure_dkrService.findOne(id);
            if(structure_dkr.getStructure_id() == null)
            {
                responseMap.put("message", "Structure DKR not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            Structure_dkrService.removeOne(id);
            responseMap.put("message", "Structure DKR successfully deleted!");
            return new ResponseEntity<>(responseMap, HttpStatus.OK); 
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while deleting Structure DKR");
            responseMap.put("message", "Structure DKR not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }
}
