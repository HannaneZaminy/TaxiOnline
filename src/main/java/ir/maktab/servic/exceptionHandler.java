package ir.maktab.servic;

import ir.maktab.servic.exception.InvalidChoiceException;

public class exceptionHandler {

    public static boolean validChoice(int choice) throws InvalidChoiceException {

        if (choice >= 1 && choice <= 9) {
            return true;
        }
        throw new InvalidChoiceException("Your choice is invalid. Please try again.");
    }
}
