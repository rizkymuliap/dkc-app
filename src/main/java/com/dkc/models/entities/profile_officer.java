package com.dkc.models.entities;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotEmpty;

@Entity
@Table(name = "profile_officer")
public class profile_officer implements Serializable{

    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "officer_id", length = 300)
    private String officer_id;

    @NotEmpty(message = "Nama tidak boleh kosong")
    @Column(name = "name", length = 300, nullable = false)
    private String name;

    @NotEmpty(message = "NTA tidak boleh kosong")
    @Column(name = "nta", length = 300, nullable = false, unique = true)
    private String nta;

    @NotEmpty(message = "Gambar tidak boleh kosong")
    @Column(name = "image", length = 300, nullable = false)
    private String image;

    @Column(name = "stage_id", length = 300)
    private String stage_id;

    @Column(name = "scope_id", length = 300)
    private String scope_id;

    @NotEmpty(message = "Education tidak boleh kosong")
    @Column(name = "education", length =  300, nullable = false)
    private String education;

    @NotEmpty(message = "Kota tidak boleh kosong")
    @Column(name = "city", length = 300, nullable = false)
    private String city;

    @Column(name = "instagram", length = 300, nullable = true)
    private String instagram;

    @Column(name = "facebook", length = 300,nullable = true)
    private String facebook;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    public profile_officer() {
    }

    public profile_officer(String officer_id, @NotEmpty(message = "Nama tidak boleh kosong") String name,
            @NotEmpty(message = "NTA tidak boleh kosong") String nta,
            @NotEmpty(message = "Gambar tidak boleh kosong") String image, String stage_id, String scope_id,
            @NotEmpty(message = "Education tidak boleh kosong") String education,
            @NotEmpty(message = "Kota tidak boleh kosong") String city, String instagram, String facebook,
            Date created_at, Date updated_at) {
        this.officer_id = officer_id;
        this.name = name;
        this.nta = nta;
        this.image = image;
        this.stage_id = stage_id;
        this.scope_id = scope_id;
        this.education = education;
        this.city = city;
        this.instagram = instagram;
        this.facebook = facebook;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getOfficer_id() {
        return officer_id;
    }

    public void setOfficer_id(String officer_id) {
        this.officer_id = officer_id;
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

    public String getStage_id() {
        return stage_id;
    }

    public void setStage_id(String stage_id) {
        this.stage_id = stage_id;
    }

    public String getScope_id() {
        return scope_id;
    }

    public void setScope_id(String scope_id) {
        this.scope_id = scope_id;
    }

    public String getEducation() {
        return education;
    }

    public void setEducation(String education) {
        this.education = education;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getInstagram() {
        return instagram;
    }

    public void setInstagram(String instagram) {
        this.instagram = instagram;
    }

    public String getFacebook() {
        return facebook;
    }

    public void setFacebook(String facebook) {
        this.facebook = facebook;
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
