package gmbs;

public class Game {

    public void numberBaseBall(String randomNumber) {
        int answer;
        Input input = new Input();
        Compare compare = new Compare();
        Output output = new Output();

        do {
            answer = output.output(compare.checkResult(randomNumber, input.inputNumber()));
        } while (answer == Constant.CONTINUE);
    }
}
