package com.hiratab.springbootkeycloak;

import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MyController {
    @GetMapping("/protected")
    public String index(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Hello, %s!", jwt.getClaimAsString("preferred_username"));
    }

    @GetMapping("/protected/premium")
    public String premium(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Hello, %s!", jwt.getClaimAsString("preferred_username"));
    }

    @GetMapping("/public")
    public String publicEndpoint() {
        return "I'm a public endpoint";
    }

    @GetMapping("/new-endpoint")
    public String newEndpoint(@AuthenticationPrincipal Jwt jwt) {
        return String.format("Hello, %s!", jwt.getClaimAsString("preferred_username"));
    }
}
