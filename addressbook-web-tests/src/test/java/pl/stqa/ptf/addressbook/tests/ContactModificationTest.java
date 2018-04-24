package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;
import pl.stqa.ptf.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Martin").withLastname("Grey").withTel("555 555 555").withMail("emial@gmail.com").withGroup("[none]"));
    }
  }


  @Test
  public void testContactModification() {

    Contacts before = app.contact().all();
    ContactData modifiedContact = before.iterator().next();

    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("Martin01").withLastname("Grey02").withMail("emial23@gmail.com");
    app.contact().modify(contact);
    assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.contact().all();
    assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));

    System.out.println(modifiedContact);
    System.out.println(contact);
  }



}
