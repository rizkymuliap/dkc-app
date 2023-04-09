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
@Table(name = "achievement")
public class achievement implements Serializable{
    
    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "achievement_id", length = 300)
    private String achievement_id;

    @NotEmpty(message = "Title tidak boleh kosong")
    @Column(name = "title", length = 300, nullable = false)
    private String title;

    @NotEmpty(message = "Deskripsi tidak boleh kosong")
    @Column(name = "description", columnDefinition = "text", nullable =  false)
    private String description;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    public achievement() {
    }

    public achievement(String achievement_id, String title, String description, Date created_at, Date updated_at) {
        this.achievement_id = achievement_id;
        this.title = title;
        this.description = description;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getAchievement_id() {
        return achievement_id;
    }

    public void setAchievement_id(String achievement_id) {
        this.achievement_id = achievement_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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
