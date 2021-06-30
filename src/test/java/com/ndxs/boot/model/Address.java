package com.ndxs.boot.model;

import lombok.Data;

import java.util.Optional;

/**
 * @description:
 * @author: waguju
 * @time: 2021.6.29 17:55
 */
@Data
public class Address {
    private Country country;

    //自己封装get方法，用于flatMap
    public Optional<Country> getCountry1() {
        return Optional.ofNullable(country);
    }
}
