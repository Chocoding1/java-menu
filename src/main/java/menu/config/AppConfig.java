package menu.config;

import menu.controller.MenuController;
import menu.view.OutputView;

public class AppConfig {

    private MenuController menuController;
    private OutputView outputView;

    public MenuController menuController() {
        if (menuController == null) {
            menuController = new MenuController(outputView());
        }
        return menuController;
    }

    private OutputView outputView() {
        if (outputView == null) {
            outputView = new OutputView();
        }
        return outputView;
    }
}
