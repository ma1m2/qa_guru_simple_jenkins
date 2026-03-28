package guru.qa.pages;

import com.codeborne.selenide.ElementsCollection;
import com.codeborne.selenide.SelenideElement;
import guru.qa.pages.compontnts.CalendarComponent;
import guru.qa.pages.compontnts.ResultTableComponent;
import io.qameta.allure.Step;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;

public class RegistrationPage {

  //Elements
  CalendarComponent calendarComponent =new CalendarComponent();
  //to open page
  private final ElementsCollection cardBody = $$(".card-body");
  private final ElementsCollection routerLink = $$(".router-link");
  private final SelenideElement textCenter = $(".text-center");
  //to fill form
  private final SelenideElement firstNameInput = $("#firstName");
  private final SelenideElement lastNameInput = $("#lastName");
  private final SelenideElement userEmailInput = $("#userEmail");
  private final SelenideElement genderContainer = $("#genterWrapper");
  private final SelenideElement userNumberInput = $("#userNumber");
  private final SelenideElement calendar = $("#dateOfBirthInput");
  private final SelenideElement subjectsInput = $("#subjectsInput");
  private final SelenideElement hobbyCheckboxes = $("#hobbiesWrapper");
  private final SelenideElement photoInput = $("#uploadPicture");
  private final SelenideElement currentAddress = $("#currentAddress");
  private final SelenideElement stateSelect = $("#state");
  private final SelenideElement citySelect = $("#city");
  private final SelenideElement stateCityContainer = $("#stateCity-wrapper");
  private final SelenideElement submitButton = $("#submit");

  //Actions
  @Step("Open registration page")
  public RegistrationPage openPage(){
    open("/");//automation-practice-form
    cardBody.findBy(text("Forms")).click();
    routerLink.findBy(text("Practice Form")).click();
    textCenter.shouldHave(text("Practice Form"));
    return this;
  }

  @Step("Type First Name '{0}'")
  public RegistrationPage typeFirstName(String value) {
    firstNameInput.setValue(value);
    return this;
  }

  @Step("Type Last Name '{0}'")
  public RegistrationPage typeLastName(String value) {
    lastNameInput.setValue(value);
    return this;
  }

  @Step("Type user email '{0}'")
  public RegistrationPage typeUserEmail(String value) {
    userEmailInput.setValue(value);
    return this;
  }

  @Step("Set Gender '{0}'")
  public RegistrationPage setGender(String value) {
    genderContainer.$(byText(value)).click();
    return this;
  }

  @Step("Type user Number '{0}'")
  public RegistrationPage typeUserNumber(String value) {
    userNumberInput.setValue(value);
    return this;
  }

  @Step("Set Date of Birthday day: '{0}', month: '{1}', year: '{2}'")
  public RegistrationPage setDateOfBirth(String day, String month, String year) {
    calendar.click();
    calendarComponent.setDate(day, month, year);
    return this;
  }

  @Step("Set Subject '{0}'")
  public RegistrationPage setSubject(String value) {
    subjectsInput.setValue(value).pressEnter();
    return this;
  }

  @Step("Set Hobby '{0}'")
  public RegistrationPage setHobby(String value) {
    hobbyCheckboxes.$(byText(value)).click();
    return this;
  }

  @Step("Upload Photo '{0}'")
  public RegistrationPage uploadPhoto(String value) {
    photoInput.uploadFromClasspath("img/" + value);
    return this;
  }

  @Step("Type Current Address '{0}'")
  public RegistrationPage typeCurrentAddress(String value) {
    currentAddress.setValue(value).pressEnter();
    return this;
  }

  @Step("Set State '{0}'")
  public RegistrationPage setState(String value) {
    stateSelect.scrollTo().click();
    stateCityContainer.$(byText(value)).click();
    return this;
  }

  @Step("Set City '{0}'")
  public RegistrationPage setCity(String value) {
    citySelect.click();
    stateCityContainer.$(byText(value)).click();
    return this;
  }

  @Step("Set State '{0}' and City '{1}'")
  public RegistrationPage setStateAndCity(String state, String city) {
    setState(state);
    setCity(city);
    return this;
  }

  @Step("Submit Form")
  public ResultTableComponent submitForm() {
    submitButton.scrollTo().click();
    return new ResultTableComponent();
  }

}
