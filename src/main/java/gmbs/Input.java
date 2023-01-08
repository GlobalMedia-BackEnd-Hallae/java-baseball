package gmbs;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Input {

    public List<Integer> playerNumber() {
        try {
            System.out.println("숫자를 입력해주세요 : ");
            Scanner scanner = new Scanner(System.in);
            List<Integer> playerNumber = new ArrayList<>();
            String input = scanner.next();

            for (String number : input.split("")) {
                playerNumber.add(Integer.parseInt(number));
            }
            return playerNumber;
        }catch (IllegalStateException e){
            System.out.println("잘못된 수를 입력했습니다");
            return playerNumber();
        }

    }
}
