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
    mockMvc.perform(get("/api/v1/cat/{idx}", 1)).andExpect(status().isOk()) // http code 200 -> OK
        .andExpect(content().contentType(MediaType.APPLICATION_JSON))
        .andExpect(jsonPath("$.name").value("ABCD"))
        .andExpect(jsonPath("$.age").value(3)).andDo(print()); // similar to sysout, toString()


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
    mockMvc
        .perform(post("/api/v1/cat/idx/{idx}", 1)
            .contentType(MediaType.APPLICATION_JSON) //
            .content(objectMapper.writeValueAsString(catToPost))) // "jackson" format, 變String
        .andExpect(status().isOk()) //
        .andExpect(content().contentType(MediaType.APPLICATION_JSON)) //
        .andExpect(jsonPath("$.name").value("Sam")) //
        .andExpect(jsonPath("$.age").value(10)) //
        .andDo(print()); // similar to sysout, toString()
  }

  @Test
  void testDeleteCat() throws Exception {
    Cat catToDelete = new Cat("Sam", 10);
    Mockito.when(catDatabaseService.deleteCat(0)).thenReturn(catToDelete);
    // assert
    mockMvc.perform(delete("/api/v1/cat/idx/{idx}", "0")) //
        .andExpect(status().isOk()) // http code 200 - OK
        .andExpect(content().string("true")) //
        .andDo(print()); // similar to sysout, toString()

    // when
    Mockito.when(catDatabaseService.deleteCat(1)).thenReturn(null);
    // assert
    mockMvc.perform(delete("/api/v1/cat/idx/{idx}", "1")) //
        .andExpect(status().isOk()) // http code 200 - OK
        .andExpect(content().string("false")) //
        .andDo(print()); // similar to sysout, toString()
  }

  @Test
  void testPutCat() throws Exception {
    Cat catToPut = new Cat("Sam", 10);
    String contentString = new ObjectMapper().writeValueAsString(catToPut);
    // when
    Mockito.when(catDatabaseService.updateCat(0, catToPut))
        .thenReturn(catToPut);
    // assert
    mockMvc.perform(put("/api/v1/cat/idx/{idx}", "0", catToPut) //
        .contentType(MediaType.APPLICATION_JSON) //
        .content(contentString)) //
        .andExpect(status().isOk()) // http code 200 - OK
        .andExpect(jsonPath("$.name").value("Sam")) //
        .andExpect(jsonPath("$.age").value(10)) //
        .andDo(print()); // similar to sysout, toString()
  }

  @Test
  void testPatchCatName() throws Exception {
    Cat patchedCat = new Cat("Allen", 5);
    // when
    Mockito.when(catDatabaseService.patchCatName(0, "Allen")).thenReturn(patchedCat);
    // assert
    mockMvc.perform(patch("/api/v1/cat/idx/{idx}/name/{name}", 0, "Allen")) //
        .andExpect(status().isOk()) // http code 200 - OK
        .andExpect(jsonPath("$.name").value("Allen")) //
        .andExpect(jsonPath("$.age").value(5)) //
        .andDo(print()); // similar to sysout, toString()
  }

  @Test
  void testPatchCatAge() throws Exception {
    Cat patchedCat = new Cat("Allen", 7);
    // when
    Mockito.when(catDatabaseService.patchCatAge(1, 7)).thenReturn(patchedCat);
    // assert
    mockMvc.perform(patch("/api/v1/cat/idx/{idx}/age/{age}", "1", "7")) //
        .andExpect(status().isOk()) // http code 200 - OK
        .andExpect(jsonPath("$.name").value("Allen")) //
        .andExpect(jsonPath("$.age").value(7)) //
        .andDo(print()); // similar to sysout, toString()
  }

}

