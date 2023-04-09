package com.dkc.models.entities;

import java.io.Serializable;
import java.time.Year;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "program_dkc")
public class program_dkc implements Serializable {
    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "program_id", length = 300)
    private String program_id;

    @NotEmpty(message = "Nama Program tidak boleh kosong")
    @Column(name = "program_name", length = 300, nullable = false)
    private String program_name;

    @NotNull(message = "Tahun tidak boleh kosong")
    @Column(name = "year", columnDefinition = "YEAR", nullable = false)
    private Year year;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    public program_dkc() {
    }

    public program_dkc(String program_id, @NotEmpty(message = "Nama Program tidak boleh kosong") String program_name,
            @NotEmpty(message = "Tahun tidak boleh kosong") Year year, Date created_at, Date updated_at) {
        this.program_id = program_id;
        this.program_name = program_name;
        this.year = year;
        this.created_at = created_at;
        this.updated_at = updated_at;
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

    public Year getYear() {
        return year;
    }

    public void setYear(Year year) {
        this.year = year;
    }

    public Date getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Date created_at) {
        this.created_at = created_at;
    }

    public Date getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Date updated_at) {
        this.updated_at = updated_at;
    }

    

    
}
