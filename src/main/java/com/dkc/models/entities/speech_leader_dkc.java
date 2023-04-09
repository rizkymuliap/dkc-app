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
@Table(name = "speech_leader_dkc")
public class speech_leader_dkc implements Serializable {
    
    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "speech_id", length = 300)
    private String speech_id;

    @NotEmpty(message = "Nama tidak boleh kosong")
    @Column(name = "name", length = 300, nullable = false)
    private String name;

    @NotEmpty(message = "NTA tidak boleh kosong")
    @Column(name = "nta", length = 300, unique = true, nullable = false)
    private String nta;

    @NotEmpty(message = "Gambar tidak boleh kosong")
    @Column(name = "image", length = 300, nullable = false)
    private String image;

    @NotEmpty(message = "Deskripsi tidak boleh kosong")
    @Column(name = "description", columnDefinition = "text", nullable = false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    public speech_leader_dkc() {
    }

    public speech_leader_dkc(String speech_id, @NotEmpty(message = "Nama tidak boleh kosong") String name,
            @NotEmpty(message = "NTA tidak boleh kosong") String nta,
            @NotEmpty(message = "Gambar tidak boleh kosong") String image,
            @NotEmpty(message = "Deskripsi tidak boleh kosong") String description, Date created_at, Date updated_at) {
        this.speech_id = speech_id;
        this.name = name;
        this.nta = nta;
        this.image = image;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getSpeech_id() {
        return speech_id;
    }

    public void setSpeech_id(String speech_id) {
        this.speech_id = speech_id;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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
