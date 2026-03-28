package guru.qa.tests.ui;

import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Condition.appear;
import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.$$;
import static com.codeborne.selenide.Selenide.open;
import static guru.qa.testdata.TestData.city;
import static guru.qa.testdata.TestData.currentAddress;
import static guru.qa.testdata.TestData.day;
import static guru.qa.testdata.TestData.fileName;
import static guru.qa.testdata.TestData.firstName;
import static guru.qa.testdata.TestData.gender;
import static guru.qa.testdata.TestData.hobbie;
import static guru.qa.testdata.TestData.lastName;
import static guru.qa.testdata.TestData.month;
import static guru.qa.testdata.TestData.phoneNumber;
import static guru.qa.testdata.TestData.state;
import static guru.qa.testdata.TestData.subject;
import static guru.qa.testdata.TestData.userEmail;
import static guru.qa.testdata.TestData.year;

public class RegistrationTests extends TestBase {

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
