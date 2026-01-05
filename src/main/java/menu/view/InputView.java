package menu.view;

import camp.nextstep.edu.missionutils.Console;
import menu.model.Coach;

public class InputView {

    private static final String READ_COACH_NAME_NOTICE = "코치의 이름을 입력해 주세요. (, 로 구분)";
    private static final String READ_FORBIDDEN_MENU_NOTICE = "%s(이)가 못 먹는 메뉴를 입력해 주세요.";

    public String readCoachName() {
        System.out.println(READ_COACH_NAME_NOTICE);
        return Console.readLine();
    }

    public String readForbiddenMenu(Coach coach) {
        System.out.printf(READ_FORBIDDEN_MENU_NOTICE, coach.getName());
        return Console.readLine();
    }
}
