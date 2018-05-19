package pl.stqa.pft.mantis.appmanager;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.BrowserType;

import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Objects;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class ApplicationMenager {

  private final Properties properties;
  WebDriver wd;
  private String browser;


  public ApplicationMenager(String browser) {
    this.browser = browser;

    properties = new Properties();

  }

  public void init() throws IOException {
    String target = System.getProperty("target", "local");
    properties.load(new FileReader(new File(String.format("src/tests/resources/%s.properties", target))));

    if (Objects.equals(browser, BrowserType.CHROME)) {
      wd = new ChromeDriver();
    } else if (Objects.equals(browser, BrowserType.IE)) {
      wd = new InternetExplorerDriver();
    } else if (Objects.equals(browser, BrowserType.FIREFOX)) {
      wd = new FirefoxDriver();
    }

    wd.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    wd.get(properties.getProperty("web.baseUrl"));

  }

  public void stop() {
    wd.quit();
  }


  }

