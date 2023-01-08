package gmbs.view.input;

import gmbs.common.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputConsoleImpl implements InputConsole {

    private static final String BLANK = " ";
    private static final long MAX_INPUT_COUNT = 3;

    private final Scanner scanner;
    private String[] inputNumber;

    public InputConsoleImpl(final Scanner scanner) {
        this.scanner = scanner;
    }

    @Override
    public List<Integer> readInput() {
        System.out.println("숫자를 입력해 주세요 : ");
        inputNumber = scanner.nextLine().split("");

        validateInputNumber();

        return Arrays.stream(inputNumber)
                .map(Integer::parseInt)
                .collect(Collectors.toList());
    }

    private void validateInputNumber() {
        try {
            checkBlank();
            checkDistinct();
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readInput();
        }
    }

    private void checkBlank() throws IllegalArgumentException {
        if (Arrays.asList(inputNumber).contains(BLANK)) {
            throw new IllegalArgumentException("입력값에 공백이 포함되어 있습니다. 다시 입력하세요");
        }
    }

    private void checkDistinct() throws IllegalArgumentException {
        if (Arrays.stream(inputNumber).distinct().count() != MAX_INPUT_COUNT) {
            throw new IllegalArgumentException("입력값에 중복된 값이 있습니다. 다시 입력하세요");
        }
    }

    @Override
    public String readEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        String endInput = scanner.nextLine();
        validateEndInput(endInput);
        return endInput;
    }

    private void validateEndInput(String endInput) {
        try {
            check(endInput);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            readEnd();
        }
    }

    private void check(String endInput) throws IllegalArgumentException {
        if (!endInput.equals(Constant.RESTART) && !endInput.equals(Constant.FINISH)) {
            throw new IllegalArgumentException("종료 값이 아닌 잘못된 값이 입력되었습니다. 다시 입력하새요");
        }
    }
}
