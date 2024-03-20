package com.dutchOrder.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import lombok.RequiredArgsConstructor;

import java.util.StringJoiner;

@RestController
@RequiredArgsConstructor
public class CookieController {

    private static final String NO_COOKIES_FOUND = "No cookies found";

    @GetMapping("/read-cookies")
    public String readCookies(HttpServletRequest request) {
        Cookie[] cookies = request.getCookies();
        if (cookies != null) {
            StringJoiner sj = new StringJoiner("\n");
            for (Cookie cookie : cookies) {
                sj.add(String.format("Name: %s, Value: %s", cookie.getName(), cookie.getValue()));
            }
            return sj.toString();
        }
        return NO_COOKIES_FOUND;
    }
    
    @GetMapping("/test")
    public String test() {
        return "Test successful!";
    }

}
