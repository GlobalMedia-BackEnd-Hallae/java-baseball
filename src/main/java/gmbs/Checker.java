package gmbs;

import java.util.HashSet;

import static java.lang.Character.isDigit;

// 수가 조건에 맞는 지 판별해주는 함수를 모아둔 클래스
public class Checker {
    private HashSet<String> numberCheck = new HashSet<>();

    // 원활한 체크를 위한 HashSet, ArrayList 초기화
    private void setting() {
        numberCheck.clear();
    }

    // 숫자 여부를 판별하는 함수
    private int isNumber(String number) {
        if (isDigit(number.charAt(0))) {
            return 1;
        }

        return 0;
    }

    // set을 활용한 중복 체크
    private int pushSet(String number) {
        int numberCnt = 0;

        for (int index = 0; index < number.length(); index++) {
            numberCheck.add(String.valueOf(number.charAt(index)));
            numberCnt += isNumber(String.valueOf(number.charAt(index)));
        }

        return numberCnt;
    }

    // 수가 잘못된 수인지 판별하는 함수
    public String checkNumber(String number) {
        setting();
        int numberCnt = pushSet(number);

        if ((numberCnt != Constant.NUMBER_LENGTH) || numberCheck.size() != Constant.NUMBER_LENGTH) {
            throw new IllegalStateException();
        }

        return number;
    }
}