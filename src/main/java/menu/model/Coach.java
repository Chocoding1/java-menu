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

    private void validateNameLength(String name) {
        if (name.length() < 2 || 4 < name.length()) {
            throw new IllegalArgumentException("[ERROR] 코치의 이름은 2글자 이상 4글자 이하여야 합니다.");
        }
    }
}
