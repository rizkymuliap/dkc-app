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

import com.dkc.models.entities.banner;
import com.dkc.services.bannerService;

import jakarta.validation.Valid;

import java.util.List;

@RestController
@RequestMapping("/api/banners")
public class bannerController {
    
    @Autowired 
    private bannerService BannerService; 

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody banner data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap =  new HashMap<>();
        try{
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            banner banners = BannerService.save(data);
            responseMap.put("message", "Banner successfully uploaded!");
            responseMap.put("data", banners);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while posting Banner");
            responseMap.put("message", "All field required!");
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
        
    }
    

    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        banner banners = BannerService.findOne(id);

        responseMap.put("message", "Banner found!");
        responseMap.put("data", banners);
        return new ResponseEntity<>(responseMap,HttpStatus.OK);

    }
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responseMap = new HashMap<>();
        List<banner> banners = (List<banner>) BannerService.findAll();

        if(banners.isEmpty())
        {
            return new ResponseEntity<>("Banner not found!", HttpStatus.NOT_FOUND);
        }
        responseMap.put("message", "Banner found!");
        responseMap.put("data", banners);
        return new ResponseEntity<>(responseMap,HttpStatus.OK);

    }
    

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id, @RequestBody banner data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            banner banner = BannerService.findOne(id);
            if(banner == null){
                responseMap.put("message", "Banner not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            banner banners = BannerService.save(data);
            responseMap.put("message", "Banner successfully updated!");
            responseMap.put("data", banners);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured updating Banner");
            responseMap.put("message", "Banner not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            banner banners = BannerService.findOne(id);
            if(banners == null){
                responseMap.put("message", "All field required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            BannerService.removeOne(id);
            responseMap.put("message", "Banner successfully deleted!");
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while deleting Banner");
            responseMap.put("message", "All field required!");
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
        
    }
}
