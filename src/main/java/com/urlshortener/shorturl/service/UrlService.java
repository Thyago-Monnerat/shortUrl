package com.urlshortener.shorturl.service;

import com.urlshortener.shorturl.model.UrlModel;
import com.urlshortener.shorturl.repository.UrlRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Optional;

import static com.urlshortener.shorturl.util.CheckUrlFormat.checkFormat;

@Service
public class UrlService {

    private static final String BASE62 = "0123456789abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    private static final String BASE_URL = "http://localhost:8080/";

    @Autowired
    private UrlRepository urlRepository;

    public byte[] hashURL(String urlToShorten) throws NoSuchAlgorithmException {
        MessageDigest messageDigest = MessageDigest.getInstance("SHA-256");
        return messageDigest.digest(urlToShorten.getBytes(StandardCharsets.UTF_8));
    }

    public String encodeBase62(byte[] byteArr) {
        StringBuilder encodedURL = new StringBuilder();

        for (byte b : byteArr) {
            int value = b & 0xff;
            encodedURL.append(BASE62.charAt(value % 62));
        }

        return encodedURL.toString();
    }

    public String shortenURL(String url) throws NoSuchAlgorithmException {

        byte[] hashBytes = hashURL(url);
        String base62Hash = encodeBase62(hashBytes);
        String shortCode = base62Hash.substring(0, 8);

        UrlModel newUrl = new UrlModel();
        newUrl.setEncodedUrl(shortCode);
        newUrl.setUrl(url);

        urlRepository.save(newUrl);

        return BASE_URL + shortCode;
    }

    public String getOriginalUrl(String shortenUrl) {
        Optional<UrlModel> originalUrl = urlRepository.findById(shortenUrl);

        return originalUrl.map(urlModel -> checkFormat(urlModel.getUrl())).orElse(BASE_URL + "/error");
    }

}
