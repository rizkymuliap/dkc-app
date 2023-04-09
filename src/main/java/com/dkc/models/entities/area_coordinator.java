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
@Table(name = "area_coordinator")
public class area_coordinator implements Serializable{
    
    private static final Long serialVersionUID =1L;

    @Id
    @Column(name = "coordinator_id", length = 300)
    private String coordinator_id;

    @NotEmpty(message = "Nama tidak boleh kosong")
    @Column(name = "name", length = 300, nullable = false)
    private String name;

    @NotEmpty(message = "NTA tidak boleh kosong")
    @Column(name = "nta", length = 300, nullable = false, unique = true)
    private String nta;

    @NotEmpty(message = "Gambar tidak boleh kosong")
    @Column(name = "image", length = 300, nullable = false)
    private String image;

    @Column(name = "area_id", length = 300)
    private String area_id;

    @NotNull(message = "Tahun tidak boleh kosong")
    @Column(name = "year", columnDefinition = "YEAR", nullable = false)
    private Year year;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    public area_coordinator() {
    }

    public area_coordinator(String coordinator_id, @NotEmpty(message = "Nama tidak boleh kosong") String name,
            @NotEmpty(message = "NTA tidak boleh kosong") String nta,
            @NotEmpty(message = "Gambar tidak boleh kosong") String image, String area_id,
            @NotEmpty(message = "Tahun tidak boleh kosong") Year year, Date created_at, Date updated_at) {
        this.coordinator_id = coordinator_id;
        this.name = name;
        this.nta = nta;
        this.image = image;
        this.area_id = area_id;
        this.year = year;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getCoordinator_id() {
        return coordinator_id;
    }

    public void setCoordinator_id(String coordinator_id) {
        this.coordinator_id = coordinator_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNta() {
        return nta;
    }

    public void setNta(String nta) {
        this.nta = nta;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getArea_id() {
        return area_id;
    }

    public void setArea_id(String area_id) {
        this.area_id = area_id;
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
