package chapter1;

import java.util.HashMap;
import java.util.Map;

public class CenterDialogue {

    private Map <String, String> centerAme = new HashMap<>();
    private Map <String, String> centerPlayer = new HashMap<>();
    private Map <String, String> centerError = new HashMap<>();

    public String centerAme(String key) {
        centerAme.put("Hello","Hello there - you've taken quite a fall. What's your name?\n");
        centerAme.put("..",".....Chapter 1: Desolation.....\nAME: My name is Ameliora, but you can call me Ame.");
        centerAme.put("Welcome", "AME: Welcome to Tressnia.  This is an amazing place full of beauty and adventure, even if you can't tell right now.\n" +
                "I know this is all a little confusing, but as you progress, it will start to become clear, and I'll be here to help you find your way.\n");
        centerAme.put("stones", "\nAME: You may have noticed a few circles of stones surrounding you.  These are your first challenges.\n" +
                "These challenges will test your mind and ability to solve puzzles.  Step into one of the circles to begin.\n");

        return centerAme.get(key);
    }

    public String centerPlayer(String key) {
        centerPlayer.put("observe/ame","\n--What would you like to do? (type \"observe\" to look around or \"ame\" to talk with Ame) \n");
        centerPlayer.put("observeChoice","** You observe your surroundings. It's dark as if the sun has just set.  The air is cool with a light breeze.\n " +
                "In front of you is Ame and to each side and behind you are stones shaped together in perfect circles.\n" +
                " There's a feeling of emptiness as you look past them into the distance. You wonder how you got here. **\n");
        centerPlayer.put("stoneChoice","\n--What would you like to do? (type \"left\", \"right\", or \"behind\" to step into one of the circles)\n");

        return centerPlayer.get(key);
    }

    public String centerError(String key) {
        centerError.put("error", "Invalid input - please type observe or ame.\n");

        return centerError.get(key);
    }
}
