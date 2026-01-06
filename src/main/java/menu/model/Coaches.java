package menu.model;

import static menu.exception.ErrorMessage.ERROR_COACH_COUNT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Coaches {

    private static final int MIN_COACH_COUNT = 2;
    private static final int MAX_COACH_COUNT = 5;
    private static final int MAX_SAME_CATEGORY_COUNT_PER_WEEK = 2;

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
        return Collections.frequency(suggestedCategories, category) >= MAX_SAME_CATEGORY_COUNT_PER_WEEK;
    }

    public void logCategory(Category category) {
        suggestedCategories.add(category);
    }

    private void validateCoachesCount(List<Coach> coaches) {
        if (coaches.size() < MIN_COACH_COUNT || MAX_COACH_COUNT < coaches.size()) {
            throw new IllegalArgumentException(ERROR_COACH_COUNT.getMessage());
        }
    }
}
