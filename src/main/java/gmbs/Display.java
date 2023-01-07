package gmbs;

public class Display {
    public static void playAgainDisplay(String yes, String no) {
        System.out.println("다시하려면 '" + yes + "'    종료하려면 '" + no + "'   입력");
    }

    public static void numberInputDisplay(int length) {
        System.out.println(length + "자리 정수 입력");
    }

    public static void wrongInputDisplay() {
        System.out.println("잘못된 입력");
    }

    public static void countsDisplay(int strikes, int balls) {
        if(strikes == 0 && balls == 0) {
            System.out.println("낫싱");
        }
        else {
            System.out.println(strikes + " 스트라이크    " + balls + " 볼");
        }
    }
}
