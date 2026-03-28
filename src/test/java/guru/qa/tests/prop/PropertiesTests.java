package guru.qa.tests.prop;

import org.junit.jupiter.api.Test;

public class PropertiesTests {
// ./gradlew clean test -Dname=SvetaQa -Dbrowser=firafox -Denvironment=prod
  @Test
  public void propertyNameTest() {
    String name = System.getProperty("name");
    System.out.println("### My name is " + name);
  }

  @Test
  public void propertyEnvironmentTest() {
    String environment = System.getProperty("environment");
    System.out.println("### Environment is " + environment);
  }

  @Test
  public void propertyBrowserTest() {
    String browser = System.getProperty("browser", "chrome");
    System.out.println("### Browser is " + browser);
  }

}
