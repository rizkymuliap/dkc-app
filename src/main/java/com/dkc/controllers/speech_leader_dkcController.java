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

import com.dkc.models.entities.speech_leader_dkc;
import com.dkc.services.speech_leader_dkcService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/speechs")
public class speech_leader_dkcController {
    
    @Autowired 
    private speech_leader_dkcService Speech_leader_dkcService;

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody speech_leader_dkc data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        if(bindingResult.hasErrors())
        {
            responseMap.put("message", "All field required!");
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
        speech_leader_dkc speech_leader_dkcs = Speech_leader_dkcService.save(data);
        responseMap.put("message", "Speech successfully uploaded");
        responseMap.put("data", speech_leader_dkcs);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
    
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            speech_leader_dkc speech_leader_dkcs = Speech_leader_dkcService.findOne(id);
            if(speech_leader_dkcs.getSpeech_id() == null)
            {
                responseMap.put("message", "Speech not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            responseMap.put("message", "Speech found!");
            responseMap.put("data", speech_leader_dkcs);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("message", "Speech not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responseMap =  new HashMap<>();
        List<speech_leader_dkc> speech_leader_dkcs = (List<speech_leader_dkc>) Speech_leader_dkcService.findAll();
        if(speech_leader_dkcs.isEmpty())
        {
            return new ResponseEntity<>("Speech not found!", HttpStatus.NOT_FOUND);
        }
            responseMap.put("message", "Speech found!");
            responseMap.put("data", speech_leader_dkcs);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id,@Valid @RequestBody speech_leader_dkc data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            speech_leader_dkc speech_leader_dkc = Speech_leader_dkcService.findOne(id);
            if(speech_leader_dkc.getSpeech_id() == null)
            {
                responseMap.put("message", "Speech not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            speech_leader_dkc speech_leader_dkcs = Speech_leader_dkcService.save(data);
            responseMap.put("message", "Speech successfully updated!");
            responseMap.put("data", speech_leader_dkcs);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while updating Speech");
            responseMap.put("message", "Speech not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            speech_leader_dkc speech_leader_dkc = Speech_leader_dkcService.findOne(id);
            if(speech_leader_dkc.getSpeech_id() == null)
            {
                responseMap.put("message", "Speech not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            Speech_leader_dkcService.removeOne(id);
            responseMap.put("message", "Speech successfully deleted!");
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while deleting Speech");
            responseMap.put("message", "Speech not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }
}
