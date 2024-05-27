package org.example.java240410;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
@AllArgsConstructor
@Getter
@Setter
public class Address {
 private Country country;
 private String street;
 private String numberHouse;
 private int numberFlat;

 @Override
 public String toString() {
  return "Address{" +
          "country=" + country +
          ", street='" + street + '\'' +
          ", numberHouse=" + numberHouse +
          ", numberFlat=" + numberFlat +
          '}';
 }
}
