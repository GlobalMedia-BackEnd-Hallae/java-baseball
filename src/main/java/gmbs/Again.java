package gmbs;

import java.util.Scanner;

public class Again {
    public int returnGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }
}
