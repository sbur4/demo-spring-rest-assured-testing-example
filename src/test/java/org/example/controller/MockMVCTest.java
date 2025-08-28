package org.example.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(HelloController.class)
public class MockMVCTest {

    @Autowired
    private MockMvc mockMvc;

    @Test
    void testGetGreeting() throws Exception {
        mockMvc.perform(get("/api/hello/Tester"))
                .andExpect(status().isOk())
                .andExpect(content().string("Hello Tester!"));
    }
}
