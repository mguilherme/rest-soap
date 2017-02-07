package com.guilherme.miguel.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Miguel Guilherme
 */
@RestController
public class HomeController {

    @GetMapping("home")
    public Map<String, Object> home() {
        Map<String, Object> data = new HashMap<>();
        data.put("id", 1);
        data.put("name", "John Doe");

        return data;
    }

}
