package com.amgadFarag.cpn.services;

import com.amgadFarag.cpn.dtos.FilterDTO;
import com.amgadFarag.cpn.entities.Customer;
import org.junit.Test;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;

import com.amgadFarag.cpn.dtos.CustomerDTO;
import com.amgadFarag.cpn.repository.CustomerRepository;

import static org.mockito.Mockito.mock;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class CustomerServiceTest {
    @MockBean
    private CustomerRepository customerRepoMock;

    @Autowired
    private CustomerService customerService;


    @Test
    public void getCustomerByFilterTest() {
        // Given
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("A Testable Customer");
        customer.setPhone("(212) 698054317");
        customers.add(customer);

//        CustomerRepository customerRepoMock = mock(CustomerRepository.class);
        Mockito.when(customerRepoMock.findAll()).thenReturn(customers);

        // When
        List<CustomerDTO> customerDTOsResult = customerService.getCustomerByFilter(new FilterDTO());

        // Then
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1);
        customerDTO.setName("A Testable Customer");
        customerDTO.setPhone("(212) 698054317");
        customerDTO.setValid(true);
        customerDTO.setCountry("Morocco");
        customerDTO.setCountryCode("+212");

        assertThat(customerDTOsResult).isNotNull();
        assertThat(customerDTOsResult.get(0).toString()).isEqualTo(customerDTO.toString());
    }

    @Test
    public void getAllCustomersTest() {
        // Given
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("A Testable Customer");
        customer.setPhone("(212) 698054317");
        customers.add(customer);

//        CustomerRepository customerRepoMock = mock(CustomerRepository.class);
        Mockito.when(customerRepoMock.findAll()).thenReturn(customers);

        // When
        List<CustomerDTO> customerDTOsResult = customerService.getAllCustomers();

        // Then
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1);
        customerDTO.setName("A Testable Customer");
        customerDTO.setPhone("(212) 698054317");
        customerDTO.setValid(true);
        customerDTO.setCountry("Morocco");
        customerDTO.setCountryCode("+212");

        assertThat(customerDTOsResult).isNotNull();
        assertThat(customerDTOsResult.get(0).toString()).isEqualTo(customerDTO.toString());
    }

    @Test
    public void fillCustomerDTOTest() {
        // Given
        List<Customer> customers = new ArrayList<>();
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("A Testable Customer");
        customer.setPhone("(212) 698054317");

        customers.add(customer);


        // When
        List<CustomerDTO> customerDTOs = customerService.fillCustomerDTO(customers);

        // Then
        CustomerDTO customerDTO = new CustomerDTO();
        customerDTO.setId(1);
        customerDTO.setName("A Testable Customer");
        customerDTO.setPhone("(212) 698054317");
        customerDTO.setValid(true);
        customerDTO.setCountry("Morocco");
        customerDTO.setCountryCode("+212");


        assertThat(customerDTOs).isNotNull();
        assertThat(customerDTOs.get(0).toString()).isEqualTo(customerDTO.toString());
    }

}
