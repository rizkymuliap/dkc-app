package com.dkc.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.scout_document;
import com.dkc.models.repos.scout_documentRepos;

import jakarta.transaction.Transactional;

//import java.util.List;

@Service
@Transactional
public class scout_documentService {
    
    @Autowired
    private scout_documentRepos Scout_documentRepos;

    public scout_document save(scout_document data)
    {
        return Scout_documentRepos.save(data);
    }

    public scout_document findOne(String id)
    {
        return Scout_documentRepos.findById(id).get();
    }

    public Iterable<scout_document> findAll()
    {
        return Scout_documentRepos.findAll();
    }

    public void removeOne(String id)
    {
        Scout_documentRepos.deleteById(id);
    }

    // public List<scout_document> findByName(String name)
    // {
    //     return Scout_documentRepos.findByNameContains(name);
    // }
}
