package gmbs;

import java.util.Scanner;

public class PlayAgain {

    private static final String GAME_RESTART_OR_GAME_END = "3개의 숫자를 모두 맞히셨습니다! 게임 종료 다시 시작 : 1 종료 : 2";
    private static final int GAME_RESTART = 1;

    private final Scanner scanner = new Scanner(System.in);

    public boolean PlayAgain() {
        System.out.println(GAME_RESTART_OR_GAME_END);
        int answer = scanner.nextInt();
        if (answer == GAME_RESTART) {
            return true;
        }
        return false;
    }
}
