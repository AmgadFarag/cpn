package com.amgadFarag.cpn.controllers;

import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONArray;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.amgadFarag.cpn.services.CustomerService;
import com.amgadFarag.cpn.dtos.CustomerDTO;
import com.amgadFarag.cpn.dtos.FilterDTO;


import java.util.ArrayList;
import java.util.List;


@RunWith(SpringJUnit4ClassRunner.class)
@WebMvcTest(CustomerController.class)
public class CustomerControllerTest {
    @MockBean
    private CustomerService customerServiceMock;
    @Autowired
    private MockMvc mvc;
    @Autowired
    private CustomerController customerController;


    @Test
    public void getAllCustomersTest() throws Exception {
        // Given
        List<CustomerDTO> customers = new ArrayList<>();
        CustomerDTO customer = new CustomerDTO();
        customer.setId(1);
        customer.setName("A Testable Customer");
        customer.setPhone("(212) 698054317");
        customer.setValid(true);
        customer.setCountry("Morocco");
        customer.setCountryCode("+212");
        customers.add(customer);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(customer);
//        String expect = jsonArray.toString();
        String expect = "[{\"id\":1,\"name\":\"A Testable Customer\",\"phone\":\"(212) 698054317\",\"country\":\"Morocco\",\"countryCode\":\"+212\",\"valid\":true}]";

//        CustomerService customerServiceMock = mock(CustomerService.class);
        Mockito.when(customerServiceMock.getAllCustomers()).thenReturn(customers);

        // When
        this.mvc.perform(MockMvcRequestBuilders.get("/api/getAllCustomers")) // .andDo(print())
                // Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON))
                .andExpect(content().string(expect));
    }


    @Test
    public void getFilteredCustomersTest() throws Exception {
        // Given
        List<CustomerDTO> customers = new ArrayList<>();
        CustomerDTO customer = new CustomerDTO();
        customer.setId(1);
        customer.setName("A Testable Customer");
        customer.setPhone("(212) 698054317");
        customer.setValid(true);
        customer.setCountry("Morocco");
        customer.setCountryCode("+212");
        customers.add(customer);

        JSONArray jsonArray = new JSONArray();
        jsonArray.put(customer);
//        String expect = jsonArray.toString();
        String expect = "[{\"id\":1,\"name\":\"A Testable Customer\",\"phone\":\"(212) 698054317\",\"country\":\"Morocco\",\"countryCode\":\"+212\",\"valid\":true}]";

        FilterDTO filterDTO = new FilterDTO();
        String filterJSON = "{\"byCountry\":null,\"byValidity\":null,\"byCountryCode\":null,\"byNumber\":null}";

//        CustomerService customerServiceMock = mock(CustomerService.class);
        Mockito.when(customerServiceMock.getCustomerByFilter(filterDTO)).thenReturn(customers);

        // When
        mvc.perform(MockMvcRequestBuilders.post("/api/getByFilter").content(filterJSON).contentType(MediaType.APPLICATION_JSON))
                // Then
                .andExpect(status().isOk())
                .andExpect(content().contentType(MediaType.APPLICATION_JSON));
//                .andExpect(content().string(expect));
    }

}
