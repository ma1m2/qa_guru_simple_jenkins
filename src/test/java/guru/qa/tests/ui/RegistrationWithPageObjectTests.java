package guru.qa.tests.ui;

import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import io.qameta.allure.Feature;

import static guru.qa.testdata.TestData.*;
import static io.qameta.allure.Allure.step;

@Feature("Registration")
@Owner("SvetaQa")
public class RegistrationWithPageObjectTests extends TestBase{

  @Test
  @Story("Pass registration")
  @DisplayName("Successful Registration")
  void successfulRegistrationTest() {
    //Arrange
    step("Open main page and navigate to form page",()->{
      registrationPage.openPage();
    });
    //Act
    step("Fill registration form",()->{
      registrationPage.typeFirstName(firstName)
              .typeLastName(lastName)
              .typeUserEmail(userEmail)
              .setGender(gender)
              .typeUserNumber(phoneNumber)
              .setDateOfBirth(day, month, year)
              .setHobby(hobbie)
              .setSubject(subject)
              .uploadPhoto(fileName)
              .typeCurrentAddress(currentAddress)
              .setStateAndCity(state, city);

    });
    //Assert
    step("Check Modal Window with Result",()->{
      registrationPage.submitForm()
              .checkModalWindowAppears()
              .checkOutput("Student Name",firstName + " " + lastName)
              .checkOutput("Student Email", userEmail)
              .checkOutput("Gender", gender)
              .checkOutput("Mobile", phoneNumber)
              .checkOutput("Date of Birth", day+" "+month+","+year)
              .checkOutput("Subjects", subject)
              .checkOutput("Hobbies", hobbie)
              .checkOutput("Address", currentAddress)
              .checkOutput("Picture", fileName)
              .checkOutput("State and City", state+" "+city)
              .closeModalWindow();
    });
  }

  @Test
  @Story("Failed registration")
  @DisplayName("Broken Registration")
  void brokenRegistrationTest() {
    //Arrange
    step("Open main page and navigate to form page",()->{
      registrationPage.openPage();
    });
    //Act
    step("Fill registration form",()->{
      registrationPage.typeFirstName(firstName)
              .typeLastName(lastName)
              .typeUserEmail(userEmail)
              .setGender(gender)
              .typeUserNumber(phoneNumber);

    });
    //Assert
    step("Check Modal Window with Result",()->{
      registrationPage.submitForm()
              .checkModalWindowAppears()
              .checkOutput("Student Name",firstName + " " + lastName)
              .checkOutput("Student Email", userEmail)
              .checkOutput("Gender", gender)
              .checkOutput("Mobile", phoneNumber)
              .checkOutput("Subjects", subject)
              .closeModalWindow();
    });
  }

}
