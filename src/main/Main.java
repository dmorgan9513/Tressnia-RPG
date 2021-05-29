package main;

import chapter1.Center;

import java.lang.*;

public class Main{
    public static void main(String[] args) {

        Center center = new Center();
        center.run();

        Locationable temp = center.getLocation();
        temp.run();


    }
}
