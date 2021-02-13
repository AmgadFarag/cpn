package com.amgadFarag.cpn.services;

import static org.assertj.core.api.Assertions.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class PhoneValidatorTest {
    @Autowired
    private PhoneValidatorService phoneValidatorService;

    @Test
    public void getCountryAndCodeTest() {
        // Given
        String correctPhone = "(212) 698054317";
        String incorrectPhone = "52";

        // When
        String[] correctCall = phoneValidatorService.getCountryAndCode(correctPhone);
        String[] incorrectCall = phoneValidatorService.getCountryAndCode(incorrectPhone);

        // Then
        assertThat(correctCall).isNotEmpty();
        assertThat(incorrectCall).isNotEmpty();

        assertThat(correctCall[0]).isEqualTo("Morocco");
        assertThat(correctCall[1]).isEqualTo("+212");

        assertThat(incorrectCall[0]).isEqualTo("");
        assertThat(incorrectCall[1]).isEqualTo("");
    }

    @Test
    public void isCorrectCountryTest() {
        // Given
        String correctPhone = "Morocco";
        String incorrectPhone = "Ura";

        // When
        boolean correctCall;
        boolean incorrectCall;
        try {
            correctCall = phoneValidatorService.isCorrectCountry(correctPhone, "Morocco");
        } catch (Exception e) {
            correctCall = false;
        }

        try {
            incorrectCall = phoneValidatorService.isCorrectCountry(incorrectPhone, "Morocco");
        } catch (Exception e) {
            incorrectCall = false;
        }

        // Then
        assertThat(correctCall).isTrue();
        assertThat(incorrectCall).isFalse();
    }

    @Test
    public void isValidPhoneTest() {
        // Given
        String correctPhone = "(212) 698054317";
        String incorrectPhone = "52";

        // When
        boolean correctCall = phoneValidatorService.isValidPhone(correctPhone);
        boolean incorrectCall = phoneValidatorService.isValidPhone(incorrectPhone);


        // Then
        assertThat(correctCall).isTrue();
        assertThat(incorrectCall).isFalse();
    }

    @Test
    public void isCorrectCountryCodeTest() {
        // Given
        String correctPhone = "+212";
        String incorrectPhone = "52";

        // When
        boolean correctCall;
        boolean incorrectCall;
        try {
            correctCall = phoneValidatorService.isCorrectCountryCode(correctPhone, "+212");
        } catch (Exception e) {
            correctCall = false;
        }

        try {
            incorrectCall = phoneValidatorService.isCorrectCountryCode(incorrectPhone, "+212");
        } catch (Exception e) {
            incorrectCall = false;
        }

        // Then
        assertThat(correctCall).isTrue();
        assertThat(incorrectCall).isFalse();
    }

    @Test
    public void isCorrectNumberTest() {
        // Given
        String correctPhone = "(212) 698054317";
        String incorrectPhone = "52";

        // When
        boolean correctCall;
        boolean incorrectCall;
        try {
            correctCall = phoneValidatorService.isCorrectNumber(correctPhone, "(212) 698054317");
        } catch (Exception e) {
            correctCall = false;
        }

        try {
            incorrectCall = phoneValidatorService.isCorrectNumber(incorrectPhone, "(212) 698054317");
        } catch (Exception e) {
            incorrectCall = false;
        }

        // Then
        assertThat(correctCall).isTrue();
        assertThat(incorrectCall).isFalse();
    }
}
