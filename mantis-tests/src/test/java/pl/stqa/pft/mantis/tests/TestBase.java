package pl.stqa.pft.mantis.tests;

import org.openqa.selenium.remote.BrowserType;

import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;
import pl.stqa.pft.mantis.appmanager.ApplicationMenager;


public class TestBase {

  protected static final ApplicationMenager app
          = new ApplicationMenager(System.getProperty("browser", BrowserType.CHROME));

  @BeforeSuite
  public void setUp() throws Exception {
    app.init();
  }

  @AfterSuite
  public void tearDown() {
    app.stop();
  }

}
