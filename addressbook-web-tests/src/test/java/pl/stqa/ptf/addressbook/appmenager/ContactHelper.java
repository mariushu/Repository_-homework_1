package pl.stqa.ptf.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import pl.stqa.ptf.addressbook.model.ContactData;

public class ContactHelper extends HelperBase {


  public ContactHelper(ChromeDriver wd) {

    super(wd);
  }
  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getSurname());
    type(By.name("mobile"), contactData.getTel());
    type(By.name("email"), contactData.getMail());
  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }
}

