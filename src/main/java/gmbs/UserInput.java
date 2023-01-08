package gmbs;

import java.util.*;

public class UserInput {
    private static final String REPLAY_VALUE = "1";
    private static final String QUIT_VALUE = "2";
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

    public boolean hasNoOverlap(String input) {
        Set<String> tempSet = new HashSet<>(Arrays.asList(input.split("")));
        return tempSet.size() == input.length();
    }

    public boolean isValidNumberInput(String input, int length) {
        return isNaturalNumber(input) && isValidLength(input, length) && hasNoOverlap(input);
    }

    private String getInput() {
        return scan.nextLine();
    }

    public List<Integer> getNumbers() {
        ArrayList<Integer> returnNumbers = new ArrayList<>();
        String tempStringInput = getInput();
        while (!isValidNumberInput(tempStringInput, Constant.inputLength)) {
            Display.showWrongInputDisplay();
            tempStringInput = getInput();
        }
        String[] temp = tempStringInput.split("");
        for (int i = 0; i < Constant.inputLength; i++) {
            returnNumbers.add(Integer.parseInt(temp[i]));
        }
        return returnNumbers;
    }

    public boolean isNeither(Object a, Object b, Object input) {
        return !(input.equals(a) || input.equals(b));
    }

    public boolean checkReplay() {
        String userInput = getInput();
        while (isNeither(REPLAY_VALUE, QUIT_VALUE, userInput)) {
            Display.showWrongInputDisplay();
            userInput = getInput();
        }
        return userInput.equals(REPLAY_VALUE);
    }
}
