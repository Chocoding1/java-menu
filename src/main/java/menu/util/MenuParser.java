package menu.util;

import java.util.List;

public class MenuParser {

    private static final String COMMA = ",";

    public static List<String> parse(String input) {
        return List.of(input.split(","));
    }
}
