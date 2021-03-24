package service;

public interface StringConsts {
    String FIRST_MESSAGE = "Let's check if envelopes fit one into another.";
    String ENTER_SIDE = "Enter side";
    String IS_FITTED = "Yes! It is possible to fit one envelope into another.";
    String IS_NOT_FITTED = "No! It is impossible to fit one envelope into another.";
    String LIKE_TO_CONTINUE = "Would you like to continue?" + "(" + StringConsts.Y + "/" + StringConsts.YES + ")";
    String WRONG_NUMBER_FORMAT = "Wrong number format.";
    String MORE_THAN_ZERO = "Height and width should be more than 0.";
    String Y = "y";
    String YES = "yes";
    String BYE = "Bye-bye!";

    String[] SIDE_NAMES = {"'a' of the first envelope", "'b' of the first envelope",
            "'a' of the second envelope", "'b' of the second envelope"};
}

