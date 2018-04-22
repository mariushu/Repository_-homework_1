package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;
import pl.stqa.ptf.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;


public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData().withName("Martin").withSurname("Grey"));
    }
  }

    @Test
    public void ContactDeletionTest() {

      Contacts before = app.contact().all();
      ContactData deletedContact = before.iterator().next();

      app.contact().delete(deletedContact);
      Contacts after = app.contact().all();

      assertEquals(after.size(), before.size() - 1);


      assertThat(after, equalTo(before.withOut(deletedContact)));

    }



}


