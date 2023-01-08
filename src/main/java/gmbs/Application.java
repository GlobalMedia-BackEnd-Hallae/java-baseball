package gmbs;

import gmbs.domain.BaseballGameController;
import gmbs.view.input.InputConsole;
import gmbs.view.input.InputConsoleImpl;

import java.util.Scanner;

public class Application {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputConsole inputConsole = new InputConsoleImpl(scanner);
        BaseballGameController gameController = new BaseballGameController(inputConsole);
        gameController.run();
    }
}
