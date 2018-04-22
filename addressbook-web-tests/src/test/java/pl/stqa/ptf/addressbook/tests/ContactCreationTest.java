package pl.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.util.Set;

public class ContactCreationTest extends TestBase{





    @Test
    public void testContactCreation() {
        Set<ContactData> before = app.contact().all();
        ContactData contact = new ContactData();

        contact.withName("Martin");
        contact.withSurname("Grey");
        contact.withTel("555 555 555");
        contact.withMail("emial@gmail.com");
        contact.withGroup("[none]");

        app.contact().create(contact);
        Set<ContactData> after = app.contact().all();

        Assert.assertEquals(after.size(), before.size() + 1);

        contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt());
        before.add(contact);

        Assert.assertEquals(before, after);



    }


}
