package menu.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import menu.model.Coach;
import menu.model.Coaches;

public class CoachParser {

    private static final String COMMA = ",";

    public static Coaches parse(String input) {
        List<Coach> coaches = Arrays.stream(input.split(COMMA))
                .map(String::strip)
                .map(Coach::new)
                .collect(Collectors.toList());

        return new Coaches(coaches);
    }
}
