package guru.qa.pages.compontnts;

import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;

public class ResultTableComponent {

  private final SelenideElement modalWindow = $(".modal-open");
  private final SelenideElement outputTable = $(".table-responsive");
  private final SelenideElement closeModal = $("#closeLargeModal");

  @Step("Check Modal Window Appears")
  public ResultTableComponent checkModalWindowAppears() {
    modalWindow.should(appear);
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    return this;
  }

  @Step("Check Output key: '{0}' value: '{1}'")
  public ResultTableComponent checkOutput(String key, String value) {
    outputTable.$(byText(key)).parent().shouldHave(text(value));
    return this;
  }

  public void closeModalWindow() {
    closeModal.click();
  }
}
