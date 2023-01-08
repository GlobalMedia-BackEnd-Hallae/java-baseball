package gmbs.view.output.impl;

import gmbs.view.output.OutputConsole;

public class OutputConsoleNothing implements OutputConsole {

    @Override
    public void printResult() {
        System.out.println("낫싱");
    }
}
