package gmbs;

public class Application {
    /*
    함수 종류
    -------- 반복 --------
    1. 1부터 9까지 서로 다른 수로 이루어진 3개의 수를 랜덤으로 만들어주는 함수
    -------- 반복 --------
    2. 사용자에게 3가지 수를 입력 받는 함수
    3. 입력 받은 수와 랜덤수를 비교해 결과를 출력해주는 함수
    4. 게임이 끝난 경우 재시작/종료 여부를 입력 받아 1번 부터 반복할 지의 여부를 결정하는 함수
     */

    public static void main(String[] args) {
        Create create = new Create();
        Game game = new Game();
        Again again = new Again();
        int recursion = Constant.CONTINUE;
        String randomNumber;

        while (recursion == Constant.CONTINUE) {
            randomNumber = create.createRandomNumber();
            game.numberBaseBall(randomNumber);
            recursion = again.returnGame();
        }
    }
}
