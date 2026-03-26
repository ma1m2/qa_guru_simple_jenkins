package guru.qa.tests;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

public class SkippedTests {

  @Test
  @Disabled
  public void positiveTest0() {
    Assertions.assertTrue(true);
  }

  @Test
  @Disabled
  public void positiveTest1() {
    Assertions.assertTrue(true);
  }

  @Test
  @Disabled
  public void positiveTest2() {
    Assertions.assertTrue(true);
  }

  @Test
  @Disabled
  public void positiveTest3() {
    Assertions.assertTrue(true);
  }

  @Test
  @Disabled
  public void positiveTest4() {
    Assertions.assertTrue(true);
  }

}
