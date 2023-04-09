package com.dkc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.product;
import com.dkc.models.repos.productRepos;

import jakarta.transaction.Transactional;

//import java.util.List;

@Service
@Transactional
public class productService {
    
    @Autowired
    private productRepos ProductRepos;

    public product save(product data)
    {
        return ProductRepos.save(data);
    }

    public product findOne(String id)
    {
        return ProductRepos.findById(id).get();
    }

    public Iterable<product> findAll()
    {
        return ProductRepos.findAll();
    }

    public void removeOne(String id)
    {
        ProductRepos.deleteById(id);
    }

    // public List<product> findByName(String name)
    // {
    //     return ProductRepos.findByNameContains(name);
    // }
}
