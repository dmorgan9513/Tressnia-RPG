package chapter1;

import main.Location;
import main.Locationable;
import main.Main;

import java.io.File;
import java.util.Map;
import java.util.Scanner;

public class Ch1Left extends Location {
    private final Map<String, String> dialogue = mapFile(setFilePath("LeftDialogue.txt"));
    private boolean readyToStart = false;


    public void run() {
        delay(dialogue.get("G1"));
        while (!readyToStart) {
            delay(dialogue.get("G2"));
            Scanner input = new Scanner(System.in);
            if(input.nextLine().equals("1")) {
                delay(dialogue.get("W1"));
            } else if(input.nextLine().equals("2")) {
                delay(dialogue.get("W2"));
                readyToStart = true;
            }
        }
        next();



    }

    @Override
    public Locationable getLocation() {
        return null;
    }
}
