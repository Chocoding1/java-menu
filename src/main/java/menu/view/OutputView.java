package menu.view;

import java.util.stream.Collectors;
import menu.model.Category;
import menu.model.Coach;
import menu.model.Coaches;

public class OutputView {

    private static final String LINE_SEPARATOR = System.lineSeparator();

    private static final String SERVICE_START_NOTICE = "점심 메뉴 추천을 시작합니다.";
    private static final String SUGGESTED_RESULT_NOTICE = "메뉴 추천 결과입니다.";
    private static final String DAY_OF_WEEK_NOTICE = "[ 구분 | 월요일 | 화요일 | 수요일 | 목요일 | 금요일 ]";
    private static final String SUGGEST_COMPLETE_NOTICE = "추천을 완료했습니다.";

    public void printServiceStartNotice() {
        System.out.println(SERVICE_START_NOTICE);
    }

    public void printSuggestedResult(Coaches coaches) {
        System.out.println(SUGGESTED_RESULT_NOTICE);
        System.out.println(DAY_OF_WEEK_NOTICE);

        StringBuilder sb = new StringBuilder();
        addCategory(sb, coaches);
        addSuggestedMenus(sb, coaches);
        System.out.println(sb);

        System.out.println(SUGGEST_COMPLETE_NOTICE);
    }

    private void addCategory(StringBuilder sb, Coaches coaches) {
        String categories = String.join(" | ", coaches.getSuggestedCategoriesName());

        sb.append("[ 카테고리 | ")
                .append(categories)
                .append(" ]")
                .append(LINE_SEPARATOR);
    }

    private void addSuggestedMenus(StringBuilder sb, Coaches coaches) {
        for (Coach coach : coaches.getCoaches()) {
            String menus = String.join(" | ", coach.getSuggestedMenus());
            sb.append("[ ").append(coach.getName()).append(" | ")
                    .append(menus)
                    .append(" ]").append(LINE_SEPARATOR);
        }
    }
}
