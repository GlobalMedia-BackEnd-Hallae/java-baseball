package gmbs.domain;

import gmbs.view.input.InputConsole;

public class BaseballGameController {

    private final InputConsole inputConsole;

    public BaseballGameController(final InputConsole inputConsole) {
        this.inputConsole = inputConsole;
    }

    public void run() {
        boolean restartGame = true;
        while (restartGame) {
            BaseballGameService gameService = new BaseballGameService(inputConsole);
            gameService.play();
            restartGame = gameService.gameRestart();
        }
    }
}
