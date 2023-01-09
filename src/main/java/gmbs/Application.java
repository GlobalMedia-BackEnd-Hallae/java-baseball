package gmbs;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        RandomNumber randomNumber = new RandomNumber();
        Input input = new Input();
        GameJudgement judge = new GameJudgement();
        PlayAgain playagain = new PlayAgain();
        boolean again = true;

        while (again) {
            List<Integer> computer = randomNumber.create();
            String result = "";
            while (!result.equals("3스트라이크")) {
                result = judge.GameJudgement(computer, input.playerNumber());
                System.out.println(result);
            }
            again = playagain.PlayAgain();
        }
    }
}
