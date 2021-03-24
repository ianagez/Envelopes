package runner;

import model.Envelope;
import service.PostalWorker;
import service.StringConsts;
import service.Util;
import service.messenger.Messenger;

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
        PostalWorker postalWorker = new PostalWorker();
        return postalWorker.putOneIntoAnother
                (new Envelope(sides[0], sides[1]), new Envelope(sides[2], sides[3]));
    }

    private boolean runOneMoreTime() {
        messenger.sendMessage(StringConsts.LIKE_TO_CONTINUE);
        String answer = messenger.getMessage();
        return answer.equalsIgnoreCase(StringConsts.Y)
                || answer.equalsIgnoreCase(StringConsts.YES);
    }
}
