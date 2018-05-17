package pl.stqa.ptf.addressbook.appmenager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import pl.stqa.ptf.addressbook.model.ContactData;
import pl.stqa.ptf.addressbook.model.Contacts;
import pl.stqa.ptf.addressbook.model.GroupData;

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
    //attach(By.name("photo"), contactData.getPhoto());
    type(By.name("mobile"), contactData.getTel());
    type(By.name("email"), contactData.getMail());
    type(By.name("address"), contactData.getAddress());


    if (creation) {
      if (contactData.getGroups().size() > 0) {
        Assert.assertTrue(contactData.getGroups().size() == 1);
        new Select(wd.findElement(By.name("new_group"))).selectByVisibleText(contactData.getGroups().iterator().next().getName());
      }
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
    click(By.xpath("//table[@id='maintable']/tbody/tr[2]/td[8]/a/img"));
    //wd.findElement(By.cssSelector("a[href*='edit.php?id=" + id + "']")).click();


    /*WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(7).findElement(By.tagName("a")).click();*/


  }

  public void selectContactToDetailsById(int id) {
    WebElement checkbox = wd.findElement(By.cssSelector(String.format("input[value='%s']", id)));
    WebElement row = checkbox.findElement(By.xpath("./../.."));
    List<WebElement> cells = row.findElements(By.tagName("td"));
    cells.get(6).findElement(By.tagName("a")).click();
    //wd.findElement(By.cssSelector("a[href*='view.php?id=" + id + "']")).click();

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
  public void selectContactToDelete() {
    if (!wd.findElement(By.name("selected[]")).isSelected()) {
      click(By.name("selected[]"));
    }
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
//    selectContactById(contact.getId());
    initContactModificationById(contact.getId());
    fillContactForm(contact, false);
    submitContactModification();
    contactCache = null;
    returnToHomePage();
  }


  public void delete(ContactData contact) {
    selectContactToDelete();
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
      int id = Integer.parseInt(cells.get(0).findElement(By.tagName("input")).getAttribute("value"));

      String lastName = cells.get(1).getText();

      String firstName = cells.get(2).getText();

      String address = cells.get(3).getText();

      String allMails = cells.get(4).getText();

      String allPhones = cells.get(5).getText();




      contactCache.add(new ContactData().withId(id).withFirstname(firstName).withLastname(lastName)
              .withAddress(address).withAllPhones(allPhones).withAllMails(allMails));
      //.withMail(mail).withMail2(mail2).withMail3(mail3)
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
    String mail = wd.findElement(By.name("email")).getAttribute("value");
    String mail2 = wd.findElement(By.name("email2")).getAttribute("value");
    String email3 = wd.findElement(By.name("email3")).getAttribute("value");
    String address = wd.findElement(By.name("address")).getAttribute("value");

    wd.navigate().back();
    return new ContactData().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
            .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work)
            .withMail(mail).withMail2(mail2).withMail3(email3).withAddress(address);
  }


  public String infoFromDetailsPage(ContactData contact) {
    selectContactToDetailsById(contact.getId());
    String details = wd.findElement(By.id("content")).getText()
            .replaceAll("H: ", "")
            .replaceAll("M: ", "")
            .replaceAll("W: ", "")
            .replaceAll("\n", " ")
            .replaceAll("   ", " ")
            .replaceAll("  ", " ");
    return details;
  }

  public void addToGroup(ContactData contact, GroupData group) {
    selectContactById(contact.getId());
    new Select(wd.findElement(By.name("to_group"))).selectByValue(Integer.toString(group.getId()));
    click(By.name("add"));
    homePage();
  }

  public void deleteFromGroup(ContactData contact, GroupData group) {
    new Select(wd.findElement(By.name("group"))).selectByValue(Integer.toString(group.getId()));
    selectContactById(contact.getId());
    click(By.name("remove"));
    homePage();
  }

}