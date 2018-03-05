package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import pl.stqa.ptf.addressbook.appmenager.ApplicationMenager;

public class TestBase {

  protected final ApplicationMenager app = new ApplicationMenager();

  @BeforeMethod
  public void setUp() throws Exception {
    app.init();
  }

  @AfterMethod
  public void tearDown() {
    app.stop();
  }

}
