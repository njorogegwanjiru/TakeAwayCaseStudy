package com.takeaway.case_study.exception;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
public class ExceptionHandlingTests {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testHandleResourceNotFoundException() throws Exception {
        mockMvc.perform(get("/api/country/fetch/{id}", 100))
                .andExpect(status().isNotFound())
                .andExpect(jsonPath("$.message").value("Country with ID 100 not found"));
    }
}
