package chapter1;

import main.Location;
import main.Locationable;

public class Ch1Behind extends Location {

    public void run() {
        System.out.println("test1");
    }

    @Override
    public Locationable getLocation() {
        return null;
    }
}
