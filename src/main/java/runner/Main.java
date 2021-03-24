package runner;


import service.messenger.ConsoleMessenger;

/**
 * This program  determines if an envelope can be nested
 * inside the other one.The program asks user for
 * envelopes' sides one parameter at a time. After each calculation,
 * the program asks the user if he/she wants to continue.
 * If the user answers “y” or “yes” (case insensitive),
 * the program continues from the beginning, otherwise it exits.
 */

public class Main {
    public static void main(String[] args) {
        Application app=new Application(new ConsoleMessenger());
        app.run();
    }
}
