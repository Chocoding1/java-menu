package menu.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches;
    public List<Category> suggestedCategories;

    public Coaches(List<Coach> coaches) {
        validateCoachesCount(coaches);
        this.coaches = Collections.unmodifiableList(coaches);
        this.suggestedCategories = new ArrayList<>();
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public boolean canNotSuggest(Category category) {
        return Collections.frequency(suggestedCategories, category) >= 2;
    }

    public void logCategory(Category category) {
        suggestedCategories.add(category);
    }

    private void validateCoachesCount(List<Coach> coaches) {
        if (coaches.size() < 2 || 5 < coaches.size()) {
            throw new IllegalArgumentException("[ERROR] 코치는 2명에서 5명까지만 입력할 수 있습니다.");
        }
    }
}
