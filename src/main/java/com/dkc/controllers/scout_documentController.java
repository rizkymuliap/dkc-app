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


import com.dkc.models.entities.scout_document;
import com.dkc.services.authService;
import com.dkc.services.scout_documentService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/scout-documents")
public class scout_documentController {
    
    @Autowired 
    private scout_documentService Scout_documentService;
    @Autowired 
    private authService AuthService;

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody scout_document data, BindingResult bindingResult, HttpServletRequest request)
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
        scout_document scout_documents = Scout_documentService.save(data);
        responseMap.put("message", "Scout document successfully uploaded!");
        responseMap.put("data", scout_documents);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            scout_document scout_documents = Scout_documentService.findOne(id);
            if(scout_documents.getDocument_id() == null)
            {
                responseMap.put("message", "Scout document not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }   
            responseMap.put("message", "Scout document found!");
            responseMap.put("data", scout_documents);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("message", "Scout document not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
    }
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responseMap =  new HashMap<>();
        List<scout_document> scout_documents = (List<scout_document>) Scout_documentService.findAll();
        if(scout_documents.isEmpty())
        {
            return new ResponseEntity<>("Scout document not found!", HttpStatus.NOT_FOUND);
        }
            responseMap.put("message", "Scout document found!");
            responseMap.put("data", scout_documents);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id,@Valid @RequestBody scout_document data, BindingResult bindingResult, HttpServletRequest request)
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
            
            scout_document scout_document =Scout_documentService.findOne(id);
            if(scout_document.getDocument_id() == null)
            {
                responseMap.put("message", "Scout document not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            scout_document scout_documents = Scout_documentService.save(data);
            responseMap.put("message", "Scout document successfully updated!");
            responseMap.put("data", scout_documents);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }
        catch(Exception e)
        {
            responseMap.put("error", "Error occured while updating Scout document");
            responseMap.put("message", "Scout document not found!");
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
            
            scout_document scout_document =Scout_documentService.findOne(id);
            if(scout_document.getDocument_id() == null)
            {
                responseMap.put("message", "Scout document not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
        Scout_documentService.removeOne(id);
        responseMap.put("message", "Scout document successfully deleted!");
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch(Exception e)
        {
            responseMap.put("error", "Error occured while deleting Scout document");
            responseMap.put("message", "Scout document not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
    }
}
