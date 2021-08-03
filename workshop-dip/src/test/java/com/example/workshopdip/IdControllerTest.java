package com.example.workshopdip;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IdControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test
    @DisplayName("ทำการทดสอบ rest api /id")
    public void case01() {
        IdResponse response = restTemplate.getForObject("/id", IdResponse.class);
        assertEquals("XYZ7", response.getResult());
    }
}