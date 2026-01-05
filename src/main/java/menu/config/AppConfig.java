package menu.config;

import menu.controller.MenuController;
import menu.view.InputView;
import menu.view.OutputView;

public class AppConfig {

    private MenuController menuController;
    private OutputView outputView;
    private InputView inputView;

    public MenuController menuController() {
        if (menuController == null) {
            menuController = new MenuController(outputView(), inputView());
        }
        return menuController;
    }

    private OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }

    private InputView inputView() {
        if (inputView == null) {
            inputView = new InputView();
        }
        return inputView;
    }
}
