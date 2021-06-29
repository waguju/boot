package com.ndxs.boot;

import com.ndxs.boot.model.User;

import java.util.Optional;

/**
 * @description:
 * @author: waguju
 * @time: 2021.6.29 17:53
 */
public class TestOptional {

    public String  testMap(){
        User user = new User();
        String isoCode = Optional.ofNullable(user)
                .map(e -> e.getAddress())
                .map(e -> e.getCountry())
                .map(e -> e.getIsoCode())
                .map(e -> e.toUpperCase())
                .orElse("");
        return isoCode;
    }

    public String  testFlatMap(){
        User user = new User();
        String isoCode = Optional.ofNullable(user)
                .flatMap(e -> e.getAddress())
                .flatMap(e -> e.getCountry())
                .flatMap(e -> e.getIsoCode())
                .map(e -> e.toUpperCase())
                .orElse("");
        return isoCode;
    }

}
