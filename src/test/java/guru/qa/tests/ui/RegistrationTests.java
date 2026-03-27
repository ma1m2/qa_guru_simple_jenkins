package guru.qa.tests.ui;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.AfterEach;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.closeWebDriver;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.testdata.TestData.*;

public class RegistrationTests {

  @BeforeAll
  static void setUp() {
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = "https://demoqa.com/";
    Configuration.browser = "chrome";
    Configuration.timeout = 5000; //default 4000
  }

  @AfterEach
  void tearDown() {
    closeWebDriver();
  }

  @Test
  public void demoqaFillForm() {
    open("/");//automation-practice-form
    $$(".card-body").findBy(text("Forms")).click();
    $$(".router-link").findBy(text("Practice Form")).click();
    $(".text-center").shouldHave(text("Practice Form"));

    $("#firstName").setValue(firstName);
    $("#lastName").setValue(lastName);
    $("#userEmail").setValue(userEmail);
    $("#genterWrapper").$(byText(gender)).click();
    $("#userNumber").setValue(phoneNumber);
    //Calendar
    $("#dateOfBirthInput").click();
    $(".react-datepicker__month-select").selectOption(month);
    $(".react-datepicker__year-select").selectOption(year);
    $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

    $("#subjectsInput").setValue(subject).pressEnter();
    $("#hobbiesWrapper").$(byText(hobbie)).click();
    $("#uploadPicture").uploadFromClasspath("img/" + fileName);
    $("#currentAddress").setValue(currentAddress).pressEnter();

    $("#state").scrollTo().click();
    $("#stateCity-wrapper").$(byText(state)).click();
    $("#city").click();
    $("#stateCity-wrapper").$(byText(city)).click();
    $("#submit").scrollTo().click();

    $(".modal-open").should(appear);
    $("#example-modal-sizes-title-lg").shouldHave(text("Thanks for submitting the form"));
    $(".table-responsive").shouldHave(text(firstName + " " + lastName));
    $(".table-responsive").shouldHave(text(userEmail));
    $(".table-responsive").shouldHave(text(gender));
    $(".table-responsive").shouldHave(text(phoneNumber));
    $(".table-responsive").shouldHave(text(day+" "+month+","+year));
    $(".table-responsive").shouldHave(text(subject));
    $(".table-responsive").shouldHave(text(hobbie));
    $(".table-responsive").shouldHave(text(currentAddress));
    $(".table-responsive").shouldHave(text(fileName));
    $(".table-responsive").shouldHave(text(state+" "+city));
    $("#closeLargeModal").click();
  }

}
