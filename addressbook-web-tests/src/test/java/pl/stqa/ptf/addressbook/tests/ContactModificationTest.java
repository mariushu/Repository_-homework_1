package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;
import pl.stqa.ptf.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.equalTo;

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

    Contacts before = app.db().contacts();
    ContactData modifiedContact = before.iterator().next();
    File photo = new File("src/tests/resources/stru.png");

    ContactData contact = new ContactData()
            .withId(modifiedContact.getId()).withFirstname("Martin01").withLastname("Grey02").withPhoto(photo).withHomePhone("23232").withMobilePhone("2323232342").withWorkPhone("34345534").withMail("costamaaaa@wp.pl").withPhoto(photo);

    app.contact().modify(contact);


    Contacts after = app.db().contacts();
    assertThat(after.size(), equalTo(before.size()));


  }



}
