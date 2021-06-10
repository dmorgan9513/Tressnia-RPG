package chapter1;

import main.Location;
import main.Locationable;
import main.Main;

import java.io.File;
import java.util.Map;

public class Ch1Left extends Location {
    private final Map<String, String> dialogue = readDialogueFile(new File("src/chapter1/LeftDialogue.txt"));

    public void run() {
        System.out.println(Main.center.getUsername());



    }

    @Override
    public Locationable getLocation() {
        return null;
    }
}
