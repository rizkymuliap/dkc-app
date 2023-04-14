package com.dkc.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Year;

import com.dkc.models.repos.Uniqid;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "data_potensi")
public class data_potensi implements Serializable{
    
    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "data_id", length = 300)
    private String data_id = "DTP"+Uniqid.generate();

    @Column(name = "school_id", length = 300)
    private String school_id;

    @Column(name = "stage_id", length = 300)
    private String stage_id;

    @NotNull(message = "Anggota tidak boleh nol")
    @Column(name = "total_member", nullable = false)
    private int total_member;

    @Column(name = "dkr_id", length = 300)
    private String dkr_id;

    @NotNull(message = "Tahun tidak boleh kosong")
    @Column(name = "year", columnDefinition = "YEAR", nullable = false)
    private Year year;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private LocalDateTime updated_at = LocalDateTime.now();

    public data_potensi() {
    }

    public data_potensi(String data_id, String school_id, String stage_id,
            @NotEmpty(message = "Anggota tidak boleh nol") int total_member, String dkr_id,
            @NotEmpty(message = "Tahun tidak boleh kosong") Year year) {
        this.data_id = data_id;
        this.school_id = school_id;
        this.stage_id = stage_id;
        this.total_member = total_member;
        this.dkr_id = dkr_id;
        this.year = year;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getData_id() {
        return data_id;
    }

    public void setData_id(String data_id) {
        this.data_id = data_id;
    }

    public String getSchool_id() {
        return school_id;
    }

    public void setSchool_id(String school_id) {
        this.school_id = school_id;
    }

    public String getStage_id() {
        return stage_id;
    }

    public void setStage_id(String stage_id) {
        this.stage_id = stage_id;
    }

    public int getTotal_member() {
        return total_member;
    }

    public void setTotal_member(int total_member) {
        this.total_member = total_member;
    }

    public String getDkr_id() {
        return dkr_id;
    }

    public void setDkr_id(String dkr_id) {
        this.dkr_id = dkr_id;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }
}
