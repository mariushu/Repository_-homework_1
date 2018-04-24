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
    type(By.name("firstname"), contactData.getFirstname());
    type(By.name("lastname"), contactData.getLastname());
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
    //wd.findElement(By.cssSelector("a[href*='edit.php?id=" + id + "']")).click();

    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();


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
    List<WebElement> rows = wd.findElements(By.cssSelector("tr[name='entry']"));
    for (WebElement row : rows) {
      List<WebElement> cells = row.findElements(By.tagName("td"));
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("id"));

      String lastName = cells.get(1).getText();

      String firstName = cells.get(2).getText();

      String address = cells.get(3).getText();

      String email = cells.get(4).getText();

      String[] phones = cells.get(5).getText().split("\n");
      contactCache.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName)
              .withAddress(address).withHomePhone(phones[0]).withMobilePhone(phones[1]).withWorkPhone(phones[2])
              .withMail(email));
    }
    return contactCache;
  }

  public ContactData infoFromEditForm(ContactData contact) {
    initContactModificationById(contact.getId());
    String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
    String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
    String home = wd.findElement(By.name("home")).getAttribute("value");
    String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
    String work = wd.findElement(By.name("work")).getAttribute("value");

    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work);

  }
}