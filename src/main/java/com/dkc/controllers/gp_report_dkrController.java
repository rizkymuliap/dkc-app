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

import com.dkc.models.entities.auth;
import com.dkc.models.entities.gp_report_dkr;
import com.dkc.services.authService;
import com.dkc.services.gp_report_dkrService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/gp-reports")
public class gp_report_dkrController {

    @Autowired 
    private gp_report_dkrService Gp_report_dkrService;
    @Autowired 
    private authService AuthService; 

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody gp_report_dkr data, BindingResult bindingResult, HttpServletRequest request)
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

        auth authData = AuthService.authData(token);
        data.setDkr_id(authData.getDkr_id());

        gp_report_dkr gp_report_dkrs = Gp_report_dkrService.save(data);
        responseMap.put("message", "GP Report successfully uploaded!");
        responseMap.put("data", gp_report_dkrs);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            gp_report_dkr gp_report_dkr = Gp_report_dkrService.findOne(id);
            if(gp_report_dkr.getReport_id() == null)
            {
                responseMap.put("message", "GP Report not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            gp_report_dkr gp_report_dkrs = Gp_report_dkrService.findOne(id);
            responseMap.put("message", "GP Report found!");
            responseMap.put("data", gp_report_dkrs);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("message", "GP Report not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responseMap = new HashMap<>();
        List<gp_report_dkr> gp_report_dkrs = (List<gp_report_dkr>) Gp_report_dkrService.findAll();
        if(gp_report_dkrs.isEmpty())
        {
            return new ResponseEntity<>("GP Report not found!", HttpStatus.NOT_FOUND);
        }
            responseMap.put("message", "GP Report found!");
            responseMap.put("data", gp_report_dkrs);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @Valid @RequestBody gp_report_dkr data, BindingResult bindingResult, HttpServletRequest request)
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
            gp_report_dkr gp_report_dkrs = Gp_report_dkrService.findOne(id);
            if(gp_report_dkrs.getDkr_id() == null)
            {
                responseMap.put("message", "GP Report not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            gp_report_dkr gp_report_dkr = Gp_report_dkrService.save(data);
            responseMap.put("message", "GP Report successfully updated!");
            responseMap.put("data", gp_report_dkr);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }
        catch(Exception e)
        {
            responseMap.put("error", "Error occured while updating GP Report");
            responseMap.put("message", "GP Report not found!");
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

            gp_report_dkr gp_report_dkrs = Gp_report_dkrService.findOne(id);
            if(gp_report_dkrs.getDkr_id() == null)
            {
                responseMap.put("message", "GP Report not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            Gp_report_dkrService.removeOne(id);
            responseMap.put("message", "GP Report  successfully deleted!");
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch(Exception e)
        {
            responseMap.put("error", "Error occured while deleting GP Report");
            responseMap.put("message", "GP Report not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    } 
    
}
