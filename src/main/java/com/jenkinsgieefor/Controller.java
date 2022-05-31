package com.jenkinsgieefor;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class Controller {

    @Autowired
    private Service service;

    @GetMapping(value = "/user")
    @ResponseBody
    public User user(@RequestParam(value = "persist", required = false) Boolean persist) {
        return service.getUser(persist != null && persist);
    }

    @GetMapping(value = "/users")
    @ResponseBody
    public List<User> users() {
        return service.getUsers();
    }
}
