package com.nttdata.model;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;

import java.util.List;
import java.util.Map;

@JsonPropertyOrder({"id", "category", "name", "photoUrls", "tags", "status"})
public class Mascota {
    private String id;
    private Map category;
    private String name;
    private List photoUrls;
    private List tags;
    private String status;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Map getCategory() {
        return category;
    }

    public void setCategory(Map category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List getPhotoUrls() {
        return photoUrls;
    }

    public void setPhotoUrls(List photoUrls) {
        this.photoUrls = photoUrls;
    }

    public List getTags() {
        return tags;
    }

    public void setTags(List tags) {
        this.tags = tags;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}