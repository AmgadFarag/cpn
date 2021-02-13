package com.amgadFarag.cpn.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CustomerDTO {
    private int id;
    private String name;
    private String phone;

    private String country;
    private String countryCode;
    private boolean valid;

    @Override
    public String toString() {
        return "{" +
                "\"id\":\"" + id + "\"," +
                "\"name\":\"" + name + "\"," +
                "\"phone\":\"" + phone + "\"," +
                "\"country\":\"" + country + "\"," +
                "\"countryCode\":\"" + countryCode + "\"," +
                "\"valid\":" + valid +
                "}";
    }

}
