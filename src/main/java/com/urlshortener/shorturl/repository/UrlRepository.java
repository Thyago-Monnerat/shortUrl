package com.urlshortener.shorturl.repository;

import com.urlshortener.shorturl.model.UrlModel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UrlRepository extends JpaRepository<UrlModel, String> {

}
