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

import com.dkc.models.entities.product;
import com.dkc.services.productService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class productController {
    
    @Autowired 
    private productService ProductService;

    @PostMapping()
    public ResponseEntity<Object> create(@Valid @RequestBody product data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        if(bindingResult.hasErrors())
        {
            responseMap.put("message", "Description or type required!");
            return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
        }
        product products = ProductService.save(data);
        responseMap.put("message", "Product successfully uploaded!");
        responseMap.put("data", products);
        return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }
 
    @GetMapping("/{id}")
    public ResponseEntity<Object> findOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            product products = ProductService.findOne(id);
            if(products.getProduct_id() == null)
            {
                responseMap.put("message", "Product not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            responseMap.put("message", "Product found!");
            responseMap.put("data", products);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("message", "Product not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }
    
    @GetMapping
    public ResponseEntity<Object> getAll()
    {
        Map<String, Object> responseMap = new HashMap<>();
        List<product> products = (List<product>) ProductService.findAll();
        if(products.isEmpty())
        {
            return new ResponseEntity<>("Product not found!", HttpStatus.NOT_FOUND);
        }
            responseMap.put("message", "Product found!");
            responseMap.put("data", products);
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Object> update(@PathVariable("id") String id,@Valid @RequestBody product data, BindingResult bindingResult)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            product product = ProductService.findOne(id);
            if(product.getProduct_id() == null)
            {
                responseMap.put("message", "Product not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            if(bindingResult.hasErrors())
            {
                responseMap.put("message", "Description or type required!");
                return new ResponseEntity<>(responseMap, HttpStatus.BAD_REQUEST);
            }
            product products = ProductService.save(data);
            responseMap.put("message", "Product successfully updated!");
            responseMap.put("data", products);
            return new ResponseEntity<>(responseMap,HttpStatus.OK);
        }catch(Exception e)
        {
            responseMap.put("error", "Error occured while updating product");
            responseMap.put("message", "Product not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Object> removeOne(@PathVariable("id") String id)
    {
        Map<String, Object> responseMap = new HashMap<>();
        try{
            product product = ProductService.findOne(id);
            if(product.getProduct_id() == null)
            {
                responseMap.put("message", "Product not found!");
                return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
            }
            ProductService.removeOne(id);
            responseMap.put("message", "Product  successfully deleted!");
            return new ResponseEntity<>(responseMap, HttpStatus.OK);
        }
        catch (Exception e)
        {
            responseMap.put("error", "Error occured while deleting product");
            responseMap.put("message", "Product not found!");
            return new ResponseEntity<>(responseMap, HttpStatus.NOT_FOUND);
        }
        
    } 
}
