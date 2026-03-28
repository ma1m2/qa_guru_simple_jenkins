package guru.qa.tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import java.util.Map;

import guru.qa.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

  RegistrationPage registrationPage = new RegistrationPage();

  @BeforeEach
  void addListener(){
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }

  @BeforeAll
  static void setUp() {
    Configuration.browserSize = "1920x1080";
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = "https://demoqa.com/";
    Configuration.browser = "chrome";
    Configuration.browserVersion = "128.0";
    Configuration.remote = "https://user1:1234@selenoid.autotests.cloud/wd/hub";
    Configuration.browserCapabilities.setCapability("selenoid:options",
            Map.of("enableVNC", true, "enableLog", true));
  }

  @AfterEach
  void tearDown() {
    closeWebDriver();
  }

}
