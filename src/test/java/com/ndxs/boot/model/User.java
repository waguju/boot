package com.ndxs.boot.model;

import lombok.Data;

import java.util.Optional;

/**
 * @description:
 * @author: waguju
 * @time: 2021.6.29 17:54
 */
@Data
public class User {
    private Address address;

    public Optional<Address> getAddress1() {
        return Optional.ofNullable(address);
    }
}
