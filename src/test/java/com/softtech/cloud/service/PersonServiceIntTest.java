package com.softtech.cloud.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import javax.transaction.Transactional;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.fasterxml.jackson.databind.ObjectMapper;

@ActiveProfiles({ "test", "oauth" })
@RunWith(SpringRunner.class)
@SpringBootTest
@Transactional
@AutoConfigureMockMvc
public class PersonServiceIntTest {

    ObjectMapper mapper = new ObjectMapper();

    @Autowired
    private MockMvc mockMvc;

    @Test
    public void testCreate() throws Exception {
        final String firstname = "First";
        final String lastname = "Last";
        final String eyeColor = "brown";
        final String address = "12345 Tree St. City, State US";
        final String email = "first.last@testing.gov";

        final Person person = new Person();
        person.setAddress(address);
        person.setFirstname(firstname);
        person.setLastname(lastname);
        person.setEmail(email);
        person.setEyeColor(eyeColor);

        final String newUserPost = mapper.writeValueAsString(person);

        final MockHttpServletResponse response = mockMvc
                .perform(post("/api/person").content(newUserPost).contentType(MediaType.APPLICATION_JSON))
                .andDo(print()).andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON_UTF8)).andReturn().getResponse();
        final String responseContent = response.getContentAsString();
        assertNotNull(responseContent);

        final Person returnedPerson = mapper.readValue(responseContent, Person.class);
        assertNotNull(returnedPerson.getId());
        assertEquals(firstname, returnedPerson.getFirstname());
        assertEquals(lastname, returnedPerson.getLastname());
        assertEquals(eyeColor, returnedPerson.getEyeColor());
        assertEquals(address, returnedPerson.getAddress());
        assertEquals(email, returnedPerson.getAddress());
    }
    
}
