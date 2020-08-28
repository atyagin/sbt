package com.ilya.sbt.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ilya.sbt.domain.Client;
import com.ilya.sbt.mapper.ClientMapper;
import com.ilya.sbt.service.ClientService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import static org.hamcrest.Matchers.containsString;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyBoolean;
import static org.mockito.BDDMockito.given;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureMockMvc
@TestPropertySource("/application-test.properties")
//@Sql(value = {"/create-client-before.sql", "/messages-client-before.sql"}, executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD)
public class ClientControllerTest {
    @Autowired
    private ClientController controller;

    @Autowired
    MockMvc mockMvc;

    @Autowired
    private ClientService clientService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    public void getAllClients() throws Exception {
        this.mockMvc.perform(get("/api/v1/clients"))
                .andExpect(status().isOk());
    }

    @Test
    public void getClientById() throws Exception {
        mockMvc.perform(get("/api/v1/clients/1").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }

    @Test
    public void saveNewClient() throws Exception {
        Client client = new Client();
        client.setName("test name");

        String clientJson = objectMapper.writeValueAsString(client);

        mockMvc.perform(post("/api/v1/clients/")
                .contentType(MediaType.APPLICATION_JSON)
                .content(clientJson))
                .andExpect(status().isCreated());
    }
}
