package guru.qa.tests.ui;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import guru.qa.helpers.Attach;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import java.util.Map;

import guru.qa.pages.RegistrationPage;

import static com.codeborne.selenide.Selenide.closeWebDriver;

public class TestBase {

  RegistrationPage registrationPage = new RegistrationPage();

  @BeforeAll
  static void setUp() {
    Configuration.browserSize = System.getProperty("resolution", "1920x1080");
    Configuration.pageLoadStrategy = "eager";
    Configuration.baseUrl = System.getProperty("baseUrl", "https://demoqa.com/");
    Configuration.browser = System.getProperty("browser", "chrome");
    Configuration.browserVersion = System.getProperty("browserVersion");
    Configuration.remote = System
            .getProperty("remote","https://user1:1234@selenoid.autotests.cloud/wd/hub");
    Configuration.browserCapabilities.setCapability("selenoid:options",
            Map.of("enableVNC", true, "enableLog", true,"enableVideo", true));
  }

  @BeforeEach
  void addListener(){
    SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
  }

  @AfterEach
  void addAttachments() {
    Attach.screenshotAs("Last screenshot");
    Attach.pageSource();
    Attach.browserConsoleLogs();
    Attach.addVideo();
    closeWebDriver();
  }
}
