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

import com.dkc.models.entities.program_dkc;
import com.dkc.services.authService;
import com.dkc.services.program_dkcService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/programs-dkc")
public class program_dkcController {
    
    @Autowired 
    private program_dkcService Program_dkcService;
    @Autowired 
    private authService AuthService; 

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody program_dkc data, BindingResult bindingResult, HttpServletRequest request)
    {
        Map<String, Object> responseMap = new HashMap<>();
        String token = request.getHeader("token");
        boolean checkValid = AuthService.checkValid(token);
        if(!checkValid) {
            responseMap.put("message", "Not authorize!");
            responseMap.put("data", checkValid);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }

        if(bindingResult.hasErrors())
        {
            responseMap.put("message", "All field required!");
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
        program_dkc program_dkcs = Program_dkcService.save(data);
        responseMap.put("message", "Program successfully uploaded!");
        responseMap.put("data", program_dkcs);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            program_dkc program_dkc = Program_dkcService.findOne(id);
            if(program_dkc.getProgram_id() == null)
            {
                responseMap.put("message", "Program DKC not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            program_dkc program_dkcs = Program_dkcService.findOne(id);
            responseMap.put("message", "Program DKC found!");
            responseMap.put("data", program_dkcs);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("message", "Program DKC not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }
    
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responseMap =  new HashMap<>();
        List<program_dkc> program_dkcs = (List<program_dkc>) Program_dkcService.findAll();
        if(program_dkcs.isEmpty())
        {
            return new ResponseEntity<>("Program DKC not found!", HttpStatus.NOT_FOUND);
        }
        responseMap.put("message", "Program DKC found!");
        responseMap.put("data", program_dkcs);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id,@Valid @RequestBody program_dkc data, BindingResult bindingResult, HttpServletRequest request)
    {
        Map<String, Object> responseMap = new HashMap<>();
        String token = request.getHeader("token");
        boolean checkValid = AuthService.checkValid(token);
        if(!checkValid) {
            responseMap.put("message", "Not authorize!");
            responseMap.put("data", checkValid);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }

        try{
            program_dkc program_dkc = Program_dkcService.findOne(id);
            if(program_dkc.getProgram_id() == null){
                responseMap.put("message", "Program DKC not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            program_dkc program_dkcs = Program_dkcService.save(data);
            responseMap.put("message", "Program DKC successfully updated!");
            responseMap.put("data", program_dkcs);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while updating Program DKC!");
            responseMap.put("message", "Program DKC not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
            
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOne(@PathVariable("id") String id, HttpServletRequest request)
    {
        Map<String, Object> responseMap = new HashMap<>();
        String token = request.getHeader("token");
        boolean checkValid = AuthService.checkValid(token);
        if(!checkValid) {
            responseMap.put("message", "Not authorize!");
            responseMap.put("data", checkValid);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }

        Program_dkcService.removeOne(id);
        responseMap.put("message", "Program DKC successfully deleted!");
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    } 
}
