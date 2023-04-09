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
@Table(name = "goal")
public class goal implements Serializable {
    
    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "goal_id",length = 300)
    private String goal_id;

    @NotEmpty(message = "Keterangan tidak boleh kosong")
    @Column(name = "description", columnDefinition = "text", length = 300, nullable = false)
    private String description;

    @NotEmpty(message = "Tipe tidak boleh kosong")
    @Column(name = "type", length = 300, nullable = false)
    private String type;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    public goal() {
    }

    public goal(String goal_id, @NotEmpty(message = "Keterangan tidak boleh kosong") String description,
            @NotEmpty(message = "Tipe tidak boleh kosong") String type, Date created_at, Date updated_at) {
        this.goal_id = goal_id;
        this.description = description;
        this.type = type;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getGoal_id() {
        return goal_id;
    }

    public void setGoal_id(String goal_id) {
        this.goal_id = goal_id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
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
