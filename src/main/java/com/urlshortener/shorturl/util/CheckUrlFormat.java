package com.urlshortener.shorturl.util;

public class CheckUrlFormat {

    public static String checkFormat(String originalUrl){
        if (originalUrl.startsWith("http") || originalUrl.startsWith("ftp") || originalUrl.startsWith("mailto") || originalUrl.startsWith("file")) {
            return originalUrl;
        }
        return "//"+originalUrl;
    }
}
