package main;

import chapter1.Center;

import java.lang.*;

public class Main{
    public static Center center = new Center();

    public static void main(String[] args) {


        center.run();

        Locationable temp = center.getLocation();
        temp.run();


    }
}
