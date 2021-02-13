package com.amgadFarag.cpn.dtos;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class FilterDTO {
    // Empty and Null deactivate the filter
    private String byCountry;
    private Boolean byValidity;
    private String byCountryCode;
    private String byNumber;

}
