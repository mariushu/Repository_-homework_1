package pl.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {


  @Test
  public void testContactModification() {
    app.getContactHelper().goToHomePage();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Martin", "Grey", "555 555 555 ", "test1@gmail.com", "[none]"));
    }
    List<ContactData> before = app.getContactHelper().getContactList();
    int contactToModify = before.size() - 1;
   //app.getContactHelper().selectContact(before.size() - 1);

    app.getContactHelper().initContactModification(contactToModify);
    ContactData contact = new ContactData(before.get(contactToModify).getId(),"Martin01", "Grey02", "111 111 111", "test2@gmial.com", null);
    app.getContactHelper().fillContactForm(contact, false);
    app.getContactHelper().submitContactModification();
    app.getContactHelper().returnToHomePage();
    List<ContactData> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size());

    before.remove(contactToModify);
    before.add(contact);

    Comparator<? super ContactData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byID);
    after.sort(byID);
    Assert.assertEquals(before, after);
  }

}
