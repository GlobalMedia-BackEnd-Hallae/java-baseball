package gmbs;

public class Output {
    public int output(String resultCount) {
        int ballCount = resultCount.charAt(0) - Constant.ASCII_CODE_OF_ZERO;
        int strikeCount = resultCount.charAt(1) - Constant.ASCII_CODE_OF_ZERO;

        if (ballCount == 0 && strikeCount == 0) {
            System.out.println("낫싱");
        } else if (ballCount == 1 && strikeCount == 0) {
            System.out.println("1볼");
        } else if (ballCount == 2 && strikeCount == 0) {
            System.out.println("2볼");
        } else if (ballCount == 3 && strikeCount == 0) {
            System.out.println("3볼");
        } else if (ballCount == 0 && strikeCount == 1) {
            System.out.println("1스트라이크");
        } else if (ballCount == 0 && strikeCount == 2) {
            System.out.println("2스트라이크");
        } else if (ballCount == 0 && strikeCount == 3) {
            System.out.println("3스트라이크");
            System.out.println("3개의 숫자를 모두 맞히셨습니다! 게임 종료");
            return Constant.END;
        } else if (ballCount == 1 && strikeCount == 1) {
            System.out.println("1볼 1스트라이크");
        } else if (ballCount == 2 && strikeCount == 1) {
            System.out.println("2볼 1스트라이크");
        }

        return Constant.CONTINUE;
    }
}
