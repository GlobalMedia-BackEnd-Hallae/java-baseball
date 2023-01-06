package gmbs;

import java.util.Random;
import java.util.Scanner;

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

    private static final String EXPRESSION_DELIMETER = "";
    public static final int NUMBERLENGTH = 3;
    public static final int NOT_EXIST = -1;
    public static final int BALL = 0;
    public static final int STRIKE = 1;

    static int rightInput = 0;
    static int recursion = 1;
    static int answer = 0;
    static String randomNumber;
    static String userNumber;
    static int ballCount;
    static int strikeCount;

    public static int checkInput() {
        if (userNumber.length() != NUMBERLENGTH) {
            throw new IllegalStateException("3개의 수를 입력해주세요.");
        }

        if ((userNumber.charAt(0) == userNumber.charAt(1)) || (userNumber.charAt(0) == userNumber.charAt(2)) || (userNumber.charAt(1) == userNumber.charAt(2))) {
            throw new IllegalStateException("서로 다른 임의의 수 3개를 입력해주세요.");
        }

        return rightInput = 1;
    }

    public static void inputNumber() {
        while(rightInput == 0) {
            System.out.print("숫자를 입력해주세요 : ");
            Scanner scanner = new Scanner(System.in);
            userNumber = scanner.nextLine();
            checkInput();
        }
        rightInput = 0;
    }

    public static String checkOverlap(String createdNumber, int index) {
        if (index == 0) {
            return createdNumber;
        }

        if (createdNumber.charAt(index - 1) == createdNumber.charAt(index)) {
            return createdNumber.substring(0, index);
        }

        return createdNumber;
    }

    public static String createRandomNumber() {
        Random random = new Random();
        String createdNumber = EXPRESSION_DELIMETER;

        while (createdNumber.length() < NUMBERLENGTH) {
            createdNumber += Integer.toString((random.nextInt(8) + 1));
            createdNumber = checkOverlap(createdNumber, createdNumber.length() - 1);
        }

        return createdNumber;
    }

    // 중복 수정 필요
    public static int compareNumber(int index) {
        if ((randomNumber.charAt(0) == userNumber.charAt(index)) && index == 0) {
            return STRIKE;
        }

        if ((randomNumber.charAt(0) == userNumber.charAt(index))) {
            return BALL;
        }

        if (randomNumber.charAt(1) == userNumber.charAt(index) && index == 1){
            return STRIKE;
        }

        if ((randomNumber.charAt(1) == userNumber.charAt(index))) {
            return BALL;
        }

        if (randomNumber.charAt(2) == userNumber.charAt(index) && index == 2){
            return STRIKE;
        }

        if ((randomNumber.charAt(2) == userNumber.charAt(index))) {
            return BALL;
        }

        return NOT_EXIST;
    }

    public static void applyResult(int result) {
        if (result == 0) {
            ballCount++;
        }

        if (result == 1) {
            strikeCount++;
        }
    }

    public static void checkResult() {
        ballCount = 0;
        strikeCount = 0;
        int resultOfIndex;

        for (int i = 0; i < 3; i++) {
            applyResult(compareNumber(i));
        }
    }

    public static void output() {
        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        }

        else if (ballCount == 1 && strikeCount == 0) {
            System.out.println("1볼");
        }

        else if (ballCount == 2 && strikeCount == 0) {
            System.out.println("2볼");
        }

        else if (ballCount == 3 && strikeCount == 0) {
            System.out.println("3볼");
        }

        else if (ballCount == 0 && strikeCount == 1) {
            System.out.println("1스트라이크");
        }

        else if (ballCount == 0 && strikeCount == 2) {
            System.out.println("2스트라이크");
        }

        else if (ballCount == 0 && strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            answer = 1;
        }

        else if (ballCount == 1 && strikeCount == 1) {
            System.out.println("1볼 1스트라이크");
        }

        else if (ballCount == 2 && strikeCount == 1) {
            System.out.println("2볼 1스트라이크");
        }
    }

    public static void numberBaseBall() {
        while(answer == 0) {
            inputNumber();
            checkResult();
            output();
        }
    }

    public static void returnGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        recursion = scanner.nextInt();
        answer = 0;
        rightInput = 0;
    }

    public static void main(String[] args) {
        // TODO : 기능 구현
        while(recursion == 1) {
            randomNumber = createRandomNumber();
            numberBaseBall();
            returnGame();
        }
    }
}
