package pl.stqa.ptf.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.ptf.addressbook.model.ContactData;
public class ContactHelper extends HelperBase {


  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
  }

  public void fillContactForm(ContactData contactData, boolean creation) {
    type(By.name("firstname"), contactData.getName());
    type(By.name("lastname"), contactData.getSurname());
    type(By.name("mobile"), contactData.getTel());
    type(By.name("email"), contactData.getMail());

    if (creation) {
      new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroup());
    } else {
      Assert.assertFalse(isElementPresent(By.name("new_group")));
    }

  }

  public void initContactCreation() {
    click(By.linkText("add new"));
  }

  public void initContactModification() {
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }


  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void goToHomePage() {
    click(By.linkText("home"));

  }

  public void selectContactToDelete() {
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      click(By.name("selected[]"));}

  }

  public void deleteOnHome() {
    click(By.xpath("//div/div[4]/form[2]/div[2]/input"));

  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void createContact(ContactData cont) {
    initContactCreation();
    fillContactForm(cont, true);
    submitContactCreation();
    returnToHomePage();

  }


  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));

  }
}

