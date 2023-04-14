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
@Table(name = "sk_dkr")
public class sk_dkr implements Serializable{
    
    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "sk_id", length = 300)
    private String sk_id = "SK"+Uniqid.generate();

    @NotEmpty(message = "Dokumen tidak boleh kosong")
    @Column(name = "document", length = 300, nullable = false)
    private String document;

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

    public sk_dkr() {
    }

    public sk_dkr(@NotEmpty(message = "Dokumen tidak boleh kosong") String document, String dkr_id,
            @NotEmpty(message = "Tahun tidak boleh kosong") Year year) {
        this.document = document;
        this.dkr_id = dkr_id;
        this.year = year;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getSk_id() {
        return sk_id;
    }

    public void setSk_id(String sk_id) {
        this.sk_id = sk_id;
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
