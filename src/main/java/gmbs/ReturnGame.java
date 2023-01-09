package gmbs;

import java.util.Scanner;

public class ReturnGame {
    private Scanner scanner = new Scanner(System.in);

    public int returnGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        return scanner.nextInt();
    }
}
