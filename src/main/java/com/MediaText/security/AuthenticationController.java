package com.MediaText.security;

import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins={ "http://localhost:3000", "http://localhost:4200" })
@RestController
public class AuthenticationController {
    //http://localhost:8080/basicauth
    @GetMapping(path = "/basicauth")
    public Authentication helloWorldBean() {
        //throw new RuntimeException("Some Error has Happened! Contact Support at ***-***");
        return new Authentication("You are authenticated");
    }
}
