package gmbs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class InputValidator {
    public boolean isNeither(Object a, Object b, Object input) {
        return !(input.equals(a) || input.equals(b));
    }

    public boolean isNaturalNumber(String input) {
        try {
            if (Integer.parseInt(input) > 0) {
                return true;
            }
        } catch (Exception e) {
            return false;
        }
        return false;
    }

    public boolean isValidLength(String input, int length) {
        return input.length() == length;
    }

    public boolean hasNoOverlap(String input) {
        Set<String> inputChecker = new HashSet<>(Arrays.asList(input.split("")));
        return inputChecker.size() == input.length();
    }

    public boolean isValidNumberInput(String input, int length) {
        return isNaturalNumber(input) && isValidLength(input, length) && hasNoOverlap(input);
    }
}
