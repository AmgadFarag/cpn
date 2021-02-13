package com.amgadFarag.cpn;

import static org.assertj.core.api.Assertions.assertThat;
import org.junit.Test;
import org.junit.runners.Suite;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.web.servlet.MockMvc;

import com.amgadFarag.cpn.controllers.CustomerController;
import com.amgadFarag.cpn.controllers.CustomerControllerTest;
import com.amgadFarag.cpn.services.CustomerService;

//@Suite.SuiteClasses({CustomerControllerTest.class})
@SpringBootTest
@AutoConfigureMockMvc
//@ContextConfiguration
public class CountryPhoneNumbersApplicationTests { //  extends junit.framework.TestCase
	@Autowired
	CustomerController customerController;
	@Autowired
	CustomerService customerService;


	@Test
	public void contextLoads() throws Exception {
//		assertThat(customerController).isNotNull();
//		assertThat(customerService).isNotNull();
	}

}
