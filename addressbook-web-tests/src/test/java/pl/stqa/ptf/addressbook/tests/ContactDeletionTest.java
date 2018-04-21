package pl.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionTest extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.getContactHelper().goToHomePage();
    if (!app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Martin", "Grey", "555 555 555 ", "test1@gmail.com", "[none]"));
    }
  }

    @Test(enabled = false)
    public void ContactDeletionTest() {

      List<ContactData> before = app.getContactHelper().getContactList();
      app.getContactHelper().selectContact(before.size() - 1);

      //app.getContactHelper().selectContactToDelete();
      app.getContactHelper().deleteOnHome();
      app.getContactHelper().closeAlert();
      app.getContactHelper().isAlertPresent();
      List<ContactData> after = app.getContactHelper().getContactList();

      Assert.assertEquals(after.size(), before.size() - 1);

      before.remove(before.size() - 1);
      Assert.assertEquals(before, after);
    }

}


