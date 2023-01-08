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

    // static Scanner scanner = new Scanner(System.in);

    // 수의 중복 여부를 판별하는 함수
    public static boolean checkNumberOverlap(String Number) {
        if ((Number.charAt(0) == Number.charAt(1)) || (Number.charAt(0) == Number.charAt(2)) || (Number.charAt(1) == Number.charAt(2))) {
            return true;
        }

        return false;
    }

    // 사용자가 입력한 수가 잘못된 수인지 판별하는 함수
    public static void checkInput(String userNumber) {
        if ((userNumber.length() != Constant.NUMBER_LENGTH) || checkNumberOverlap(userNumber)) {
            throw new IllegalStateException();
        }
    }

    // 수를 입력받는 함수
    public static String inputNumber(String userNumber) {
        try {
            System.out.print("숫자를 입력해주세요 : ");
            Scanner scanner = new Scanner(System.in);
            userNumber = scanner.nextLine();
            checkInput(userNumber);
            return userNumber;
        } catch (IllegalStateException error) {
            System.out.println("잘못된 수를 입력하셨습니다.");
            return inputNumber(userNumber);
        }
    }

    // 컴퓨터가 생성한 숫자가 조건에 맞는 지 판별해주는 함수
    public static String checkRandomNumber(String createdNumber) {
        if (createdNumber.length() != Constant.NUMBER_LENGTH) {
            return createdNumber;
        }

        if (checkNumberOverlap(createdNumber)) {
            return Constant.EXPRESSION_DELIMETER;
        }

        return createdNumber;
    }

    // 컴퓨터의 숫자를 생성해주는 함수
    public static String createRandomNumber() {
        Random random = new Random();
        String createdNumber = Constant.EXPRESSION_DELIMETER;

        while (createdNumber.length() < Constant.NUMBER_LENGTH) {
            createdNumber += Integer.toString((random.nextInt(Constant.NUMBER_RANGE) + 1));
            createdNumber = checkRandomNumber(createdNumber);
        }

        return createdNumber;
    }

    // Strike 여부를 판별해주는 함수
    public static boolean resultIsStrike(String randomNumber, String userNumber, int index) {
        if ((randomNumber.charAt(0) == userNumber.charAt(index)) && index == 0) {
            return true;
        }

        if (randomNumber.charAt(1) == userNumber.charAt(index) && index == 1){
            return true;
        }

        if (randomNumber.charAt(2) == userNumber.charAt(index) && index == 2){
            return true;
        }

        return false;
    }

    // Ball 여부를 판별해주는 함수
    public static boolean resultIsBall(String randomNumber, String userNumber, int index) {
        if ((randomNumber.charAt(0) == userNumber.charAt(index))) {
            return true;
        }

        if ((randomNumber.charAt(1) == userNumber.charAt(index))) {
            return true;
        }

        if ((randomNumber.charAt(2) == userNumber.charAt(index))) {
            return true;
        }

        return false;
    }

    // 수를 비교해주는 함수
    public static int compareNumber(String randomNumber, String userNumber, int index) {
        if (resultIsStrike(randomNumber, userNumber, index)) {
            return Constant.STRIKE;
        }

        if (resultIsBall(randomNumber, userNumber, index)) {
            return Constant.BALL;
        }

        return Constant.NOT_EXIST;
    }


    public static int checkBall(int result) {
        if (result == Constant.BALL) {
            return 1;
        }

        return 0;
    }

    public static int checkStrike(int result) {
        if (result == Constant.STRIKE) {
            return 1;
        }

        return 0;
    }

    public static String checkResult(String randomNumber, String userNumber, int ballCount, int strikeCount) {
        for (int index = 0; index < Constant.NUMBER_LENGTH; index++) {
            int result = compareNumber(randomNumber, userNumber, index);
            ballCount += checkBall(result);
            strikeCount += checkStrike(result);
        }

        return Integer.toString(ballCount) + Integer.toString(strikeCount);
    }

    public static int output(String resultCount) {
        int ballCount =  resultCount.charAt(0) - Constant.ASCII_CODE_OF_ZERO;
        int strikeCount =  resultCount.charAt(1) - Constant.ASCII_CODE_OF_ZERO;

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
            return Constant.END;
        }

        else if (ballCount == 1 && strikeCount == 1) {
            System.out.println("1볼 1스트라이크");
        }

        else if (ballCount == 2 && strikeCount == 1) {
            System.out.println("2볼 1스트라이크");
        }

        return Constant.CONTINUE;
    }

    public static void numberBaseBall(String randomNumber) {
        int answer = Constant.CONTINUE;
        String userNumber = Constant.EXPRESSION_DELIMETER;
        String resultCount;
        int ballCount = 0;
        int strikeCount = 0;

        while(answer == Constant.CONTINUE) {
            userNumber = inputNumber(userNumber);
            resultCount = checkResult(randomNumber, userNumber, ballCount, strikeCount);
            answer = output(resultCount);
        }
    }

    public static int returnGame() {
        System.out.println("게임을 새로 시작하려면 1, 종료하려면 2를 입력하세요.");
        Scanner scanner = new Scanner(System.in);
        return scanner.nextInt();
    }

    public static void main(String[] args) {
        // TODO : 기능 구현

        int recursion = Constant.CONTINUE;
        String randomNumber;

        while(recursion == Constant.CONTINUE) {
            randomNumber = createRandomNumber();
            System.out.println(randomNumber);
            numberBaseBall(randomNumber);
            recursion = returnGame();
        }
    }
}
