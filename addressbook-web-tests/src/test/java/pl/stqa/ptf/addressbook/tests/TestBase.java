package pl.stqa.ptf.addressbook.tests;

import org.openqa.selenium.remote.BrowserType;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.stqa.ptf.addressbook.appmenager.ApplicationMenager;

public class TestBase {

  protected static final ApplicationMenager app = new ApplicationMenager(BrowserType.CHROME);

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
