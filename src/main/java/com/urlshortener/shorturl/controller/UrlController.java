package com.urlshortener.shorturl.controller;

import com.urlshortener.shorturl.model.UrlModel;
import com.urlshortener.shorturl.service.UrlService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.security.NoSuchAlgorithmException;

@Controller
@RequestMapping("")
public class UrlController {
    @Autowired
    private UrlService urlService;

    @PostMapping("shorten-url")
    @ResponseBody
    public String shortenURL(@RequestBody UrlModel urlModel) throws NoSuchAlgorithmException {
        return urlService.shortenURL(urlModel.getUrl());
    }

    @GetMapping("{shortUrl}")
    public String redirect(@PathVariable String shortUrl) {
        return "redirect:" + urlService.getOriginalUrl(shortUrl);
    }
}
