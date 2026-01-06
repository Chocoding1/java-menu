package menu.model;

import static menu.exception.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CoachTest {

    @Test
    @DisplayName("코치 객체 정상 생성")
    void create_coach_success() {
        //given
        String name = "제임스";

        //when
        Coach coach = new Coach(name);

        //then
        assertThat(coach.getName()).isEqualTo(name);
    }

    @ParameterizedTest
    @ValueSource(strings = {" ", ""})
    @DisplayName("이름이 공백일 경우 코치 객체 생성 시 예외 발생")
    void create_coach_fail_when_name_is_blank(String name) {
        //when & then
        assertThatThrownBy(() -> new Coach(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_COACH_NAME_BLANK.getMessage());
    }

    @ParameterizedTest
    @ValueSource(strings = {"잭", "파라다이스"})
    @DisplayName("이름 길이가 유효하지 않을 경우 코치 생성 시 예외 발생")
    void create_coach_fail_when_invalid_nameLength(String name) {
        //when & then
        assertThatThrownBy(() -> new Coach(name))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_COACH_NAME_LENGTH.getMessage());
    }

    @Test
    @DisplayName("못 먹는 메뉴 정상 등록")
    void setForbiddenMenus_success() {
        //given
        Coach coach = new Coach("제임스");
        List<String> forbiddenMenus = List.of("스시", "돈까스");

        //when & then
        Assertions.assertThatCode(() -> coach.setForbiddenMenus(forbiddenMenus))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("메뉴 이름이 공백일 경우 못 먹는 메뉴 등록 시 예외 발생")
    void setForbiddenMenus_fail_when_menuName_is_blank() {
        //given
        Coach coach = new Coach("제임스");
        List<String> forbiddenMenus = List.of("", " ");

        //when
        assertThatThrownBy(() -> coach.setForbiddenMenus(forbiddenMenus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_MENU_NAME_BLANK.getMessage());
    }

    @Test
    @DisplayName("메뉴 개수가 유효하지 않을 경우 못 먹는 메뉴 등록 시 예외 발생")
    void testMethod() {
        //given
        Coach coach = new Coach("제임스");
        List<String> forbiddenMenus = List.of("스시", "우동", "돈까스");

        //when
        assertThatThrownBy(() -> coach.setForbiddenMenus(forbiddenMenus))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_FORBIDDEN_MENU_COUNT.getMessage());
    }
}