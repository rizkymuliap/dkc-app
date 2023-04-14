package com.dkc.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;

import com.dkc.models.repos.Uniqid;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "school")
public class school implements Serializable{
    
    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "school_id", length = 300)
    private String school_id = "SCH"+Uniqid.generate();

    @NotEmpty(message = "Nama sekolah tidak boleh kosong")
    @Column(name = "school_name", length = 300, nullable = false)
    private String school_name;

    @NotEmpty(message = "Nomor GuDep tidak boleh kosong")
    @Column(name = "gudep_number", length = 300, nullable = false)
    private String gudep_number;

    @Column(name = "dkr_id", length = 300)
    private String dkr_id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private LocalDateTime updated_at = LocalDateTime.now();

    public school() {
    }

    public school(String school_id, @NotEmpty(message = "Nama sekolah tidak boleh kosong") String school_name,
            @NotEmpty(message = "Nomor GuDep tidak boleh kosong") String gudep_number, String dkr_id) {
        this.school_id = school_id;
        this.school_name = school_name;
        this.gudep_number = gudep_number;
        this.dkr_id = dkr_id;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getSchool_name() {
        return school_name;
    }

    public void setSchool_name(String school_name) {
        this.school_name = school_name;
    }

    public String getGudep_number() {
        return gudep_number;
    }

    public void setGudep_number(String gudep_number) {
        this.gudep_number = gudep_number;
    }

    public String getDkr_id() {
        return dkr_id;
    }

    public void setDkr_id(String dkr_id) {
        this.dkr_id = dkr_id;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }
}
