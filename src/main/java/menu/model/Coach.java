package menu.model;

import static menu.exception.ErrorMessage.ERROR_COACH_NAME_BLANK;
import static menu.exception.ErrorMessage.ERROR_COACH_NAME_LENGTH;
import static menu.exception.ErrorMessage.ERROR_FORBIDDEN_MENU_COUNT;
import static menu.exception.ErrorMessage.ERROR_MENU_NAME_BLANK;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private static final int MIN_NAME_LENGTH = 2;
    private static final int MAX_NAME_LENGTH = 4;
    private static final int MAX_FORBIDDEN_MENU_COUNT = 2;

    private final String name;
    private List<String> forbiddenMenus;
    private final List<String> suggestedMenus;

    public Coach(String name) {
        validateName(name);
        this.name = name;
        this.forbiddenMenus = new ArrayList<>();
        this.suggestedMenus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public List<String> getSuggestedMenus() {
        return suggestedMenus;
    }

    public void setForbiddenMenus(List<String> menus) {
        validateForbiddenMenu(menus);
        this.forbiddenMenus = menus;
    }

    public boolean canNotSuggest(String pickedMenu) {
        return forbiddenMenus.contains(pickedMenu) || suggestedMenus.contains(pickedMenu);
    }

    public void logSuggestedMenu(String pickedMenu) {
        suggestedMenus.add(pickedMenu);
    }

    private void validateName(String name) {
        validateNameBlank(name);
        validateNameLength(name);
    }

    private static void validateNameLength(String name) {
        if (name.length() < MIN_NAME_LENGTH || MAX_NAME_LENGTH < name.length()) {
            throw new IllegalArgumentException(ERROR_COACH_NAME_LENGTH.getMessage());
        }
    }

    private static void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException(ERROR_COACH_NAME_BLANK.getMessage());
        }
    }

    private void validateForbiddenMenu(List<String> menus) {
        validateMenuBlank(menus);
        validateForbiddenMenuCount(menus);
    }

    private void validateMenuBlank(List<String> menus) {
        for (String menu : menus) {
            if (menu.isBlank()) {
                throw new IllegalArgumentException(ERROR_MENU_NAME_BLANK.getMessage());
            }
        }
    }

    private void validateForbiddenMenuCount(List<String> menus) {
        if (menus.size() > MAX_FORBIDDEN_MENU_COUNT) {
            throw new IllegalArgumentException(ERROR_FORBIDDEN_MENU_COUNT.getMessage());
        }
    }
}
