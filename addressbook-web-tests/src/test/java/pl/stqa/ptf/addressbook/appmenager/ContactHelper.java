package pl.stqa.ptf.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.ptf.addressbook.model.ContactData;
import pl.stqa.ptf.addressbook.model.Contacts;

import java.util.List;

public class ContactHelper extends HelperBase {


  //private int contactToModify;

  public ContactHelper(WebDriver wd) {

    super(wd);
  }

  public void submitContactCreation() {
    click(By.xpath("//div[@id='content']/form/input[21]"));
    //click(By.name("submit"));
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



  public void initContactModificationById(int id) {
   //WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value=")))


    //wd.findElements(By.xpath("//div/div[4]/form[2]/table/tbody/tr/td[8]/a/img"));
    //wd.findElements(By.cssSelector("img[alt='Edit']")).get(index).click();
    //click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));

    wd.findElement(By.cssSelector("a[href*='edit.php?id=" + id + "']")).click();

  }

  public void submitContactModification() {
    click(By.xpath("//div[@id='content']/form[1]/input[22]"));
  }


  public void returnToHomePage() {
    click(By.linkText("home page"));
  }

  public void homePage() {
    click(By.linkText("home"));

  }


  public void selectContactById(int id) {
    wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
  }

  public void deleteOnHome() {
    click(By.xpath("//div/div[4]/form[2]/div[2]/input"));

  }

  public void closeAlert() {
    wd.switchTo().alert().accept();
  }

  public void create(ContactData contact) {
    initContactCreation();
    fillContactForm(contact, true);
    submitContactCreation();
    contactCache = null;
    returnToHomePage();

  }
  public void modify(ContactData contact) {
    //selectContactById(contact.getId());
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }



  public void delete(ContactData contact) {
    selectContactById(contact.getId());
    deleteOnHome();
    closeAlert();
    contactCache = null;
    isAlertPresent();

  }

  public boolean isThereAContact() {
    return isElementPresent(By.name("selected[]"));

  }
  public int count() {
    return wd.findElements(By.name("selected[]")).size();

  }
  private Contacts contactCache = null;

  public Contacts all() {
    if (contactCache != null) {
      return new Contacts(contactCache);
    }

    contactCache = new Contacts();
    List<WebElement> elements = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement element : elements) {

      String name = element.findElement(By.xpath("td[3]")).getText();
      String surname = element.findElement(By.xpath("td[2]")).getText();
      int id = Integer.parseInt(element.findElement(By.cssSelector("td.center>input")).getAttribute("id"));
      contactCache.add(new ContactData().withId(id).withName(name).withSurname(surname));
    }
    return new Contacts(contactCache);
  }


}
