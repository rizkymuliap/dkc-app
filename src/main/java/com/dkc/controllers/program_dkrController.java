package com.dkc.controllers;

import java.util.HashMap;
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

import com.dkc.models.entities.auth;
import com.dkc.models.entities.program_dkr;
import com.dkc.services.authService;
import com.dkc.services.program_dkrService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/program-dkr")
public class program_dkrController {
 
    @Autowired 
    private program_dkrService Program_dkrService;
    @Autowired 
    private authService AuthService; 

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody program_dkr data, HttpServletRequest request, BindingResult bindingResult)
    {
        Map<String, Object> responseMap =  new HashMap<>();
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

        auth authData = AuthService.authData(token);
        data.setDkr_id(authData.getDkr_id());

        program_dkr program_dkrs = Program_dkrService.save(data);
        responseMap.put("message", "Program DKR successfully uploaded!");
        responseMap.put("data", program_dkrs);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            program_dkr program_dkrs = Program_dkrService.findOne(id);
            if(program_dkrs.getProgram_id() == null)
            {
                responseMap.put("message", "Program DKR not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            responseMap.put("message", "Program DKR found!");
            responseMap.put("data", program_dkrs);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("message", "Program DKR not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responseMap =  new HashMap<>();
        List<program_dkr> program_dkrs = (List<program_dkr>) Program_dkrService.findAll();
        if(program_dkrs.isEmpty())
        {
            return new ResponseEntity<>("Program DKR not found!", HttpStatus.NOT_FOUND);
        }
            responseMap.put("message", "Program DKR found!");
            responseMap.put("data", program_dkrs);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id,@Valid @RequestBody program_dkr data, HttpServletRequest request, BindingResult bindingResult)
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

            program_dkr program_dkr = Program_dkrService.findOne(id);
            if(program_dkr.getDkr_id() == null){
                responseMap.put("message", "Program DKR not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }

            data.setProgram_id(id);
            data.setDkr_id(program_dkr.getDkr_id());
            data.setCreated_at(program_dkr.getCreated_at());
            program_dkr program_dkrs = Program_dkrService.save(data);

            responseMap.put("message", "Program DKR successfully updated!");
            responseMap.put("data", program_dkrs);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }
        catch(Exception e)
        {
            responseMap.put("error", "Error occured while updating Program DKR");
            responseMap.put("message", "Program DKR not found!");
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
            
            program_dkr program_dkr = Program_dkrService.findOne(id);
            if(program_dkr.getDkr_id() == null){
                responseMap.put("message", "Program DKR not foud!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            Program_dkrService.removeOne(id);
            responseMap.put("message", "Program DKR successfully deleted!");
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while deleting Program DKR");
            responseMap.put("message", "Program DKR not foud!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }
}
