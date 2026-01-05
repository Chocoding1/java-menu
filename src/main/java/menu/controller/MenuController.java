package menu.controller;

import static menu.exception.ExceptionHandler.*;

import menu.exception.ExceptionHandler;
import menu.model.Coaches;
import menu.util.CoachParser;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final OutputView outputView;
    private final InputView inputView;

    public MenuController(OutputView outputView, InputView inputView) {
        this.outputView = outputView;
        this.inputView = inputView;
    }

    public void run() {
        outputView.printServiceStartNotice();
        Coaches coaches = retryUntilSuccess(this::getCoaches);
    }

    private Coaches getCoaches() {
        String input = inputView.readCoachName();
        return CoachParser.parse(input);
    }
}
