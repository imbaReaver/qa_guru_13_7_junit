package pages;

import com.codeborne.selenide.Condition;

import static com.codeborne.selenide.CollectionCondition.texts;
import static com.codeborne.selenide.Selenide.*;

public class ProcessorsShopPage {

    public ProcessorsShopPage openPage () {
        open("catalog/17a899cd16404e77/processory/");
        return this;
    }
    public ProcessorsShopPage setFilterSearchQuery (String value) {
        $(".ui-input-search__input_catalog-filter").setValue(value).pressEnter();
        return this;
    }
    public ProcessorsShopPage checkResult (String value) {
        $$(".catalog-product").find(Condition.text(value)).shouldBe(Condition.visible);
        return this;
    }
    public ProcessorsShopPage checkCategoryTitle (String value) {
        $$(".products-page__title").shouldHave(texts(value));
        return this;
    }
}
