package com.ndxs.boot;

import com.ndxs.boot.model.Address;
import com.ndxs.boot.model.Country;
import com.ndxs.boot.model.User;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.Optional;

/**
 * @description:  看下map和flatMap的区别
 * @author: waguju
 * @time: 2021.6.29 17:53
 */

@Slf4j
public class TestOptional {

    @Test
    public void  testMap(){
        Country country = new Country();
        country.setIsoCode("123456");
        Address address = new Address();
        address.setCountry(country);
        User user = new User();
        user.setAddress(address);
        String isoCode = Optional.ofNullable(user)
                .map(e -> e.getAddress())
                .map(e -> e.getCountry())
                .map(e -> e.getIsoCode())
                .map(e -> e.toUpperCase())
                .orElse("");
        log.info("isoCode={}", isoCode);
    }

    @Test
    public void  testFlatMap(){
        Country country = new Country();
        country.setIsoCode("123456");
        Address address = new Address();
        address.setCountry(country);
        User user = new User();
        user.setAddress(address);
        String isoCode = Optional.ofNullable(user)
                .flatMap(e -> e.getAddress1())
                .flatMap(e -> e.getCountry1())
                .map(e -> e.getIsoCode())
                .map(e -> e.toUpperCase())
                .orElse("");
        log.info("isoCode={}", isoCode);
    }

}
