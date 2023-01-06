package gmbs;

import java.util.List;

public class Application {

    public static void main(String[] args) {
        RandomNumber randomNum = new RandomNumber();
        Input input = new Input();
        GameJudgement judge = new GameJudgement();
        Playagain playagain = new Playagain();
        boolean again = true;

        while (again){
            List<Integer> computer = randomNum.create();
            String result = "";
            while (!result.equals("3스트라이크")){
                result = judge.judgement(computer, input.playerNumber());
                System.out.println(result);
            }
            again = playagain.playagain();
        }
    }
}