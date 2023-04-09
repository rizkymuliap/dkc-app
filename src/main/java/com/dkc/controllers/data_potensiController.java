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

import com.dkc.models.entities.data_potensi;
import com.dkc.services.data_potensiService;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/api/data-potensi")
public class data_potensiController {

    @Autowired 
    private data_potensiService Data_potensiService; 
    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody data_potensi data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            if(bindingResult.hasErrors()){
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            data_potensi data_potensis = Data_potensiService.save(data);
            responseMap.put("message", "Data potensi successfully uploaded!");
            responseMap.put("data", data_potensis);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {

                responseMap.put("error", "Error occured while posting Data Potensi");
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            data_potensi data_potensi = Data_potensiService.findOne(id);
            if(data_potensi == null)
            {
                responseMap.put("message", "Data potensi not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            data_potensi data_potensis = Data_potensiService.findOne(id);
            responseMap.put("message", "Data potensi founded!");
            responseMap.put("data", data_potensis);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch(Exception e)
        {
            responseMap.put("message", "Data potensi not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responseMap = new HashMap<>();
        List<data_potensi> data_potensis = (List<data_potensi>) Data_potensiService.findAll();
        if(data_potensis.isEmpty())
        {
            return new ResponseEntity<>("Data potensi not found!", HttpStatus.NOT_FOUND);
        }
        responseMap.put("message", "Data Potensi found!");
        responseMap.put("data", data_potensis);
        return new ResponseEntity<>(responseMap,HttpStatus.OK);
    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@Valid @RequestBody data_potensi data, @PathVariable("id") String id, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            data_potensi data_potensi = Data_potensiService.findOne(id);
            if(data_potensi == null)
            {
                responseMap.put("message", "Data potensi not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            data_potensi data_potensis = Data_potensiService.save(data);
            responseMap.put("message", "Data potensi successfully updated!");
            responseMap.put("data", data_potensis);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while updating Data potensi");
            responseMap.put("message", "Data potensi not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND); 
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            data_potensi data_potensi = Data_potensiService.findOne(id);
            if(data_potensi == null){
                responseMap.put("message", "Data potensi not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            Data_potensiService.removeOne(id);
            responseMap.put("message", "Data potensi successfully deleted!");
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }catch (Exception e)
        {
            responseMap.put("error", "Error occured while updating Data potensi");
            responseMap.put("message", "Data potensi not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND); 
        }
        
    }
    
}
