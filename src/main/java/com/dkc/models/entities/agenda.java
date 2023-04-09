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
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "agenda")
public class agenda implements Serializable{

    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "agenda_id", length = 300)
    private String agenda_id;

    @NotEmpty(message = "Title tidak boleh kosong")
    @Column(name = "title", length = 300, nullable = false)
    private String title;
   

    @Temporal(TemporalType.TIMESTAMP)
    @NotNull(message = "Schedule tidak boleh kosong")
    @Column(name = "schedule_at", nullable = false)
    private Date schedule_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    public agenda() {
    }

    public agenda(String agenda_id, @NotEmpty(message = "Title tidak boleh kosong") String title,
            @NotEmpty(message = "Jadwal tidak boleh kosong") Date schedule_at, Date created_at, Date updated_at) {
        this.agenda_id = agenda_id;
        this.title = title;
        this.schedule_at = schedule_at;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getAgenda_id() {
        return agenda_id;
    }

    public void setAgenda_id(String agenda_id) {
        this.agenda_id = agenda_id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Date getSchedule_at() {
        return schedule_at;
    }

    public void setSchedule_at(Date schedule_at) {
        this.schedule_at = schedule_at;
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
