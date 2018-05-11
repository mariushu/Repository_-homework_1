package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;
import pl.stqa.ptf.addressbook.model.Contacts;

import java.io.File;

public class ContactModificationTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    if (app.db().contacts().size() == 0) {
      app.contact().homePage();
      app.contact().create(new ContactData().withFirstname("Martin").withLastname("Grey"));
    }
  }


  @Test
  public void testContactModification() {
    File photo = new File("src/test/resources/stru.png");
    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();

    app.contact().homePage();
    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("Martin01").withLastname("Grey02").withPhoto(photo).withHomePhone("23232").withMobilePhone("2323232342").withWorkPhone("34345534").withMail("costamaaaa@wp.pl");
    //app.contact().homePage();
    app.contact().modify(contact);
    //app.contact().homePage();
    //assertThat(app.contact().count(), equalTo(before.size()));
    Contacts after = app.db().contacts();
    //assertThat(after, equalTo(before.withOut(modifiedContact).withAdded(contact)));

    //System.out.println(modifiedContact);
    //System.out.println(contact);
  }



}
