package tests;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.*;

import java.util.stream.Stream;

public class ParamTests extends TestBase {

    @Disabled
    @DisplayName("Заблокированный тест")
    @Test
    void blockedTest() {
        processorsShopPage.openPage();
    }

    @DisplayName("Название категории корректно")
    @Test
    void categoryTest() {
        processorsShopPage.openPage()
                .checkCategoryTitle("Процессоры");
    }

    @ValueSource(strings = {"Ryzen 5", "Core i7"})
    @ParameterizedTest(name = "При поиске {0} в результатах отображается текст {0}")
    void valueSourceTest (String testData) {
        processorsShopPage.openPage()
                .setFilterSearchQuery(testData)
                .checkResult(testData);
    }

    @CsvSource(value = {"Ryzen 5, Процессор AMD Ryzen 5",
            "Core i7, Процессор Intel Core i7"
    })
    @ParameterizedTest(name = "При поиске {0} в результатах отображается текст {1}")
    void csvSourceTest (String searchData, String expectedResult) {
        processorsShopPage.openPage()
                .setFilterSearchQuery(searchData)
                .checkResult(expectedResult);
    }

    @CsvFileSource(resources = "testData/processors.csv")
    @ParameterizedTest(name = "При поиске {0} в результатах отображается текст {1}")
    void csvFileSourceTest (String searchData, String expectedResult) {
        processorsShopPage.openPage()
                .setFilterSearchQuery(searchData)
                .checkResult(expectedResult);
    }

    @EnumSource(Processors.class)
    @ParameterizedTest(name = "Поиск {0}")
    void enumSourceTest (Processors processors) {
        processorsShopPage.openPage()
                .setFilterSearchQuery(processors.processorName)
                .checkResult(processors.desc);
    }

    static Stream<Arguments> methodSourceTest() {
        return Stream.of(
                Arguments.of("Core i7", "Процессор"),
                Arguments.of("Ryzen 5", "Процессор")
        );
    }

    @MethodSource (value = "methodSourceTest")
    @ParameterizedTest
    void methodSourceTest (String searchData, String expectedResult) {
        processorsShopPage.openPage()
                .setFilterSearchQuery(searchData)
                .checkResult(expectedResult);
    }
}