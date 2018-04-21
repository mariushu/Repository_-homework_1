package pl.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("Martin", "Grey", "555 555 555 ", "test1@gmail.com", "[none]"));
    }
  }


  @Test
  public void testContactModification() {

    List<ContactData> before = app.contact().list();
    int contactToModify = before.size() - 1;
    ContactData contact = new ContactData(before.get(contactToModify).getId(),"Martin01", "Grey02", "111 111 111", "test2@gmial.com", null);
    app.contact().modify(contactToModify, contact);
    List<ContactData> after = app.contact().list();


    before.remove(contactToModify);
    before.add(contact);

    Assert.assertEquals(after.size(), before.size());
    Comparator<? super ContactData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byID);
    after.sort(byID);
    System.out.println(before);
    System.out.println(after);
    Assert.assertEquals(before, after);
  }



}
