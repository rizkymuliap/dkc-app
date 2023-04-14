package com.dkc.models.entities;

import java.io.Serializable;
import java.time.Year;
import java.time.LocalDateTime;

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
@Table(name = "program_dkr")
public class program_dkr implements Serializable{
    
    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "program_id", length = 300)
    private String program_id = "PRGR"+Uniqid.generate();

    @NotEmpty(message = "Nama program tidak boleh kosong")
    @Column(name = "program_name", length = 300, nullable = false)
    private String program_name;

    @NotNull(message = "Bulan tidak boleh kosong")
    @Column(name = "month",nullable = false)
    private int month;

    @NotNull(message = "Tahun tidak boleh kosong")
    @Column(name = "year", columnDefinition = "YEAR", nullable = false)
    private Year year;

    @Column(name = "dkr_id", length = 300)
    private String dkr_id;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private LocalDateTime updated_at = LocalDateTime.now();

    public program_dkr() {
    }

    public program_dkr(String program_id, @NotEmpty(message = "Nama program tidak boleh kosong") String program_name,
            @NotEmpty(message = "Bulan tidak boleh kosong") int month,
            @NotEmpty(message = "Tahun tidak boleh kosong") Year year, String dkr_id) {
        this.program_id = program_id;
        this.program_name = program_name;
        this.month = month;
        this.year = year;
        this.dkr_id = dkr_id;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getProgram_id() {
        return program_id;
    }

    public void setProgram_id(String program_id) {
        this.program_id = program_id;
    }

    public String getProgram_name() {
        return program_name;
    }

    public void setProgram_name(String program_name) {
        this.program_name = program_name;
    }

    public int getMonth() {
        return month;
    }

    public void setMonth(int month) {
        this.month = month;
    }

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public String getDkr_id() {
        return dkr_id;
    }

    public void setDkr_id(String dkr_id) {
        this.dkr_id = dkr_id;
    }

    public LocalDateTime getCreated_at() {
        return created_at;
    }

    public void setCreated_at(LocalDateTime created_at) {
        this.created_at = created_at;
    }

    public LocalDateTime getUpdated_at() {
        return updated_at;
    }
    
}
