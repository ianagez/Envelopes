package runner;

import model.Envelope;
import model.PostMan;
import service.StringConsts;
import service.Util;
import service.messenger.Messenger;

/**
 * This program  determines if one envelope can be nested
 * inside the other.The program asks the user for
 * envelopes' sides one parameter at a time. After each calculation,
 * the program asks the user if he wants to continue.
 * If the user answers “y” or “yes” (case insensitive),
 * the program continues from the beginning, otherwise it exits.
 */

public class Application  {
    private final Messenger messenger;

    public Application(Messenger messenger){
        this.messenger=messenger;
    }

    public void run() {
        do {
            messenger.sendMessage(StringConsts.FIRST_MESSAGE);
            if (isFittedIn(getAllSides())) {
                messenger.sendMessage(StringConsts.IS_FITTED);
            } else {
                messenger.sendMessage(StringConsts.IS_NOT_FITTED);
            }
        } while (runOneMoreTime());
        messenger.sendMessage(StringConsts.BYE);
    }

    private double[] getAllSides() {
        String[] sideNames = StringConsts.SIDE_NAMES;
        double[] sides = new double[sideNames.length];
        for (int i = 0; i < sideNames.length; i++) {
            sides[i] = getOneSide(sideNames[i]);
        }
        return sides;
    }

    private double getOneSide(String sideName) {
        double side = 0;
        while (side <= 0) {
            messenger.sendMessage(StringConsts.ENTER_SIDE + " " + sideName + ".");
            try {
                side = Util.getValidSide(messenger.getMessage());
            } catch (RuntimeException e) {
                messenger.sendMessage(e.getMessage());
            }
        }
        return side;
    }

    private boolean isFittedIn(double[] sides) {
        PostMan postMan = new PostMan();
        return postMan.putOneIntoAnother
                (new Envelope(sides[0], sides[1]), new Envelope(sides[2], sides[3]));
    }

    private boolean runOneMoreTime() {
        messenger.sendMessage(StringConsts.LIKE_TO_CONTINUE);
        String answer = messenger.getMessage();
        return answer.equalsIgnoreCase(StringConsts.Y)
                || answer.equalsIgnoreCase(StringConsts.YES);
    }
}
