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
@Table(name = "product")
public class product implements Serializable{

    private static final Long serialVersionUID = 1L;

    @Id
    @Column(name = "product_id", length = 300)
    private String product_id;

    @NotEmpty(message = "Gambar tidak boleh kosong")
    @Column(name = "image", length = 300, nullable = false)
    private String image;

    @NotEmpty(message = "Nama tidak boleh kosong")
    @Column(name = "name", length = 300, nullable = false)
    private String name;

    @NotEmpty(message = "Link tidak boleh kosong")
    @Column(name = "link", length = 300, nullable = false)
    private String link;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "created_at")
    private Date created_at;

    @Temporal(TemporalType.TIMESTAMP)
    @Column(name = "updated_at")
    private Date updated_at;

    public product() {
    }

    public product(String product_id, @NotEmpty(message = "Gambar tidak boleh kosong") String image,
            @NotEmpty(message = "Nama tidak boleh kosong") String name,
            @NotEmpty(message = "Link tidak boleh kosong") String link, Date created_at, Date updated_at) {
        this.product_id = product_id;
        this.image = image;
        this.name = name;
        this.link = link;
        this.created_at = created_at;
        this.updated_at = updated_at;
    }

    public static Long getSerialversionuid() {
        return serialVersionUID;
    }

    public String getProduct_id() {
        return product_id;
    }

    public void setProduct_id(String product_id) {
        this.product_id = product_id;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
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
