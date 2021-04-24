package model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    private String name;
    private int age;
    private Address address;

    @Getter
    @Setter
    @AllArgsConstructor
    @NoArgsConstructor
    public static class Address {
        private String street;
        private String city;
        private String zip;
    }
}
