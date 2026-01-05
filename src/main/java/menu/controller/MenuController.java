package menu.controller;

import static menu.exception.ExceptionHandler.*;

import java.util.List;
import menu.model.Coach;
import menu.model.Coaches;
import menu.util.CoachParser;
import menu.util.MenuParser;
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
        getForbiddenMenu(coaches);
    }

    private void getForbiddenMenu(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            String input = inputView.readForbiddenMenu(coach);
            List<String> menus = MenuParser.parse(input);
            coach.setForbiddenMenus(menus);
        }
    }

    private Coaches getCoaches() {
        String input = inputView.readCoachName();
        return CoachParser.parse(input);
    }
}
