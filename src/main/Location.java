package main;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public abstract class Location implements Locationable{

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
}
