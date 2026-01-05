package menu.model;

import java.util.ArrayList;
import java.util.List;

public class Coach {

    private final String name;
    private List<String> forbiddenMenus;
    private List<String> suggestedMenus;

    public Coach(String name) {
        validateNameLength(name);
        this.name = name;
        this.forbiddenMenus = new ArrayList<>();
        this.suggestedMenus = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setForbiddenMenus(List<String> menus) {
        validateForbiddenMenuCount(menus);
        this.forbiddenMenus = menus;
    }

    private void validateNameLength(String name) {
        if (name.length() < 2 || 4 < name.length()) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 2글자 이상 4글자 이하여야 합니다.");
        }
    }

    private void validateForbiddenMenuCount(List<String> menus) {
        if (menus.size() > 2) {
            throw new IllegalArgumentException("[ERROR] 못 먹는 메뉴는 2개까지만 입력할 수 있습니다.");
        }
    }
}
