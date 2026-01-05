package menu.view;

import camp.nextstep.edu.missionutils.Console;

public class InputView {

    private static final String READ_COACH_NAME_NOTICE = "코치의 이름을 입력해 주세요. (, 로 구분)";

    public String readCoachName() {
        System.out.println(READ_COACH_NAME_NOTICE);
        return Console.readLine();
    }
}
