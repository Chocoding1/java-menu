package menu.model;

import java.util.Collections;
import java.util.List;

public class Coaches {

    private final List<Coach> coaches;

    public Coaches(List<Coach> coaches) {
        validateCoachesCount(coaches);
        this.coaches = Collections.unmodifiableList(coaches);
    }

    private void validateCoachesCount(List<Coach> coaches) {
        if (coaches.size() < 2 || 5 < coaches.size()) {
            throw new IllegalArgumentException("[ERROR] 코치는 2명에서 5명까지만 입력할 수 있습니다.");
        }
    }
}
