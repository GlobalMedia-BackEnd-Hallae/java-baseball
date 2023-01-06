package gmbs;

import java.util.ArrayList;
import java.util.Random;

public class Baseball {
    private final ArrayList<Integer> inputNumberList = new ArrayList<>();
    private final ArrayList<Integer> randomNumberList = new ArrayList<>();
    private final UserInput input = new UserInput();
    private int strikes;
    private int balls;

    Baseball() {
        for(int i = 0; i < Constant.DIGIT_NUMBER_LENGTH; i++) {
            inputNumberList.add(null);
            randomNumberList.add(null);
        }
        strikes = 0;
        balls = 0;
    }


    private void setRandomNumberList() {
        Random random = new Random();
        int tempRandomNumber = random.nextInt(9);
        for(int i = 0; i < Constant.DIGIT_NUMBER_LENGTH; i++) {
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
        for(int i = 0; i < Constant.DIGIT_NUMBER_LENGTH; i++) {
            System.out.println(randomNumberList.get(i));
        }
    }

    private void setInputNumberList() {
        int dividend;
        dividend = input.getNumberInput();
        for(int i = Constant.DIGIT_NUMBER_LENGTH-1; i >= 0; i--) {
            inputNumberList.set(i,dividend%10);
            dividend /= 10;
        }
    }

    private void showInputNumberList() {
        for(int i = 0; i < Constant.DIGIT_NUMBER_LENGTH; i++) {
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
        for(int i = 0; i < Constant.DIGIT_NUMBER_LENGTH; i++) {
            if(inputNumberList.get(i).equals(randomNumberList.get(i))) {
                strikes ++;
            }
            else if(randomNumberList.contains(inputNumberList.get(i))) {
                balls ++;
            }
        }
    }

    private void resetAll() {
        for(int i = 0; i < Constant.DIGIT_NUMBER_LENGTH; i++) {
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

    public void playOneGame() {
        resetAll();
        setRandomNumberList();
        showRandomNumberList();
        while(true) {
            setInputNumberList();
            check();
            showCounts();
            if(strikes==Constant.MAX_STRIKES) {
                break;
            }
            resetCounts();
        }
    }

    public void playBall() {
        while(true) {
            playOneGame();
            if(!input.isPlayAgain()) {
                break;
            }
        }
    }
}
