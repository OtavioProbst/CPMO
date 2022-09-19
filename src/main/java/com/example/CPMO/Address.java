package com.example.CPMO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Embeddable;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Embeddable // JPA -> will be embeddable by other entities
public class Address {

    private String street;
    private String city;
    private String state;
    private String zip;
}
