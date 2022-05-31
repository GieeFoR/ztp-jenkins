package com.jenkinsgieefor;

import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

@org.springframework.stereotype.Service
public class Service {

    private final UserRepository userRepository;
    private final RestTemplate restTemplate;
    private final Url url;

    public Service(UserRepository userRepository, RestTemplate restTemplate, Url url) {
        this.userRepository = userRepository;
        this.restTemplate = restTemplate;
        this.url = url;
    }


    public User getUser(boolean persist) {
        final String uri = url.getUrl();
        Random rand = new Random();

        ResponseEntity<User[]> responseEntity =
                restTemplate.getForEntity(uri, User[].class);
        List<User> users = Arrays
                .stream(responseEntity.getBody())
                .collect(Collectors.toList());
        User result = users.get(rand.nextInt(users.size()));

        if(persist) userRepository.save(result);
        return result;
    }

    public List<User> getUsers() {
        return userRepository.findAll();
    }

}
