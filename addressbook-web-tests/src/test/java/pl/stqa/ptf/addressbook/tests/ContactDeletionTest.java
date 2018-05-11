package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;
import pl.stqa.ptf.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;


public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {

    if (app.db().contacts().size() == 0) {
      app.contact().homePage();
      app.contact().create(new ContactData().withFirstname("Martin").withLastname("Grey"));
    }
  }

    @Test
    public void ContactDeletionTest() {

      Contacts before = app.db().contacts();
      ContactData deletedContact = before.iterator().next();
      app.contact().homePage();
      app.contact().delete(deletedContact);
      assertThat(app.contact().count(), equalTo(before.size() - 1));
      Contacts after = app.db().contacts();
      assertThat(after, equalTo(before.withOut(deletedContact)));

    }



}


