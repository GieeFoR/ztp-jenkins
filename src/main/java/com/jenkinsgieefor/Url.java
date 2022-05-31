package com.jenkinsgieefor;

import org.springframework.stereotype.Component;

@Component
public class Url {

    public Url() {
        this.url = "https://gorest.co.in/public/v2/users";
    }

    private final String url;

    public String getUrl() {
        return url;
    }
}
