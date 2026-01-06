package menu.model;

import static menu.exception.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;

import java.util.List;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

class CoachesTest {

    @Test
    @DisplayName("Coaches 객체 정상 생성")
    void create_coaches_success() {
        //given
        List<Coach> coaches = List.of(new Coach("포비"), new Coach("제임스"), new Coach("보거스"));

        //when & then
        assertThatCode(() -> new Coaches(coaches))
                .doesNotThrowAnyException();
    }

    @Test
    @DisplayName("코치들의 인원수가 유효하지 않을 경우 Coaches 객체 생성 시 예외 발생")
    void create_coaches_fail_when_invalid_coaches_count() {
        //given
        List<Coach> coaches = List.of(new Coach("포비"));

        //when & then
        assertThatThrownBy(() -> new Coaches(coaches))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_COACH_COUNT.getMessage());
    }
}