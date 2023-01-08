package gmbs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    private static final String REPLAY_VALUE = "1";
    private static final String QUIT_VALUE = "2";
    private final Scanner scan = new Scanner(System.in);
    private final InputValidator validator = new InputValidator();



    private String getInput() {
        return scan.nextLine();
    }

    public List<Integer> getNumbers() {
        ArrayList<Integer> returnNumbers = new ArrayList<>();
        String tempStringInput = getInput();
        while (!validator.isValidNumberInput(tempStringInput, Constant.inputLength)) {
            Display.showWrongInputDisplay();
            tempStringInput = getInput();
        }
        String[] temp = tempStringInput.split("");
        for (int i = 0; i < Constant.inputLength; i++) {
            returnNumbers.add(Integer.parseInt(temp[i]));
        }
        return returnNumbers;
    }

    public boolean checkReplay() {
        Display.showPlayAgain(REPLAY_VALUE, QUIT_VALUE);
        String userInput = getInput();
        while (validator.isNeither(REPLAY_VALUE, QUIT_VALUE, userInput)) {
            Display.showWrongInputDisplay();
            userInput = getInput();
        }
        return userInput.equals(REPLAY_VALUE);
    }
}
