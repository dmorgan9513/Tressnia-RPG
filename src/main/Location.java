package main;

public abstract class Location implements Locationable{

    public void delay (String s) {
        for (int i = 0; i < s.length(); i++) {
            System.out.print(s.charAt(i));
            try {
                Thread.sleep(1);
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
}
