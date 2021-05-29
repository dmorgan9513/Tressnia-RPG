package chapter1;

import main.Location;
import main.Locationable;

public class Ch1Left extends Location {

    public void run() {
        System.out.println("test2");
    }

    @Override
    public Locationable getLocation() {
        return null;
    }
}
