package pl.niepracuj.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static pl.niepracuj.util.TestUtils.toJson;

import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtensionContext;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.ArgumentsProvider;
import org.junit.jupiter.params.provider.ArgumentsSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.security.test.context.support.WithMockUser;
import org.springframework.test.context.jdbc.Sql;
import org.springframework.test.context.jdbc.SqlGroup;
import org.springframework.test.web.servlet.MockMvc;
import pl.niepracuj.model.dto.AdvertisementSearchCriteriaDto;
import pl.niepracuj.model.enums.SeniorityEnum;
import pl.niepracuj.model.enums.TechnologyEnum;

import java.awt.*;
import java.util.stream.Stream;

@SpringBootTest
@AutoConfigureMockMvc
@SqlGroup({
        @Sql(scripts = "/sql/controller/advertisement.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
        @Sql(scripts = "/sql/controller/advertisement-cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
})
public class AdvertisementControllerIT {

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void whenGetAllAdvertisements_thenReturnAdvertisements() throws Exception {
        // when && then
        mockMvc.perform(get("/adv/all")).andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.equalTo(3)));
    }

    @Test
    @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    public void whenGetAdvertisementsByCriteria_thenOkResponse() throws Exception {
        // given
        var criteria = AdvertisementSearchCriteriaDto.builder()
                .technologyName(TechnologyEnum.JAVA).build();
        var criteriaJson = toJson(criteria);

        // when && then
        mockMvc.perform(post("/adv/search?page=0&size=10&sort=id,DESC")
                        .content(criteriaJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.equalTo(2)));
    }

   @ParameterizedTest
   @ArgumentsSource(CriteriaProvider.class)
   @WithMockUser(username = "admin", password = "admin", roles = {"ADMIN"})
    public void whenGetAdvertisementsByCriteriaParametrized_thenOkResponse(TechnologyEnum technologyEnum,
                                                                           String city, SeniorityEnum seniorityEnum, int result) throws Exception {
        // given
        var criteria = AdvertisementSearchCriteriaDto.builder()
                .technologyName(technologyEnum)
                .cityName(city)
                .seniorityName(seniorityEnum)
                .build();
        var criteriaJson = toJson(criteria);

        // when && then
        mockMvc.perform(post("/adv/search?page=0&size=10&sort=id,DESC")
                        .content(criteriaJson)
                        .contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$.size()", Matchers.equalTo(result)));
    }

static class CriteriaProvider implements ArgumentsProvider{

    @Override
    public Stream<? extends Arguments> provideArguments(ExtensionContext extensionContext) throws Exception {
        return Stream.of(
                Arguments.of(TechnologyEnum.JAVA, null, null, 2),
                Arguments.of(TechnologyEnum.HTML, null, null, 1)
        );
    }
}
}
