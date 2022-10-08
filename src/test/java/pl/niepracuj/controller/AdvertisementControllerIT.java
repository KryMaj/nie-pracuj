package pl.niepracuj.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.web.servlet.MockMvc;

@SpringBootTest
@AutoConfigureMockMvc
public class AdvertisementControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    @Sql("/sql/controller/advertisement.sql")
    public void whenGetAllAdvertisements_thenReturnAdvertisements() throws Exception {
        // when && then
        mockMvc.perform(get("/adv/all")).andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.equalTo(1)));
    }


}
