package pl.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.util.List;


public class ContactDeletionTest extends TestBase {


    @Test
    public void ContactDeletionTest() {

      if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Martin", "Grey", null, null, null));
      }

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


