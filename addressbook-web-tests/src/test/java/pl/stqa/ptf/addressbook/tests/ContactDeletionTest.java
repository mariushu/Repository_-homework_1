package pl.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.util.Set;


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

      Set<ContactData> before = app.contact().all();
      ContactData deletedContact = before.iterator().next();

      app.contact().delete(deletedContact);
      Set<ContactData> after = app.contact().all();

      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(deletedContact);
      Assert.assertEquals(before, after);
    }



}


