package gmbs;
import java.util.Scanner;

public class UserInput {
    private static final String YES = "1";
    private static final String NO = "2";
    public boolean isInt(String input) {
        try {
            Integer.parseInt(input);
        } catch(Exception e) {
            return false;
        }
        return true;
    }

//    private boolean isYes(String input) {
//        return input.equals(YES);
//    }
//
//    private boolean isNo(String input) {
//        return input.equals(NO);
//    }

    public boolean isValidLength(String input, int length) {
        return input.length()==length;
    }

    public boolean isValidNumberInput(String input, int length) {
        return isInt(input) && isValidLength(input,length);
    }

    private void numberInputDisplay() {
        System.out.println(Constant.DIGIT_NUMBER_LENGTH + "자리 정수 입력");
    }

    private void playAgainDisplay() {
        System.out.println("다시하려면 1 종료하려면 2를 입력");
    }
    private String getStringInput() {
        Scanner scan = new Scanner(System.in);
        return scan.nextLine();
    }
    public int getNumberInput() {
        numberInputDisplay();
        String tempStringInput = getStringInput();
        while(!isValidNumberInput(tempStringInput,Constant.DIGIT_NUMBER_LENGTH)) {
            numberInputDisplay();
            tempStringInput = getStringInput();
        }
        return Integer.parseInt(tempStringInput);
    }

    public boolean isPlayAgain() {
        playAgainDisplay();
        String tempString = getStringInput();
        while (!(tempString.equals(YES) || tempString.equals(NO))) {
            playAgainDisplay();
            tempString = getStringInput();
        }
        return tempString.equals(YES);
    }

}
