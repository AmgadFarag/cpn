package com.amgadFarag.cpn.mappers;

import org.mapstruct.Mapper;

import com.amgadFarag.cpn.entities.Customer;
import com.amgadFarag.cpn.dtos.CustomerDTO;
import org.mapstruct.factory.Mappers;

/***
 * A Custom Mapper for Entity to DTO & DTO to Entity mappings
 * */
@Mapper(componentModel = "spring", uses = {})
public interface CustomerMapper extends EntityMapper<CustomerDTO, Customer> {
    CustomerMapper instance = Mappers.getMapper( CustomerMapper.class );
}
