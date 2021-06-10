package chapter1;

import main.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Center extends Location implements Locationable {

    private String username;
    private boolean error = true;
    private boolean talkedWithAmy = false;
    private boolean observed = false;
    private Locationable nextLocation;
    private final Map<String, String> dialogue = readDialogueFile(new File("src/chapter1/CenterDialogue.txt"));

    @Override
    public Locationable getLocation() {
        return nextLocation;
    }

    public String getUsername() {
        return username;
    }

    public void run() {

        delay(dialogue.get("A1"));
        Scanner input = new Scanner(System.in);
        this.username = input.nextLine();

        delay("Welcome " + username + ".\n" + dialogue.get("A2"));
        halt(1);
        delay(dialogue.get("G1"));
        delay(dialogue.get("G2"));

        while(!talkedWithAmy || !observed) {
            String userInput = input.nextLine();
            if (userInput.equalsIgnoreCase("observe")) {
                delay(dialogue.get("G3"));
                observed = true;
                if(!talkedWithAmy) {
                    halt(3);
                    delay(dialogue.get("G2"));
                }
            } else if (userInput.equalsIgnoreCase("ame")) {
                if(talkedWithAmy) {
                    delay(dialogue.get("A5"));
                } else {
                    delay(dialogue.get("A3"));
                    halt(2);
                    talkedWithAmy = true;
                }
                if(!observed) {
                    delay(dialogue.get("G2"));
                }
            } else {
                delay(dialogue.get("E1"));
            }
        }
        halt(2);
        delay(dialogue.get("A4"));
        halt(2);

        while(error) {
            delay(dialogue.get("G4"));
            String nextInput = input.nextLine();
            if(nextInput.equalsIgnoreCase("left")) {
                Ch1Left left = new Ch1Left();
                nextLocation = left;
                error = false;
            } else if(nextInput.equalsIgnoreCase("right")) {
                Ch1Right right = new Ch1Right();
                nextLocation = right;
                error = false;
            } else if(nextInput.equalsIgnoreCase("behind")) {
                Ch1Behind behind = new Ch1Behind();
                nextLocation = behind;
                error = false;
            }
        }
    }
}
