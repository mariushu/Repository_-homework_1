package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.io.File;

public class ContactCreationTest extends TestBase{





    @Test
    public void testContactCreation() {
        File photo = new File("src/test/resources/stru.png");
        //Contacts before = app.contact().all();


        ContactData contact = new ContactData()
                .withFirstname("Martin")
                .withLastname("Grey")
                .withTel("555 555 555")
                .withHomePhone("+52 00 000 00")
                .withMobilePhone("666111333")
                .withWorkPhone("(63) 67733994")
                .withAddress("Polna")
                .withMail("emial@gmail.com")
                .withPhoto(photo)
                .withGroup("[none]");

        app.contact().create(contact);
        /*assertThat(app.contact().count(), equalTo(before.size() + 1));
        Contacts after = app.contact().all();

        assertThat(after, equalTo(
                before.withAdded(contact.withId(after.stream().mapToInt((c) -> c.getId()).max().getAsInt()))));*/


    }
        @Test (enabled = false) // test na znalezienie sciezki bezwzglednej
    public void testCurrentDir(){
        File currentDir = new File (".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/test/resources/stru.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
        }

}
