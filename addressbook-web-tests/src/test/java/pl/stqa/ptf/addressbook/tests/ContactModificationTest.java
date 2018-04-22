package pl.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.util.Set;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withName("Martin").withSurname("Grey").withTel("555 555 555").withMail("emial@gmail.com").withGroup("[none]"));
    }
  }


  @Test
  public void testContactModification() {

    Set<ContactData> before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();

    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withName("Martin01").withSurname("Grey02").withMail("emial23@gmail.com");
    app.contact().modify(contact);
    Set<ContactData> after = app.contact().all();

    Assert.assertEquals(after.size(), before.size());

    before.remove(modifiedContact);
    before.add(contact);

    System.out.println(before);
    System.out.println(after);

    Assert.assertEquals(before, after);
  }



}
