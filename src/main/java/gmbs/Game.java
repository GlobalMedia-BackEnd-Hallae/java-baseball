package gmbs;

public class Game {

    public void numberBaseBall(String randomNumber) {
        int answer = Constant.CONTINUE;
        String userNumber;
        String resultCount;
        Input input = new Input();
        Compare compare = new Compare();
        Output output = new Output();

        while (answer == Constant.CONTINUE) {
            userNumber = input.inputNumber();
            resultCount = compare.checkResult(randomNumber, userNumber);
            answer = output.output(resultCount);
        }
    }
}
