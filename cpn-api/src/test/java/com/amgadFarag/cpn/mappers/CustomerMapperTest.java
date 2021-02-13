package com.amgadFarag.cpn.mappers;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;
import static org.assertj.core.api.Assertions.*;

import com.amgadFarag.cpn.entities.Customer;
import com.amgadFarag.cpn.dtos.CustomerDTO;

@RunWith(SpringRunner.class)
public class CustomerMapperTest {

    @Test
    public void whenMapping() {
        // Given
        Customer customer = new Customer();
        customer.setId(1);
        customer.setName("A Testable Customer");
        customer.setPhone("(+234) 12345678");

        // When
        CustomerDTO customerDTO = CustomerMapper.instance.toDto(customer);

        // Then
        assertThat(customerDTO.getId()).isEqualTo(customer.getId());
        assertThat(customerDTO.getName()).isEqualTo(customer.getName());
        assertThat(customerDTO.getPhone()).isEqualTo(customer.getPhone());
    }
}
