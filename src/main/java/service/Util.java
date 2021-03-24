package service;

public class Util {
    public static double getValidSide(String line) {
        double side = getDouble(line);
        if (side > 0) {
            return side;
        } else {
            throw new IllegalArgumentException(StringConsts.MORE_THAN_ZERO);
        }
    }
    public static double getDouble(String line) {
        double side;
        try {
            side = Double.parseDouble(line);
        } catch (NumberFormatException e) {
            throw new NumberFormatException(StringConsts.WRONG_NUMBER_FORMAT);
        }
        return side;
    }
}
