package menu.model;

import static menu.exception.ErrorMessage.ERROR_COACH_COUNT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Coaches {

    private static final int MIN_COACH_COUNT = 2;
    private static final int MAX_COACH_COUNT = 5;
    private static final int MAX_SAME_CATEGORY_COUNT_PER_WEEK = 2;

    private final List<Coach> coaches;
    private List<Category> suggestedCategories;

    public Coaches(List<Coach> coaches) {
        validateCoachesCount(coaches);
        this.coaches = Collections.unmodifiableList(coaches);
        this.suggestedCategories = new ArrayList<>();
    }

    public List<String> getSuggestedCategoriesName() {
        return suggestedCategories.stream()
                .map(Category::getName)
                .collect(Collectors.toList());
    }

    public List<Coach> getCoaches() {
        return coaches;
    }

    public boolean isCategoryLimitExceeded(Category category) {
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
