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
@Table(name = "scope")
public class scope implements Serializable{
    
    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "scope_id", length = 300)
    private String scope_id;

    @NotEmpty(message = "Nama tidak boleh kosong")
    @Column(name = "name", length = 300, nullable = false)
    private String name;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    public scope() {
    }

    public scope(String scope_id, @NotEmpty(message = "Nama tidak boleh kosong") String name, Date created_at,
            Date updated_at) {
        this.scope_id = scope_id;
        this.name = name;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getScope_id() {
        return scope_id;
    }

    public void setScope_id(String scope_id) {
        this.scope_id = scope_id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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