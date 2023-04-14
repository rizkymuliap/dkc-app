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

import com.dkc.models.entities.agenda;
import com.dkc.services.agendaService;
import com.dkc.services.authService;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/agendas")
public class agendaController {

    @Autowired
    private agendaService AgendaService;
    @Autowired 
    private authService AuthService; 
    
    @PostMapping()
    public ResponseEntity<Object> create(@RequestBody agenda data, HttpServletRequest request, BindingResult bindingResult)
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

        if(bindingResult.hasErrors()){
          responseMap.put("message", "Title or schedule date required!");
          return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
        agenda agendas = AgendaService.save(data);
        responseMap.put("message", "Agenda successfully uploaded!");
        responseMap.put("data", agendas);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
      }
      catch(Exception e)
      {
        responseMap.put("error", "Error occurred while upload agenda!");
        responseMap.put("message", "Agenda not found!");
        return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
      }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
      Map<String, Object> responseMap = new HashMap<>();
      try
      {
        agenda agendas = AgendaService.findOne(id);
        if(agendas == null)
        {
            responseMap.put("message", "Agenda not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        agenda agenda = AgendaService.findOne(id);
        responseMap.put("message", "Agenda found!");
        responseMap.put("data", agenda);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
      }catch(Exception e)
      {
        responseMap.put("message", "Agenda not found!");
        return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
      }
          
    }
    

   @GetMapping 
   public ResponseEntity<Object> getAllAgendas(){
     Map<String, Object> responseMap = new HashMap<>();
     List<agenda> agendas = (List<agenda>) AgendaService.findAll();
     if(agendas.isEmpty())
     {
          return new ResponseEntity<>("Agenda not found", HttpStatus.NOT_FOUND);
     }
     responseMap.put("message","Agenda found!");
     responseMap.put("data", agendas);
     return new ResponseEntity<>(responseMap, HttpStatus.OK);
     }

   @PutMapping("/{id}")
   public ResponseEntity<Object> update(@PathVariable("id") String id, @Valid @RequestBody agenda data, HttpServletRequest request, BindingResult bindingResult)
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
        
        agenda agenda = AgendaService.findOne(id);
        if(agenda == null)
        {
            responseMap.put("message", "Agenda not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        if(bindingResult.hasErrors())
        {
            responseMap.put("message", "Title or schedule date required!");
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
        agenda agendas = AgendaService.save(data);
        responseMap.put("message", "Agenda successfully updated!");
        responseMap.put("data", agendas);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
      }
      catch(Exception e)
      {
        responseMap.put("error", "Error occurred while updating agenda!");
        responseMap.put("message", "Agenda not found!");
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

        agenda agenda = AgendaService.findOne(id);
        if(agenda == null)
        {
          responseMap.put("message", "Agenda not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }

        AgendaService.removeOne(id);
        responseMap.put("message", "Agenda successfully deleted!");
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
     }catch (Exception e)
     {
      responseMap.put("message", "Error occurred while deleting agenda!");
      responseMap.put("error","Agenda not found!");
      return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
     }
     
   }
    
}
