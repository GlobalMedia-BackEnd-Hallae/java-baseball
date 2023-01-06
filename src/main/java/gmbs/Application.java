package gmbs;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Application {

    private final int DIGIT_NUMBER_LENGTH = 3;
    private ArrayList<Integer> inputNumberList = new ArrayList<>();
    private ArrayList<Integer> randomNumberList = new ArrayList<>();
    private int strikes;
    private int balls;

    Application() {
        for(int i = 0; i < DIGIT_NUMBER_LENGTH; i++) {
            inputNumberList.add(null);
            randomNumberList.add(null);
        }
    }


    private void setRandomNumberList() {
        Random random = new Random();
        int tempRandomNumber = random.nextInt(9);
        for(int i = 0; i < DIGIT_NUMBER_LENGTH; i++) {
            if(i == 0) {
                randomNumberList.set(i, random.nextInt(8)+1);
            }
            else {
                while(randomNumberList.contains(tempRandomNumber)) {
                    tempRandomNumber = random.nextInt(9);
                }
                randomNumberList.set(i, tempRandomNumber);
            }
        }
    }

    private void showRandomNumberList() {
        for(int i = 0; i < DIGIT_NUMBER_LENGTH; i++) {
            System.out.println(randomNumberList.get(i));
        }
    }

    private void setInputNumberList() {
        int dividend;
        System.out.println("숫자를 입력하세요 : ");
        Scanner input = new Scanner(System.in);
        dividend = input.nextInt();
        for(int i = DIGIT_NUMBER_LENGTH-1; i >= 0; i--) {
            inputNumberList.set(i,dividend%10);
            dividend /= 10;
        }
    }

    private void showInputNumberList() {
        for(int i = 0; i < DIGIT_NUMBER_LENGTH; i++) {
            System.out.println(inputNumberList.get(i));
        }
    }

    private void showCounts() {
        if(strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        }
        else {
            System.out.println(strikes + " : 스트라이크");
            System.out.println(balls + " : 볼");
        }
    }

    private void check() {
        for(int i = 0; i < DIGIT_NUMBER_LENGTH; i++) {
            if(inputNumberList.get(i).equals(randomNumberList.get(i))) {
                strikes ++;
            }
            else if(randomNumberList.contains(inputNumberList.get(i))) {
                balls ++;
            }
        }
    }

    private void resetAll() {
        for(int i = 0; i < DIGIT_NUMBER_LENGTH; i++) {
            inputNumberList.set(i,null);
            randomNumberList.set(i,null);
        }
        strikes = 0;
        balls = 0;
    }

    private void resetCounts() {
        strikes = 0;
        balls = 0;
    }

    public void play() {
        resetAll();
        setRandomNumberList();
        while(true) {
            setInputNumberList();
            check();
            showCounts();
            if(strikes==3) {
                break;
            }
            resetCounts();
        }
    }

    public boolean checkPlayAgain() {
        System.out.println("계속하려면 1 아니면 2 입력");
        Scanner scanner = new Scanner(System.in);
        int input = scanner.nextInt();
        if (input == 1) {
            return true;
        }
        else if(input == 2) {
            return false;
        }
        return false;
    }

    public static void main(String[] args) {
        // TODO : 기능 구현
        Application a = new Application();
        while(true) {
            a.play();
            if(!a.checkPlayAgain()) {
                break;
            }
        }
    }
}

