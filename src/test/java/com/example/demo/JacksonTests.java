package com.example.demo;

import com.example.demo.domain.Owner;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;

public class JacksonTests {
    @Test
    public void testObjectMapperCreateJSONFromObject() throws JsonProcessingException
    {
        ObjectMapper objmapper = new ObjectMapper();
        Owner owner = Owner.builder()
                .id(1L)
                .age(22L)
                .name("ziskito")
                .address("C/street, 123")
                .build();
        String result = objmapper.writeValueAsString(owner);
        assertThat(result).isEqualTo("{\"id\":1,\"name\":\"ziskito\",\"age\":22,\"dir\":\"C/street, 123\"}");


    }

    @Test
    public void testObjectMapperCreatesObjectFromJSON() throws JsonProcessingException
    {
        Owner gud = Owner.builder()
            .id(1L)
            .age(22L)
            .name("ziskito")
            .address("C/street, 123")
            .build();

        String json = "{\"foo\":\"bar\",\"id\":1,\"name\":\"ziskito\",\"age\":22,\"dir\":\"C/street, 123\"}";
        ObjectMapper objmapper = new ObjectMapper();
        Owner owner = objmapper.readValue(json, Owner.class);

        assertThat(owner).isEqualTo(gud);

    }
}
