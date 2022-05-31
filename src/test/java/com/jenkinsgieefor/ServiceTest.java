package com.jenkinsgieefor;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.BDDMockito.given;

@ExtendWith(MockitoExtension.class)
class ServiceTest {

    @InjectMocks
    private Service service;

    @Mock
    private Url url;

    @Mock
    private RestTemplate restTemplate;

    @Test
    void getUserWithoutSave() {
        User[] users = new User[5];
        users[0] = new User(1234, "Jan Kowalski", "jan.kowalski@example.com", "male", "active");
        users[1] = new User(2341, "Janina Kowalska", "janina.kowalski@example.com", "female", "active");
        users[2] = new User(3412, "Adam Nowak", "adam.nowak@example.com", "male", "inactive");
        users[3] = new User(4123, "Krzysztof Nowak", "krzysztof.nowak@example.com", "male", "active");
        users[4] = new User(4321, "Emilia Nowak", "emilia.nowak@example.com", "female", "active");


        given(url.getUrl()).willReturn("https://gorest.co.in/public/v2/users");
        given(restTemplate.getForEntity(url.getUrl(), User[].class))
                .willReturn(ResponseEntity.ok().body(users));

        assertTrue(Arrays.stream(users).anyMatch(item -> service.getUser(false).equals(item)));
    }
}