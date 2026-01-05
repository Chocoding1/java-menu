package menu.util;

import java.util.ArrayList;
import java.util.List;
import menu.model.Coach;
import menu.model.Coaches;

public class CoachParser {

    private static final String COMMA = ",";

    public static Coaches parse(String input) {
        List<Coach> coaches = new ArrayList<>();

        String[] names = input.split(COMMA);
        for (String name : names) {
            coaches.add(new Coach(name));
        }

        return new Coaches(coaches);
    }
}
