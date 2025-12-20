package htw.gruppe.backend.controller;
import com.fasterxml.jackson.databind.ObjectMapper;
import htw.gruppe.backend.entity.Kandidat;
import htw.gruppe.backend.record.Kandidaten;
import htw.gruppe.backend.repository.KandidatenRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;


import java.util.Optional;

import static org.hamcrest.Matchers.is;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@SpringBootTest
@AutoConfigureMockMvc
public class KandidatControllerTest {
    private final MockMvc mockMvc;
    private final ObjectMapper objectMapper;
    private final KandidatenRepository userRepository;

    @Autowired
    public KandidatControllerTest(MockMvc mockMvc,
                              ObjectMapper objectMapper,
                              KandidatenRepository kandidatenRepository) {
        this.mockMvc = mockMvc;
        this.objectMapper = objectMapper;
        this.userRepository = kandidatenRepository;
    }

    @BeforeEach
    void setUp() {
        userRepository.deleteAll();
    }

    @Test
    void createKandidaten() throws Exception {
        Kandidat kandidat = new Kandidat("123456", "Informatik", "geheim", "Max", "Muster", "Ich setze mich fuer mehr lernraeume ein", "AI");


    }








}
