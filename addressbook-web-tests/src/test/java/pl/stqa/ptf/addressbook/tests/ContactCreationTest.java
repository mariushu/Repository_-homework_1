package pl.stqa.ptf.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

public class ContactCreationTest extends TestBase{

    @DataProvider
    public Iterator<Object[]> validContactsFromXml() throws IOException {
        BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
        String xml = "";
        String line = reader.readLine();
        while (line != null) {
            xml += line;
            line = reader.readLine();
        }
        XStream xstream = new XStream();
        xstream.processAnnotations(ContactData.class);
        List<ContactData> contacts = (List<ContactData>) xstream.fromXML(xml);
        return contacts.stream().map((g) -> new Object[]{g}).collect(Collectors.toList()).iterator();
    }


    @Test (dataProvider = "validContactsFromXml")
    public void testContactCreation (ContactData contacts) {
        File photo = new File("src/test/resources/stru.png");
        //Contacts before = app.contact().all();


       ContactData contact = new ContactData().withFirstname("").withLastname("").withPhoto(photo)
               .withAddress("").withTel("").withMail("").withGroup("");    //dane z pliku xml
                /*.withFirstname("Martin")
                .withLastname("Grey")
                .withTel("555 555 555")
                .withHomePhone("+52 00 000 00")
                .withMobilePhone("666111333")
                .withWorkPhone("(63) 67733994")
                .withAddress("Polna")
                .withMail("emial@gmail.com")
                .withPhoto(photo)
                .withGroup("[none]");*/

        /*app.contact().create(contacts);
        assertThat(app.contact().count(), equalTo(before.size() + 1));
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
