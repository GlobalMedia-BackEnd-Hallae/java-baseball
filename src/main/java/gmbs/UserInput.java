package gmbs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UserInput {
    private static final String REPLAY_VALUE = "1";
    private static final String QUIT_VALUE = "2";
    private final Scanner scan = new Scanner(System.in);
    private final InputValidator validator = new InputValidator();
    private final Display display = new Display();

    private String getInput() {
        return scan.nextLine();
    }

    public List<Integer> getNumbers() {
        ArrayList<Integer> returnNumbers = new ArrayList<>();
        display.showNumberInputDisplay(Constant.INPUT_LENGTH);
        String userInput = getInput();
        while (!validator.isValidNumberInput(userInput, Constant.INPUT_LENGTH)) {
            display.showWrongInputDisplay();
            userInput = getInput();
        }
        String[] temp = userInput.split("");
        for (int i = 0; i < Constant.INPUT_LENGTH; i++) {
            returnNumbers.add(Integer.parseInt(temp[i]));
        }
        return returnNumbers;
    }

    public boolean checkReplay() {
        display.showPlayAgain(REPLAY_VALUE, QUIT_VALUE);
        String userInput = getInput();
        while (validator.isNeither(REPLAY_VALUE, QUIT_VALUE, userInput)) {
            display.showWrongInputDisplay();
            userInput = getInput();
        }
        return userInput.equals(REPLAY_VALUE);
    }
}
