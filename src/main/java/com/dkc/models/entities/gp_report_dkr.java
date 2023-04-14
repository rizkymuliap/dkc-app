package com.dkc.models.entities;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.time.Year;
import java.util.Date;

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
@Table(name = "gp_report_dkr")
public class gp_report_dkr implements Serializable{
    
    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "report_id", length = 300)
    private String report_id = "RPR"+Uniqid.generate();

    @NotEmpty(message = "Nama tidak boleh kosong")
    @Column(name = "name", length = 300, nullable = false)
    private String name;

    @NotEmpty(message = "Dokumen tidak boleh kosong")
    @Column(name = "document", length = 300, nullable = false)
    private String document;

    @Column(name = "dkr_id", length = 300)
    private String dkr_id;

    @NotEmpty(message = "Tipe tidak boleh kosong")
    @Column(name = "type", length = 1, nullable = false)
    private String type;

    @NotNull(message = "Tahun tidak boleh kosong")
    @Column(name = "year", columnDefinition = "YEAR", nullable = false)
    private Year year;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private LocalDateTime created_at = LocalDateTime.now();

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private LocalDateTime updated_at = LocalDateTime.now();

    public gp_report_dkr() {
    }

    public gp_report_dkr(String report_id, @NotEmpty(message = "Nama tidak boleh kosong") String name,
            @NotEmpty(message = "Dokumen tidak boleh kosong") String document, String dkr_id,
            @NotEmpty(message = "Tipe tidak boleh kosong") String type,
            @NotEmpty(message = "Tahun tidak boleh kosong") Year year) {
        this.report_id = report_id;
        this.name = name;
        this.document = document;
        this.dkr_id = dkr_id;
        this.type = type;
        this.year = year;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getReport_id() {
        return report_id;
    }

    public void setReport_id(String report_id) {
        this.report_id = report_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDocument() {
        return document;
    }

    public void setDocument(String document) {
        this.document = document;
    }

    public String getDkr_id() {
        return dkr_id;
    }

    public void setDkr_id(String dkr_id) {
        this.dkr_id = dkr_id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
