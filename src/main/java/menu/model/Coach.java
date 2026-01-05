package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {

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
        if (name.length() < 2 || 4 < name.length()) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 2글자 이상 4글자 이하여야 합니다.");
        }
    }

    private static void validateNameBlank(String name) {
        if (name.isBlank()) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 공백일 수 없습니다.");
        }
    }

    private void validateForbiddenMenu(List<String> menus) {
        validateMenuBlank(menus);
        validateForbiddenMenuCount(menus);
    }

    private void validateMenuBlank(List<String> menus) {
        for (String menu : menus) {
            if (menu.isBlank()) {
                throw new IllegalArgumentException("[ERROR] 메뉴 이름은 공백일 수 없습니다.");
            }
        }
    }

    private void validateForbiddenMenuCount(List<String> menus) {
        if (menus.size() > 2) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 2개까지만 입력할 수 있습니다.");
        }
    }
}
