package gmbs;
import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;
import java.util.Arrays;

public class UserInput {
    private static final String YES_VALUE = "1";
    private static final String NO_VALUE = "2";
    private static final int inputLength = Constant.inputLength;
    public boolean isInt(String input) {
        try {
            Integer.parseInt(input);
        } catch(Exception e) {
            return false;
        }
        return true;
    }

    public boolean isValidLength(String input, int length) {
        return input.length()==length;
    }

    public boolean isNoOverlap(String input) {
        Set<String> tempSet = new HashSet<>(Arrays.asList(input.split("")));
        return tempSet.size() == input.length();
    }

    public boolean isValidNumberInput(String input, int length) {
        return isInt(input) && isValidLength(input,length) && isNoOverlap(input);
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

    private String getStringInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }

    public int getNumber() {
        Display.numberInputDisplay(inputLength);
        String tempStringInput = getStringInput();
        while(!isValidNumberInput(tempStringInput,inputLength)) {
            Display.wrongInputDisplay();
            tempStringInput = getStringInput();
        }
        return Integer.parseInt(tempStringInput);
    }


    public boolean getYesNo() {
        Display.playAgainDisplay(YES_VALUE, NO_VALUE);
        String userInput = getStringInput();
        while (isWrongInput(userInput)) {
            Display.wrongInputDisplay();
            userInput = getStringInput();
        }
        return isYes(userInput);
    }

}
