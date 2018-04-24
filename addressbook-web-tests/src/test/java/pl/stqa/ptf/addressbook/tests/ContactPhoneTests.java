package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

public class ContactPhoneTests extends TestBase {

  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withName("Martin").withSurname("Grey").withTel("555 555 555").withMail("emial@gmail.com").withGroup("[none]"));
    }
  }


  @Test
  public void testContactPhones() {
    app.contact().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData ContactInfoFromEditForm = app.contact().infoFromEditForm(contact);


  }
}
