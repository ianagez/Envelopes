package service;

import model.Envelope;

public class PostalWorker {

    public boolean putOneIntoAnother(Envelope envFirst, Envelope envSecond) {
        Envelope smaller = envFirst.getArea() < envSecond.getArea() ? envFirst : envSecond;
        Envelope bigger = envFirst.getArea() > envSecond.getArea() ? envFirst : envSecond;
        return putFirstIntoSecond(smaller, bigger);
    }

    public boolean putFirstIntoSecond(Envelope envFirst, Envelope envSecond) {
        if (envFirst.getShortSide() < envSecond.getShortSide() && envFirst.getLongSide() < envSecond.getLongSide())
            return true;
        return isFittedByDiagonalPlacement(envFirst, envSecond);
    }

    private  boolean isFittedByDiagonalPlacement(Envelope smaller, Envelope bigger) {
        double biggerDiagonal = Math.sqrt(Math.pow(bigger.getLongSide(), 2) + Math.pow(bigger.getShortSide(), 2));
        return smaller.getLongSide() + smaller.getShortSide() <= biggerDiagonal;
    }
}
