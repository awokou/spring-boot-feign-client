package com.server.api.feign.client.dto.requests;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateUserRequestDto implements Serializable {
    private String email;
    private String username;
    private String password;
    private Name name;
    private Address address;
    private String phone;

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Name implements Serializable {
        private String firstname;
        private String lastname;
    }

    @Data
    @NoArgsConstructor
    @AllArgsConstructor
    public static class Address implements Serializable {
        private String city;
        private String street;
        private Integer number;
        private String zipcode;
        private Geolocation geolocation;

        @Data
        @NoArgsConstructor
        @AllArgsConstructor
        public static class Geolocation implements Serializable {
            private String lat;
            private String lon; // Changed from `long` to `lon` to avoid confusion with Java's long data type
        }
    }
}
