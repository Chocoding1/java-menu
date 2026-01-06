package menu.controller;

import static menu.exception.ExceptionHandler.*;

import java.util.List;
import menu.model.Coach;
import menu.model.Coaches;
import menu.service.MenuService;
import menu.util.CoachParser;
import menu.util.MenuParser;
import menu.view.InputView;
import menu.view.OutputView;

public class MenuController {

    private final OutputView outputView;
    private final InputView inputView;
    private final MenuService menuService;

    public MenuController(OutputView outputView, InputView inputView, MenuService menuService) {
        this.outputView = outputView;
        this.inputView = inputView;
        this.menuService = menuService;
    }

    public void run() {
        outputView.printServiceStartNotice();
        Coaches coaches = retryUntilSuccessSupplier(this::getCoaches);
        logForbiddenMenu(coaches);
        menuService.suggestMenus(coaches);
        outputView.printSuggestedResult(coaches);
    }

    private Coaches getCoaches() {
        String input = inputView.readCoachName();
        return CoachParser.parse(input);
    }

    private void logForbiddenMenu(Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            retryUntilSuccessRunnable(() -> logForbiddenMenuPerCoach((coach)));
        }
    }

    private void logForbiddenMenuPerCoach(Coach coach) {
        String input = inputView.readForbiddenMenu(coach);
        List<String> menus = MenuParser.parse(input);
        coach.logForbiddenMenus(menus);
    }
}
