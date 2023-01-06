package gmbs.view;

import gmbs.common.Constant;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {

    private static final String PLACE_VALUE_DELIMITER = "";

    public static List<Integer> readInputNumber() {
        System.out.println("숫자를 입력해주세요 : ");
        return toArrayList(readInput());
    }

    private static List<Integer> toArrayList(String inputStringNumber) {
        List<Integer> inputNumberList = Arrays.stream(inputStringNumber.split(PLACE_VALUE_DELIMITER))
                .distinct()
                .map(Integer::parseInt)
                .collect(Collectors.toList());

        try {
            if (inputNumberList.size() != Constant.MAX_INPUT_SIZE) {
                throw new IllegalArgumentException("잘못된 숫자를 입력했습니다.");
            }
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            System.out.println("숫자를 다시 입력해주세요 : ");
            return toArrayList(readInput());
        }

        return inputNumberList;
    }

    public static String readEnd() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return readInput();
    }

    private static String readInput() {
        return new Scanner(System.in).nextLine();
    }
}
