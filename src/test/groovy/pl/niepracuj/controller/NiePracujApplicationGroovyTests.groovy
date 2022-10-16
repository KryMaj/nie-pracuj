package pl.niepracuj.controller

import org.springframework.http.MediaType
import org.springframework.test.context.jdbc.Sql
import org.springframework.test.context.jdbc.SqlGroup
import pl.niepracuj.model.dto.AdvertisementSearchCriteriaDto
import pl.niepracuj.model.enums.SeniorityEnum
import pl.niepracuj.model.enums.TechnologyEnum

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post
import static pl.niepracuj.util.TestUtils.toJson;
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.web.servlet.MockMvc
import spock.lang.Specification

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status

@SpringBootTest
@AutoConfigureMockMvc
@SqlGroup([
    @Sql(scripts = "/sql/controller/advertisement.sql", executionPhase = Sql.ExecutionPhase.BEFORE_TEST_METHOD),
    @Sql(scripts = "/sql/controller/advertisement-cleanup.sql", executionPhase = Sql.ExecutionPhase.AFTER_TEST_METHOD)
])
class NiePracujApplicationGroovyTests extends Specification{
@Autowired
    protected MockMvc mockMvc

    def "one to one equals two" (){
        expect:
        1+1 ==2
    }

    def "one to one equals two with given when then" (){
        given:
        def num1= 1
        def num2= 1
        when:
        def result = num1+num2
        then:
        result ==2
    }

    def "should get all advertisement" (){
        given:
        def url= "/adv/all"
        when:
        def response = mockMvc.perform(get(url)).andReturn().response
        then:
        response.status == 200
    }


    def "numbers to power"(int a, int b, int c){
        expect:
        Math.pow(a,b) == c
        where:
        a|b|c
        1|2|1
        3|2|9
        3|3|27
    }

    def "should get all advertisement by criteria" (TechnologyEnum technology,
                                                    String city, SeniorityEnum seniority, int result){

        def criteria = AdvertisementSearchCriteriaDto.builder()
                .technologyName(technology)
                .cityName(city)
                .seniorityName(seniority)
                .build();
        def criteriaJson = toJson(criteria)

        def url= "/adv/search?page=0&size=10&sort=id,DESC"

        def response = mockMvc.perform(post(url)
                .content(criteriaJson)
                .contentType(MediaType.APPLICATION_JSON)).andReturn().response

        expect:
        toJson(response.contentAsString).size() == result

        where:
        technology         | city | seniority | result
        TechnologyEnum.JAVA| null | null      | 2
    }
}
