package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;
import pl.stqa.ptf.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactCreationTest extends TestBase{





    @Test
    public void testContactCreation() {
        Contacts before = app.contact().all();
        ContactData contact = new ContactData();

        contact.withFirstname("Martin");
        contact.withLastname("Grey");
        contact.withTel("555 555 555");
        contact.withHomePhone("+52 00 000 00");
        contact.withMobilePhone("666111333");
        contact.withWorkPhone("(63) 67733994");
        contact.withAddress("Polna 12");
        contact.withMail("emial@gmail.com");
        contact.withGroup("[none]");

        app.contact().create(contact);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();




        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));


    }


}
