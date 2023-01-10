package gmbs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    private boolean isNeither(Object a, Object b, Object input) {
        return !(input.equals(a) || input.equals(b));
    }

    private boolean isNaturalNumber(String input) {
        try {
            if (Integer.parseInt(input) > 0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    private boolean isValidLength(String input, int length) {
        return input.length() == length;
    }

    private boolean hasNoOverlap(String input) {
        Set<String> inputChecker = new HashSet<>(Arrays.asList(input.split("")));
        return inputChecker.size() == input.length();
    }

    private boolean hasNoZero(String input) {
        return !input.contains("0");
    }

    public boolean isValidNumberInput(String input, int length) {
        return isNaturalNumber(input) && isValidLength(input, length) && hasNoOverlap(input) && hasNoZero(input);
    }
}
