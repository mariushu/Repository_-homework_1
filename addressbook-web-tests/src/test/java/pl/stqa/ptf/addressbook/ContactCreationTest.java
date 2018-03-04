package pl.stqa.ptf.addressbook;

import org.testng.annotations.Test;

public class ContactCreationTest extends TestBase{





    @Test
    public void testContactCreation() {

        initContactCreation();
        fillContactForm(new ContactData("Martin", "Grey", "555 555 555 ", "test1@gmail.com"));
        submitContactCreation();
    }


}
