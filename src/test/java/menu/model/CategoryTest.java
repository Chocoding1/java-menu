package menu.model;

import static menu.exception.ErrorMessage.*;
import static org.assertj.core.api.Assertions.*;
import static org.junit.jupiter.api.Assertions.*;

import menu.exception.ErrorMessage;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class CategoryTest {

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3, 4, 5})
    @DisplayName("카테고리 번호로 카테고리 정상 반환")
    void getCategory_from_id_success(int categoryId) {
        //when & then
        assertThatCode(() -> Category.from(categoryId))
                .doesNotThrowAnyException();
    }

    @ParameterizedTest
    @ValueSource(ints = {0, -1, 6})
    @DisplayName("존재하지 않는 카테고리 번호로 카테고리 반환 시도 시 예외 발생")
    void getCategory_from_id_fail_when_invalid_id(int categoryId) {
        //when & then
        assertThatThrownBy(() -> Category.from(categoryId))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessage(ERROR_CATEGORY_NOT_FOUND.getMessage());
    }
}