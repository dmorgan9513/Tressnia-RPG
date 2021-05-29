package chapter1;

import main.*;

import java.util.Scanner;

public class Center extends Location implements Locationable {

    private String username;
    private boolean error = true;
    private boolean talkedWithAmy = false;
    private boolean observed = false;
    private Locationable nextLocation;

    @Override
    public Locationable getLocation() {
        return nextLocation;
    }

    public void run() {
        CenterDialogue center = new CenterDialogue();

        delay(center.centerAme("Hello"));
        Scanner input = new Scanner(System.in);
        this.username = input.nextLine();

        delay("Welcome " + username + ".\n" + center.centerAme(".."));
        delay(center.centerPlayer("observe/ame"));

        while(!talkedWithAmy || !observed) {
            String userInput = input.nextLine();
            if (userInput.equalsIgnoreCase("observe")) {
                delay(center.centerPlayer("observeChoice"));
                observed = true;
                if(!talkedWithAmy) {
                    halt(3);
                    delay(center.centerPlayer("observe/ame"));
                }
            } else if (userInput.equalsIgnoreCase("ame")) {
                delay(center.centerAme("Welcome"));
                halt(3);
                talkedWithAmy = true;
                if(!observed) {
                    delay(center.centerPlayer("observe/ame"));
                }
            } else {
                delay(center.centerError("error"));
            }
        }
        halt(3);
        delay(center.centerAme("stones"));
        halt(2);
        delay(center.centerPlayer("stoneChoice"));

        while(error) {
            if(input.nextLine().equalsIgnoreCase("left")) {
                Ch1Left left = new Ch1Left();
                nextLocation = left;
                error = false;
            } else if(input.nextLine().equalsIgnoreCase("right")) {
                Ch1Right right = new Ch1Right();
                nextLocation = right;
                error = false;
            } else if(input.nextLine().equalsIgnoreCase("behind")) {
                Ch1Behind behind = new Ch1Behind();
                nextLocation = behind;
                error = false;
            } else {
                delay(center.centerPlayer("stoneChoice"));
            }
        }
    }
}
