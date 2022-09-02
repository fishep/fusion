package com.fishep.fusion.user.interfaces.api;

import net.minidev.json.JSONObject;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultHandlers;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@AutoConfigureMockMvc
class AuthControllerTest {

    private String registerUri = "/api/auth/register";

    @Autowired
    private MockMvc mockMvc;

    @Test
    void register() throws Exception {

        Map<String, String> request = new HashMap<>();
        request.put("name", "user1");
        request.put("email", "user1@email.com");
        request.put("password", "123456789");
        String requestJson = JSONObject.toJSONString(request);

        MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders
                .post(registerUri)
                .content(requestJson)
                .contentType(MediaType.APPLICATION_JSON)
                .accept(MediaType.APPLICATION_JSON);

        ResultActions response = mockMvc.perform(requestBuilder);
        response.andExpect(MockMvcResultMatchers.status().isOk());
        response.andExpect(MockMvcResultMatchers.jsonPath("$.code", Matchers.is(201)));
        response.andExpect(MockMvcResultMatchers.jsonPath("$.data", Matchers.notNullValue()));

//        MvcResult result = response.andReturn();
//        String content = result.getResponse().getContentAsString();
//        System.out.println(content);

        response.andDo(MockMvcResultHandlers.print());
    }

}