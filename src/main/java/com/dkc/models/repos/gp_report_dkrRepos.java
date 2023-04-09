package com.dkc.models.repos;

import org.springframework.data.repository.CrudRepository;

import com.dkc.models.entities.gp_report_dkr;

//import java.util.List;;
public interface gp_report_dkrRepos extends CrudRepository<gp_report_dkr, String>{
    //List<gp_report_dkr> findByNameContains(String name);
}
