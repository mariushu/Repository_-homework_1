package pl.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePage();
    if (app.contact().list().size() == 0) {
      app.contact().create(new ContactData("Martin", "Grey", "555 555 555 ", "test1@gmail.com", "[none]"));
    }
  }

    @Test
    public void ContactDeletionTest() {

      List<ContactData> before = app.contact().list();
      int contactToDelete = before.size() - 1;
      app.contact().delete(contactToDelete);
      List<ContactData> after = app.contact().list();

      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(contactToDelete);
      Assert.assertEquals(before, after);
    }



}


