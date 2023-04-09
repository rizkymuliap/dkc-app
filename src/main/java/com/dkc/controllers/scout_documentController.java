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


import com.dkc.models.entities.scout_document;
import com.dkc.services.scout_documentService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/scout-documents")
public class scout_documentController {
    @Autowired 
    private scout_documentService Scout_documentService;

    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody scout_document data)
    {
        Map<String, Object> responseMap = new HashMap<>();
        scout_document scout_documents = Scout_documentService.save(data);
        responseMap.put("message", "Scout document successfully uploaded!");
        responseMap.put("data", scout_documents);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    } 

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        scout_document scout_documents = Scout_documentService.findOne(id);
        responseMap.put("message", "Scout document found!");
        responseMap.put("data", scout_documents);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
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
    public ResponseEntity<Object> update(@PathVariable("id") String id,@Valid @RequestBody scout_document data)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            scout_document scout_document =Scout_documentService.findOne(id);
            if(scout_document.getDocument_id() == null)
            {
                responseMap.put("message", "Scout document not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
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
    public ResponseEntity<Object> removeOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
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
