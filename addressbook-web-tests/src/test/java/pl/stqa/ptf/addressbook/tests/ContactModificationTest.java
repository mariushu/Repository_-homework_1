package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

public class ContactModificationTest extends TestBase {


  @Test
  public void testContactModification() {
    app.getContactHelper().goToModificationPage();
    app.getContactHelper().initContactModification();
    app.getContactHelper().fillContactForm(new ContactData("Martin01", "Grey02", "111 111 111", "test12@gmail.com", null), false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();

  }

}
