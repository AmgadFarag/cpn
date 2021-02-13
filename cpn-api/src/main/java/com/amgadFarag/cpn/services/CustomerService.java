package com.amgadFarag.cpn.services;

import com.amgadFarag.cpn.mappers.CustomerMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amgadFarag.cpn.repository.CustomerRepository;
import com.amgadFarag.cpn.entities.Customer;
import com.amgadFarag.cpn.dtos.CustomerDTO;
import com.amgadFarag.cpn.dtos.FilterDTO;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {
    @Autowired
    private CustomerRepository customerRepository;
    @Autowired
    private PhoneValidatorService phoneValidatorService;


    /***
     * @param filterDTO : A DTO to hold the multiple filter criteria
     * @return A customerDTO list of all customers that fit the filter criteria
     * */
    public List<CustomerDTO> getCustomerByFilter(FilterDTO filterDTO) {
        List<CustomerDTO> customerDTOS = getAllCustomers();

        if (filterDTO.getByValidity() != null) {
            customerDTOS = customerDTOS.stream().filter(customer ->
                    filterDTO.getByValidity() == customer.isValid()
            ).collect(Collectors.toList());
        }

        if (filterDTO.getByCountry() != null && !"".equalsIgnoreCase(filterDTO.getByCountry())) {
            customerDTOS = customerDTOS.stream().filter(customer ->
                    {
                        try {
                            return phoneValidatorService.isCorrectCountry(customer.getCountry(), filterDTO.getByCountry());
                        } catch (Exception e) {
                            return false;
                        }
                    }
            ).collect(Collectors.toList());
        }

        if (filterDTO.getByCountryCode() != null && !"".equalsIgnoreCase(filterDTO.getByCountryCode())) {
            customerDTOS = customerDTOS.stream().filter(customer ->
                    {
                        try {
                            return phoneValidatorService.isCorrectCountryCode(customer.getCountryCode(), filterDTO.getByCountryCode());
                        } catch (Exception e) {
                            return false;
                        }
                    }
            ).collect(Collectors.toList());
        }

        if (filterDTO.getByNumber() != null && !"".equalsIgnoreCase(filterDTO.getByNumber())) {
            customerDTOS = customerDTOS.stream().filter(customer ->
                    {
                        try {
                            return phoneValidatorService.isCorrectNumber(customer.getPhone(), filterDTO.getByNumber());
                        } catch (Exception e) {
                            return false;
                        }
                    }
            ).collect(Collectors.toList());
        }

        return customerDTOS;
    }

    /***
     * @return A CustomerDTO list of mapped Customers
     * */
    public List<CustomerDTO> getAllCustomers() {
        List<Customer> customers = customerRepository.findAll();

        return fillCustomerDTO(customers);
    }

    /***
     * @param customers : A Customer list
     * @return A list of filled CustomerDTO
     * */
    public List<CustomerDTO> fillCustomerDTO(List<Customer> customers) {
        return customers.stream()
                .map(customer -> {
                    CustomerDTO customerDTO = CustomerMapper.instance.toDto(customer);
                    if (phoneValidatorService.isValidPhone(customerDTO.getPhone())) {
                        String[] countryAndCode = phoneValidatorService.getCountryAndCode(customerDTO.getPhone());
                        customerDTO.setCountry(countryAndCode[0]);
                        customerDTO.setCountryCode(countryAndCode[1]);
                        customerDTO.setValid(true);
                    } else {
                        customerDTO.setValid(false);
                    }

                    return customerDTO;
                })
                .collect(Collectors.toList());
    }
}
