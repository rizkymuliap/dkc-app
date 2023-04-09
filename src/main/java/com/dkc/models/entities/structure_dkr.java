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
@Table(name = "structure_dkr")
public class structure_dkr implements Serializable{

    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "structure_id", length = 300)
    private String structure_id;

    @NotEmpty(message = "Gambar tidak boleh kosong")
    @Column(name = "image", length = 300, nullable = false)
    private String image;

    @Column(name = "dkr_id", length = 300)
    private String dkr_id;

    @NotNull(message = "Tahun tidak boleh kosong")
    @Column(name = "year", columnDefinition = "YEAR", nullable = false)
    private Year year;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    public structure_dkr() {
    }

    public structure_dkr(String structure_id, @NotEmpty(message = "Gambar tidak boleh kosong") String image,
            String dkr_id, @NotEmpty(message = "Tahun tidak boleh kosong") Year year, Date created_at,
            Date updated_at) {
        this.structure_id = structure_id;
        this.image = image;
        this.dkr_id = dkr_id;
        this.year = year;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getStructure_id() {
        return structure_id;
    }

    public void setStructure_id(String structure_id) {
        this.structure_id = structure_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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
