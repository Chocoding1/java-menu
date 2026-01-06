package menu.exception;

public enum ErrorMessage {

    ERROR_CATEGORY_NOT_FOUND("[ERROR] 존재하지 않는 카테코리입니다."),

    ERROR_COACH_NAME_LENGTH("[ERROR] 코치의 이름은 2글자 이상 4글자 이하여야 합니다."),
    ERROR_COACH_NAME_BLANK("[ERROR] 코치의 이름은 공백일 수 없습니다."),
    ERROR_MENU_NAME_BLANK("[ERROR] 메뉴 이름은 공백일 수 없습니다."),
    ERROR_FORBIDDEN_MENU_COUNT("[ERROR] 못 먹는 메뉴는 2개까지만 입력할 수 있습니다."),

    ERROR_COACH_COUNT("[ERROR] 코치는 2명에서 5명까지만 입력할 수 있습니다.");

    private final String message;

    ErrorMessage(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }
}
