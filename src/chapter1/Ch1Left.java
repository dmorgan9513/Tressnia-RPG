package chapter1;

import main.Location;
import main.Locationable;
import main.Main;

import java.io.File;
import java.util.*;

public class Ch1Left extends Location {
    private final Map<String, String> dialogue = mapFile(setFilePath("LeftDialogue.txt"));
    private final Map<String, String> anagrams = mapFile(setFilePath("LeftAnagrams.txt"));
    private boolean readyToStart = false;


    public void run() {
        delay(dialogue.get("G1"));
        while (!readyToStart) {
            delay(dialogue.get("G2"));
            Scanner scanner = new Scanner(System.in);
            String input = scanner.nextLine();
            if(input.equals("1")) {
                delay(dialogue.get("W1"));
            } else if(input.equals("2")) {
                delay(dialogue.get("W2"));
                readyToStart = true;
            }
            //options not working right
        }
        next();
        int correctAnswers = 0;
        Set<String> anagram = anagrams.keySet();
        List<String> anagramKeys = new ArrayList<>();
        for(String singleAnagram : anagram) {
            anagramKeys.add(singleAnagram);
        }
        while(correctAnswers < 3 && !anagramKeys.isEmpty()) {
            Collections.shuffle(anagramKeys);
            String unsolvedAnagram = anagramKeys.get(0);
            int guesses = 0;
            boolean correctGuess = false;
            while(guesses < 3 && !correctGuess) {
                delay("\nYour anagram to unscramble is " + unsolvedAnagram + ".\n");
                delay("Solution: ");
                Scanner scanner = new Scanner(System.in);
                String guess = scanner.nextLine();
                if(guess.equalsIgnoreCase(anagrams.get(anagramKeys.get(0)))) {
                    correctGuess = true;
                    correctAnswers++;
                    anagramKeys.remove(0);
                    delay("Your guess was correct! You have successfully solved " + correctAnswers + " anagram(s)!\n\n");
                } else {
                    guesses++;
                    delay("Your guess was incorrect. You have " + (3 - guesses) + " remaining!\n");
                    if(3 - guesses == 0) {
                        delay("\nYou are out of guesses! The correct answer was " + anagrams.get(anagramKeys.get(0)) + ".\nYou'll now be given a new anagram to solve.\n");
                        anagramKeys.remove(anagramKeys.get(0));
                    }
                }
            }
        }
        if(anagramKeys.isEmpty()) {
            delay(dialogue.get("G3"));
            addOption("Inventory");
            addItem("Badge of Knowledge");
        } else {
            delay(dialogue.get("G4"));
            addOption("Inventory");
            addItem("Badge of Knowledge");
        }

    }

    @Override
    public Locationable getLocation() {
        return null;
    }
}
