package gmbs;

import java.util.ArrayList;
import java.util.Random;

public class Baseball {
    private final ArrayList<Integer> inputNumberList = new ArrayList<>();
    private final ArrayList<Integer> randomNumberList = new ArrayList<>();
    private final UserInput userInput = new UserInput();
    private int strikes;
    private int balls;

    Baseball() {
        for(int i = 0; i < Constant.inputLength; i++) {
            inputNumberList.add(null);
            randomNumberList.add(null);
        }
        resetBalls();
        resetStrikes();
    }
    public int getStrikes() {
        return strikes;
    }

    public int getBalls() {
        return balls;
    }

    public void addStrikes() {
        strikes ++;
    }

    public void addBalls() {
        balls ++;
    }

    public void resetStrikes() {
        strikes = 0;
    }

    public void resetBalls() {
        balls = 0;
    }


    public void setRandomNumberList() {
        Random random = new Random();
        int tempRandomNumber = random.nextInt(9);
        for(int i = 0; i < Constant.inputLength; i++) {
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

    public void showRandomNumberList() {
        for(int i = 0; i < Constant.inputLength; i++) {
            System.out.println(randomNumberList.get(i));
        }
    }

    public void setInputNumberList() {
        int dividend;
        dividend = userInput.getNumber();
        for(int i = Constant.inputLength -1; i >= 0; i--) {
            inputNumberList.set(i,dividend%10);
            dividend /= 10;
        }
    }

    private void check() {
        for(int i = 0; i < Constant.inputLength; i++) {
            if(inputNumberList.get(i).equals(randomNumberList.get(i))) {
                addStrikes();
            }
            else if(randomNumberList.contains(inputNumberList.get(i))) {
                addBalls();
            }
        }
    }

    private void resetAll() {
        for(int i = 0; i < Constant.inputLength; i++) {
            inputNumberList.set(i,null);
            randomNumberList.set(i,null);
        }
        resetStrikes();
        resetBalls();
    }

    public void resetCounts() {
        resetStrikes();
        resetBalls();
    }

    public void playOneGame() {
        resetAll();
        setRandomNumberList();
        showRandomNumberList();
        while(true) {
            setInputNumberList();
            check();
            Display.countsDisplay(getStrikes(),getBalls());
            if(strikes==Constant.MAX_STRIKES) {
                break;
            }
            resetCounts();
        }
    }

    public void playBall() {
        do {
            playOneGame();
        } while (userInput.getYesNo());
    }
}
