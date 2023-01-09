package gmbs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    private final String separator = "";
    private final Scanner scanner = new Scanner(System.in);

    public List<Integer> playerNumber() {
        try {
            System.out.println("숫자를 입력해주세요 : ");
            List<Integer> playerNumber = new ArrayList<>();
            String input = scanner.next();
            for (String number : input.split(separator)) {
                playerNumber.add(Integer.parseInt(number));
            }
            return playerNumber;
        } catch (IllegalArgumentException e) {
            System.out.println("잘못된 수를 입력했습니다");
            return playerNumber();
        }
    }
}
