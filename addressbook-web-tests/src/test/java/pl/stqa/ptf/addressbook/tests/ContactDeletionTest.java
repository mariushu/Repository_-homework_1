package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;


public class ContactDeletionTest extends TestBase {


    @Test
    public void ContactDeletionTest() {

      if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().createContact(new ContactData("Martin", "Grey", "555 555 555 ", "test1@gmail.com", "[none]"));
      }

      app.getContactHelper().selectContactToDelete();
      app.getContactHelper().deleteOnHome();
      app.getContactHelper().closeAlert();
      app.getContactHelper().isAlertPresent();
    }





}




