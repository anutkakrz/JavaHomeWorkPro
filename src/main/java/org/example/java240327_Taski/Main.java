package org.example.java240327_Taski;

public class Main {
    public static void main(String[] args) {

       Transport[] transports = new Transport[2];
       transports[0]= new Auto("BMW",150,"disel");
       transports[1]= new Bicycle("HappyBike",50, "City");
       for (Transport x : transports) {
           System.out.println(x);
       }



    }


}
