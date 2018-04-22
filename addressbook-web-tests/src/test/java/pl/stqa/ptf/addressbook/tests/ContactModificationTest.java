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
      app.contact().create(new ContactData().withName("Martin").withSurname("Grey"));
    }
  }


  @Test
  public void testContactModification() {

    List<ContactData> before = app.contact().list();
    int contactToModify = before.size() - 1;
    ContactData contact = new ContactData()
            .withId(before.get(contactToModify).getId()).withName("Martin01").withSurname("Grey02");
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
