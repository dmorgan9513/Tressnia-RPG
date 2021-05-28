package main;

import java.util.Scanner;

public class Center extends Location{

    private String username;
    private boolean error;
    private boolean talkedWithAmy = false;
    private boolean observed = false;

    public void center() {
        CenterDialogue center = new CenterDialogue();

        delay(center.centerAme("Hello"));
        Scanner input = new Scanner(System.in);
        this.username = input.nextLine();

        delay("Welcome " + username + ".\n" + center.centerAme(".."));
        delay(center.centerPlayer("observe/ame"));

        while(!talkedWithAmy || !observed) {
            String userInput = input.nextLine();
            if (userInput.equals("observe")) {
                delay(center.centerPlayer("observeChoice"));
                observed = true;
                if(!talkedWithAmy) {
                    halt(3);
                    delay(center.centerPlayer("observe/ame"));
                }
            } else if (userInput.equals("ame")) {
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
        halt(8);
        delay(center.centerAme("stones"));
        halt(3);
        delay(center.centerPlayer("stoneChoice"));
    }
}
