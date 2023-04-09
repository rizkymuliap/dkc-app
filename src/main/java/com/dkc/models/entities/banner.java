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
@Table(name = "banner")
public class banner implements Serializable {

    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "banner_id", length = 300)
    private String banner_id;

    @NotEmpty(message = "Gambar tidak boleh kosong")
    @Column(name = "image", length = 300, nullable = false)
    private String image;

    @NotEmpty(message = "Tipe tidak boleh kosong")
    @Column(name = "type", length = 300, nullable = false)
    private String type;
    
    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    public banner() {
    }


    public banner(String id, @NotEmpty(message = "Gambar tidak boleh kosong") String image, Date created_at,
            Date updated_at) {
        this.banner_id = id;
        this.image = image;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }



    public static long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
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


    public String getBanner_id() {
        return banner_id;
    }


    public void setBanner_id(String banner_id) {
        this.banner_id = banner_id;
    }


    public String getType() {
        return type;
    }


    public void setType(String type) {
        this.type = type;
    }

    
}
