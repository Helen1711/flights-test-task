package ua.com.lena.flights.controllers;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import ua.com.lena.flights.entities.Aircompany;
import ua.com.lena.flights.entities.AircompanyType;
import ua.com.lena.flights.service.AircompanyService;

import java.time.LocalDate;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import static org.hamcrest.Matchers.hasSize;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.CoreMatchers.is;

@WebMvcTest(AircompanyController.class)
class AircompanyControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private AircompanyService mockService;

    @Autowired
    private ObjectMapper objectMapper;

    @Test
    void shouldReturnAllCompanies() throws Exception {
        var aircompanies = List.of(new Aircompany(LocalDate.of(2020, 1, 1), "name", AircompanyType.LOW_COST));

        when(mockService.getAll()).thenReturn(aircompanies);

        mockMvc.perform(get("/api/v1/aircompanies"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].name", is("name")));
    }

    @Test
    void shouldReturnEmptyListForAbsentCompanies() throws Exception {
        when(mockService.getAll()).thenReturn(Collections.emptyList());

        mockMvc.perform(get("/api/v1/aircompanies"))
                .andExpect(status().isOk());
    }

    @Test
    void shouldReturnCompanyById() throws Exception {
        var aircompany = Optional.of(new Aircompany(LocalDate.of(2020, 1, 1), "name", AircompanyType.LOW_COST));

        when(mockService.getById(anyLong())).thenReturn(aircompany.get());

        mockMvc.perform(get("/api/v1/aircompanies/{id}", aircompany.get().getId()))
                .andExpect(status().isOk());
    }

    @Test
    void shouldCreateAircompany() throws Exception {
        Aircompany company = new Aircompany(LocalDate.of(2020, 1, 1), "name", AircompanyType.LOW_COST);

        mockMvc.perform(post("/api/v1/aircompanies")
                .content(objectMapper.writeValueAsString(company))
                .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated());
    }
}