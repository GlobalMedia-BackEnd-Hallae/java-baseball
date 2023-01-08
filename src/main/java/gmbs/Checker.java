package gmbs;

import static java.lang.Character.isDigit;

// 수가 조건에 맞는 지 판별해주는 함수를 모아둔 클래스
public class Checker {

    // 숫자가 아닌 게 있는 지 확인해주는 함수
    private boolean checkNotNumber(String number) {
        if (isDigit(number.charAt(0)) && isDigit(number.charAt(1)) && isDigit(number.charAt(2))) {
            return false;
        }

        return true;
    }

    // 수의 중복 여부를 판별하는 함수
    private boolean checkNumberOverlap(String number) {
        if ((number.charAt(0) == number.charAt(1)) || (number.charAt(0) == number.charAt(2)) || (number.charAt(1) == number.charAt(2))) {
            return true;
        }

        return false;
    }

    // 수가 잘못된 수인지 판별하는 함수
    public void checkNumber(String number) {
        if ((number.length() != Constant.NUMBER_LENGTH) || checkNotNumber(number) || checkNumberOverlap(number)) {
            throw new IllegalStateException();
        }
    }
}
