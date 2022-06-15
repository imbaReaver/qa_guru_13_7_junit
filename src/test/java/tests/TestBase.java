package tests;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.BeforeAll;
import pages.ProcessorsShopPage;

public class TestBase {

    ProcessorsShopPage processorsShopPage = new ProcessorsShopPage();
    // Browser configuration
    @BeforeAll
    static void beforeAll() {
        Configuration.baseUrl = "https://www.dns-shop.ru/";
        Configuration.browserSize = "1920x1080";
    }
}
