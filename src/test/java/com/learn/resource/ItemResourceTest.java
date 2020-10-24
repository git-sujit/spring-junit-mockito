package com.learn.resource;

import com.learn.business.ItemBusinessService;
import com.learn.entity.Item;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.RequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(value = ItemResource.class)
public class ItemResourceTest {
    @Autowired
    private MockMvc mockMvc;

    @MockBean
    ItemBusinessService itemBusinessService;

    @Test
    public void item_basic() throws Exception {
        RequestBuilder request = MockMvcRequestBuilders
                .get("/item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{\"id\":1,\"name\":\"Bat\",\"price\":10.5,\"quantity\":100}"))
                .andReturn();

    }

    @Test
    public void item_business() throws Exception {
        when(itemBusinessService.retrieveItem()).thenReturn(new Item(1, "Bat", 10.5, 100));

        RequestBuilder request = MockMvcRequestBuilders
                .get("/b-item")
                .accept(MediaType.APPLICATION_JSON);
        MvcResult result = mockMvc
                .perform(request)
                .andExpect(status().isOk())
                .andExpect(content().json("{id:1, name:Bat, price:10.5, quantity:100}"))
                .andReturn();

    }
}
