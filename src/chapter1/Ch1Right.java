package chapter1;

import main.Location;
import main.Locationable;

public class Ch1Right extends Location {

    public void run() {
        System.out.println("test3");
    }

    @Override
    public Locationable getLocation() {
        return null;
    }
}
