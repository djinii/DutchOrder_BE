package com.dutchOrder.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;


@RestController
public class CookieController {

    @GetMapping("/read-cookies")
    public String readCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            StringBuilder sb = new StringBuilder();
            for (Cookie cookie : cookies) {
                sb.append(String.format("Name: %s, Value: %s\n", cookie.getName(), cookie.getValue()));
            }
            return sb.toString();
        }
        return "No cookies found";
    }
    
    @GetMapping("/test")
    public String test() {
        return "Test successful!";
    }

}
