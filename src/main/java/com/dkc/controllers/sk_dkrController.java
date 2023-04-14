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
import com.dkc.models.entities.sk_dkr;
import com.dkc.services.authService;
import com.dkc.services.sk_dkrService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/sk-dkr")
public class sk_dkrController {
    
    @Autowired 
    private sk_dkrService Sk_dkrService;
    @Autowired 
    private authService AuthService; 

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody sk_dkr data, HttpServletRequest request, BindingResult bindingResult)
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
        
        sk_dkr sk_dkrs = Sk_dkrService.save(data);
        responseMap.put("message", "SK DKR Successfully uploaded!");
        responseMap.put("data", sk_dkrs);
        return new ResponseEntity<>(responseMap,HttpStatus.OK);
    }


    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            sk_dkr sk_dkrs = Sk_dkrService.findOne(id);
            if(sk_dkrs.getSk_id() == null){
                responseMap.put("message", "SK DKR not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            responseMap.put("message", "SK DKR found!");
            responseMap.put("data", sk_dkrs);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("message", "SK DKR not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responseMap =  new HashMap<>();
        List<sk_dkr> sk_dkrs = (List<sk_dkr>) Sk_dkrService.findAll();
        if(sk_dkrs.isEmpty())
        {
            return new ResponseEntity<>("SK DKR not found!", HttpStatus.NOT_FOUND);
        }
            responseMap.put("message", "SK DKR found!");
            responseMap.put("data", sk_dkrs);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id ,@Valid @RequestBody sk_dkr data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            sk_dkr sk_dkr = Sk_dkrService.findOne(id);
            if(sk_dkr.getSk_id() == null)
            {
                responseMap.put("message", "SK DKR not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            sk_dkr sk_dkrs = Sk_dkrService.save(data);
            responseMap.put("message", "SK DKR successfully updated!");
            responseMap.put("data", sk_dkrs);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while updating SK DKR");
            responseMap.put("message", "SK DKR not found!");
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

            sk_dkr sk_dkr = Sk_dkrService.findOne(id);
            if(sk_dkr.getSk_id() == null)
            {
                responseMap.put("message", "SK DKR not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            Sk_dkrService.removeOne(id);
            responseMap.put("message", "SK DKR successfully deleted!");
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }catch (Exception e)
        {
            responseMap.put("error", "Error occured while deleting SK DKR");
            responseMap.put("message", "SK DKR not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
    }
}
