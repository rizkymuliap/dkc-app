package com.dkc.services;

import org.springframework.beans.factory.annotation.Autowired;
import java.util.UUID;
import org.springframework.stereotype.Service;

import com.dkc.models.entities.dkr;
import com.dkc.models.entities.auth;
import com.dkc.models.repos.dkrRepos;
import com.dkc.models.repos.authRepos;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class authService {
    
    @Autowired
    private dkrRepos dkrRepos;
    @Autowired
    private authRepos authRepos;

    public auth loginDkr(String username, String password) 
    {
        // check valid dkr
        dkr validDkr = dkrRepos.findByUsernameAndPassword(username, password);

        String message;
        String token;

        message = "Login failed!";
        token = null;
        auth dataAuth = new auth();
        if(validDkr != null) {
            // success login
            message = "Login success!";
            token = UUID.randomUUID().toString();

            dataAuth.setDkr_id(validDkr.getDkr_id());
            dataAuth.setToken(token);
            authRepos.save(dataAuth);

            return dataAuth;
        }

        return dataAuth;
    }

    public boolean checkValid(String token) 
    {
        auth findToken = authRepos.findByToken(token);
        if(findToken == null) {
            return false;
        }else{
            return true;
        }
    }

    public auth authData(String token) 
    {
        auth authData = authRepos.findByToken(token);
        return authData;
    }

    public void logoutDkr(String token) {
        authRepos.deleteByToken(token);
    }
}
