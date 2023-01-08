package gmbs;

import java.util.*;

public class UserInput {
    private static final String YES_VALUE = "1";
    private static final String NO_VALUE = "2";
    private final Scanner scan = new Scanner(System.in);


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

    public boolean isNoOverlap(String input) {
        Set<String> tempSet = new HashSet<>(Arrays.asList(input.split("")));
        return tempSet.size() == input.length();
    }

    public boolean isValidNumberInput(String input, int length) {
        return isNaturalNumber(input) && isValidLength(input, length) && isNoOverlap(input);
    }

    public boolean isYes(String input) {
        return input.equals(YES_VALUE);
    }

    public boolean isNo(String input) {
        return input.equals(NO_VALUE);
    }

    public boolean isWrongInput(String input) {
        return !isYes(input) && !isNo(input);
    }

    private String getInput() {
        return scan.nextLine();
    }

    public List<Integer> getNumbers() {
        ArrayList<Integer> returnNumbers = new ArrayList<>();
        String tempStringInput = getInput();
        while (!isValidNumberInput(tempStringInput, Constant.inputLength)) {
            Display.wrongInputDisplay();
            tempStringInput = getInput();
        }
        String[] temp = tempStringInput.split("");
        for (int i = 0; i < Constant.inputLength; i++) {
            returnNumbers.add(Integer.parseInt(temp[i]));
        }
        return returnNumbers;
    }


    public boolean getYesNo() {
        Display.playAgainDisplay(YES_VALUE, NO_VALUE);
        String userInput = getInput();
        while (isWrongInput(userInput)) {
            Display.wrongInputDisplay();
            userInput = getInput();
        }
        return isYes(userInput);
    }

}
