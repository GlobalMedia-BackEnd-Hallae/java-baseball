package gmbs;

import java.util.Scanner;

public class PlayAgain {

    private static final int GAME_RESTART = 1;
    private static final int GAME_END = 2;
    private int answer;

    public boolean isPlayAgain() {
        System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료 다시 시작 : 1, 종료 : 2");
        answer = new Scanner(System.in).nextInt();
        if (this.answer == GAME_RESTART) {
            return true;
        }
        return false;
    }
}
