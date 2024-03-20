//package com.dutchOrder.server.controller;
//
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import jakarta.servlet.http.Cookie;
//import jakarta.servlet.http.HttpServletRequest;
//
//
//@RestController
//public class CookieController {
//
//    @GetMapping("/read-cookies")
//    public String readCookies(HttpServletRequest request) {
//        Cookie[] cookies = request.getCookies();
//        if (cookies != null) {
//            StringBuilder sb = new StringBuilder();
//            for (Cookie cookie : cookies) {
//                sb.append(String.format("Name: %s, Value: %s\n", cookie.getName(), cookie.getValue()));
//            }
//            return sb.toString();
//        }
//        return "No cookies found";
//    }
//    
//    @GetMapping("/test")
//    public String test() {
//        return "Test successful!";
//    }
//
//}
package com.dutchOrder.server.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;

import java.util.StringJoiner;

@RestController
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
