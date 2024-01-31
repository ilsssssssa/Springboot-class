package com.vtxlab.bootcamp.bootcampsbfakedatabase;
// THIS CLASS IS ALREADY AN ENV, APP // ACT LIKE POSTMAN

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.controller.impl.DatabaseController;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.model.Cat;
import com.vtxlab.bootcamp.bootcampsbfakedatabase.service.CatDatabaseService;
import com.fasterxml.jackson.databind.ObjectMapper;

@WebMvcTest(DatabaseController.class) // Inject the web layer related bean to context(情境) only.
// so, in this test env, component scan(元件掃描) will ignore @Service, @Configuration, etc.
// but includes controller bean, mockmvc beans, etc.
class DatabaseControllerTest {

  @Autowired
  private MockMvc mockMvc;

  @Autowired
  private ObjectMapper objectMapper;
  
  // @Autowired // You cannot autowired service bean in WebMvcTest env.
  @MockBean // similar to @Mock
  // Because Controller Bean need to autowied service bean in WebMvcTest env
  private CatDatabaseService catDatabaseService;

  // 扮postman做test
  @Test
  void testGetCat() throws Exception {
    // assumption(假設)
    Cat mockedReturnCat = new Cat("ABCD", 3);
    // when
    Mockito.when(catDatabaseService.getCat(1)).thenReturn(mockedReturnCat);
    // assert(宣稱)
    mockMvc.perform(get("/api/v1/cat/{idx}", 1))
        .andExpect(status().isOk()) // http code 200 -> OK
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.name").value("ABCD"))
        .andExpect(jsonPath("$.age").value(3))
        .andDo(print()); // similar to sysout, toString()


    // wrong path
    mockMvc.perform(get("/api/v1/api/v1/cat/{idx}", 1))
        .andExpect(status().isNotFound()) // http code 200 -> OK
        .andDo(print()); // similar to sysout, toString()
  }

  @Test
  void testPostCat() throws Exception {
    Cat catToPost = new Cat("Sam", 10);

    // when
    Mockito.when(catDatabaseService.setCat(1, catToPost)).thenReturn(catToPost);
    // assert
    mockMvc.perform(post("/api/v1/cat/idx/{idx}", 1)
       .contentType(MediaType.APPLICATION_JSON) //
       .content(objectMapper.writeValueAsString(catToPost))) //
       .andExpect(status().isOk()) //
       .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
       .andExpect(jsonPath("$.name").value("Sam")) //
       .andExpect(jsonPath("$.age").value(10)) //
       .andDo(print());
  }

  @Test
  void testDeleteCat() throws Exception {
    Mockito.when(catDatabaseService.deleteCat(1).thenReturn())

  }

}

