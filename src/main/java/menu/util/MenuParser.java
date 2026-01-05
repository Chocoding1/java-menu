package menu.util;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class MenuParser {

    private static final String COMMA = ",";

    public static List<String> parse(String input) {
        if (input.isBlank()) {
            return Collections.emptyList();
        }

        return Arrays.stream(input.split(COMMA))
                .map(String::strip)
                .collect(Collectors.toList());
    }
}
