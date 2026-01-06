package menu.service;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.List;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Coaches;

public class MenuService {

    public void suggestMenus(Coaches coaches) {
        for (int i = 0; i < 5; i++) {
            Category category = pickCategory(coaches);
            pickMenu(category, coaches);
        }
    }

    private Category pickCategory(Coaches coaches) {
        Category category;
        do {
            category = Category.from(Randoms.pickNumberInRange(1, 5));
        } while (coaches.isCategoryLimitExceeded(category));

        coaches.logCategory(category);
        return category;
    }

    private void pickMenu(Category category, Coaches coaches) {
        List<String> candidateMenus = category.getMenus();
        for (Coach coach : coaches.getCoaches()) {
            pickMenuPerCoach(coach, candidateMenus);
        }
    }

    private void pickMenuPerCoach(Coach coach, List<String> candidateMenus) {
        String pickedMenu;
        do {
            pickedMenu = Randoms.shuffle(candidateMenus).get(0);
        } while (coach.isUnavailableMenu(pickedMenu));
        coach.logSuggestedMenu(pickedMenu);
    }
}
