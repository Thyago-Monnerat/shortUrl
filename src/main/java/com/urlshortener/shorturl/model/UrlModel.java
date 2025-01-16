package com.urlshortener.shorturl.model;


import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class UrlModel {
    @Id
    private String encodedUrl;
    private String url;
}
