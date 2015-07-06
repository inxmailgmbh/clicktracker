package com.clicktracker

import com.inxmail.clicktracker.controller.UrlController

import static org.hamcrest.Matchers.equalTo;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.header
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockServletContext;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MockServletContext.class)
@WebAppConfiguration
public class UrlControllerTest {

    private MockMvc mvc;

    @Before
    public void setUp() throws Exception {
        mvc = MockMvcBuilders.standaloneSetup(new UrlController()).build();
    }


    // POST tests
    @Test
    public void createUrlEmpty() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/api/url").accept(MediaType.APPLICATION_JSON).content('{}').contentType(MediaType.APPLICATION_JSON))
        .andExpect(status().is(422))

    }

    @Test
    public void createUrlWithJson() throws Exception{
        mvc.perform(MockMvcRequestBuilders.post("/api/url").accept(MediaType.APPLICATION_JSON).content('{"longUrl": "https://url.to.something/"}').contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isCreated())
                .andExpect(header().string("Location","https://url.to.something/"))

    }


    // GET tests
    @Test
    public void getUrlNoSlug() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/url").accept(MediaType.APPLICATION_JSON))
                .andExpect(status().is(400))

    }

    @Test
    public void getUrl() throws Exception{
        mvc.perform(MockMvcRequestBuilders.get("/api/url").accept(MediaType.APPLICATION_JSON).param("slug","abc123"))
                .andExpect(status().isOk())
                .andExpect(jsonPath("slug").value("abc123"))
    }
}
