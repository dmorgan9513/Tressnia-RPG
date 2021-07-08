package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public abstract class Location implements Locationable{

    List<String> options = new ArrayList<>(Arrays.asList("Options", "Quit"));
    List<String> inventory;

    public void delay(String s) {
        for (int i = 0; i < s.length(); i++) {
            if(s.charAt(i) == '@') {
                System.out.println("");
            } else {
                System.out.print(s.charAt(i));
            }
            try {
                Thread.sleep(0);
            } catch(InterruptedException ie) {
                System.err.println("InterruptedException has occurred");
            }
        }
    }

    public void halt(int multiplier) {
        try {
            Thread.sleep(1 * multiplier);
        } catch(InterruptedException ie) {
            System.err.println("InterruptedException has occurred");
        }
    }

    public void next() {
        Scanner scanner = new Scanner(System.in);
        String continuePrompt = "Press Enter to continue or type \"Options\" to see current options. ";
        delay(continuePrompt);
        String input = scanner.nextLine();
        while(!input.equals("")) {
            for(String option : options) {
                if (input.equalsIgnoreCase(option)) {
                    delay(getAltOptions(option));
                }
            }
            delay(continuePrompt);
            input = scanner.nextLine();
        }
    }

    public static File setFilePath(String filepath) {
        if(Files.exists(Paths.get(filepath))) {
            return new File(filepath);
        } else {
            filepath = "resources/" + filepath;
            return new File(filepath);
        }
    }

    public static Map<String, String> mapFile(File filePath) {
        Map<String, String> dialogueMap = new HashMap<>();
        try {
            Scanner fileReader = new Scanner(filePath);
            while(fileReader.hasNextLine()) {
                String[] nextLine = fileReader.nextLine().split("\\|");
                dialogueMap.put(nextLine[0], nextLine[1]);
            }
            return dialogueMap;
        } catch(FileNotFoundException e) {
            System.out.println("File not found");
            e.printStackTrace();
            System.exit(1);
        }
        return null;
    }

    public String getAltOptions(String input) {
        if(input.equals("quit")) {
            System.out.println("Thanks for playing!");
            System.exit(1);
        } else if(input.equals("options")) {
            String optionList = "";
            for(String option : options) {
                optionList += option + " ";
            }
            return "Your current options are: " + optionList + "@";
        } else if(input.equals("inventory")) {
            String inventoryList = "";
            for(String item : inventory) {
                inventoryList += item + " ";
            }
            return "Your inventory contains: " + inventoryList + "@";
        }
        //create inventory and allow for items to be added
        return "Error: Invalid Input, type \"menu\" to try again";
    }

    public void addOption(String newOption) {
        if(!options.contains(newOption)) {
            options.add(newOption);
            if(newOption.equals("inventory")) {
                inventory = new ArrayList<>();
            }
        }
    }

    public void addItem(String newItem) {
        inventory.add(newItem);
    }
}

//Make function to print and wait for input for combat --while(!input.nextLine) print .
