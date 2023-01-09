package gmbs;

import java.util.Scanner;

public class Input {
    private Scanner scanner = new Scanner(System.in);

    // 수를 입력받는 함수
    public String inputNumber() {
        String number;

        try {
            System.out.print("숫자를 입력해주세요 : ");
            number = scanner.nextLine();
            Checker checker = new Checker();
            checker.checkNumber(number);
            return number;
        } catch (IllegalStateException error) {
            System.out.println("잘못된 수를 입력하셨습니다.");
            return inputNumber();
        }
    }
}
