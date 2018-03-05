package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

public class ContactCreationTest extends TestBase{





    @Test
    public void testContactCreation() {

        app.initContactCreation();
        app.fillContactForm(new ContactData("Martin", "Grey", "555 555 555 ", "test1@gmail.com"));
        app.submitContactCreation();
    }


}
