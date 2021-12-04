package ru.news.backend.controller;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import ru.news.backend.NewsApplication;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@AutoConfigureMockMvc
@SpringBootTest(classes={NewsApplication.class})
public class MeduzaNewsApiControllerTests {
    @Autowired
    private MockMvc mockMvc;

    @Test
    void getNews_thenReturnCorrect() {
        String url = "/news?pageNumber=0";
        try {
            MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(url))
                    .andDo(print())
                    .andExpect(status().isOk())
                    .andReturn();
            assertEquals(200,mvcResult.getResponse().getStatus());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

/*
    @Test
    void testLists_thenReturnCorrect() {
        List<Integer> list = Arrays.asList(1,3,21,32,423,432,53251);
        List<Integer> list2 = Arrays.asList(1,3,21,32,423,432,53251);
        assertEquals(list,list2);
    }
    @Test
    void testLists_thenReturnFalse() {
        List<Integer> list = Arrays.asList(1,3,21,32,423,432,53252);
        List<Integer> list2 = Arrays.asList(1,3,21,32,423,432,53251);
        assertNotEquals(list,list2);
    }
    @Test
    void testLists_thenReturnException() {
      ArithmeticException arithmeticException = assertThrows(ArithmeticException.class,() -> {
          int a = 5/0;
      });
     // assertEquals(arithmeticException.getMessage(),"/ by zero");
      assertTrue(arithmeticException.getMessage().contains("by zero"));
    }
    @Test
    void testLists_thenReturnGroupTestOk() {
        List<Integer> list = Arrays.asList(1,3,21,32,423,432,53252);
        List<Integer> list2 = Arrays.asList(1,3,21,32,423,432,53251);
        List<Integer> lisе3 = Arrays.asList(1,3,21,32,423,432,53252);
        List<Integer> list4 = Arrays.asList(1,3,21,32,423,432,53252);
        assertAll(() -> {
            assertEquals(lisе3,list4);
            assertNotEquals(list,list2);
        });

    }*/
}
