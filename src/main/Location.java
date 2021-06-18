package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.*;

public abstract class Location implements Locationable{

    List<String> options = new ArrayList<>(Arrays.asList("Options", "Quit"));

    public void delay (String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '@') {
                System.out.println("");
            } else {
                System.out.print(s.charAt(i));
            }
            try {
                Thread.sleep(15);
            } catch(InterruptedException ie) {
                System.err.println("InterruptedException has occurred");
            }
        }
    }

    public void halt(int multiplier) {
        try {
            Thread.sleep(1000 * multiplier);
        } catch(InterruptedException ie) {
            System.err.println("InterruptedException has occurred");
        }
    }

    public void next() {
        String continuePrompt = "Press Enter to continue or type \"Options\" to see current options. ";
        delay(continuePrompt);
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while(!input.equals("")) {
            if (input.equalsIgnoreCase("options") || input.equalsIgnoreCase("quit")) {
                delay(getAltOptions(input));

            }
            next();
        }
    }

    public static Map<String, String> readDialogueFile(File filePath) {
        Map<String, String> dialogueMap = new HashMap<>();
        try {
            Scanner fileReader = new Scanner(filePath);
            while(fileReader.hasNextLine()) {
                String[] nextLine = fileReader.nextLine().split("\\|");
                dialogueMap.put(nextLine[0], nextLine[1]);
            }
            return dialogueMap;
        } catch(FileNotFoundException e) {
            System.out.println("Dialogue file not found");
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public String getAltOptions(String input) {
        if(input.equalsIgnoreCase("quit")) {
            System.out.println("Thanks for playing!");
            System.exit(1);
        } else if(input.equalsIgnoreCase("options")) {
            String optionList = "";
            for(String option : options) {
                optionList += option + " ";
            }
            return "Your current options are: " + optionList + "@";
        }
        return "Error: Invalid Input, type \"menu\" to try again";
    }

    public void addOption(String newOption) {
        if(!options.contains(newOption)) {
            options.add(newOption);
        }
    }
}
