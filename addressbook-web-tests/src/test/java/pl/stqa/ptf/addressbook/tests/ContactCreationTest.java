package pl.stqa.ptf.addressbook.tests;

import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;
import pl.stqa.ptf.addressbook.model.Groups;

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
        try (BufferedReader reader = new BufferedReader(new FileReader(new File("src/tests/resources/contacts.xml")))) {
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
        }



    /*@Test (dataProvider = "validContactsFromXml")
    public void testContactCreation (ContactData contact) throws IOException {

        Contacts before = app.db().contacts();

        app.contact().create(contact);

        Contacts after = app.db().contacts();

        assertThat(after.size(), equalTo(before.size() + 1));
    }*/

    @Test
    public void testContactCreation () {
        Groups groups = app.db().groups();
        ContactData newContact = new ContactData().withFirstname("Martin").withLastname("Grey").withAddress("Lwowksa").withHomePhone("345345345")
                .withMobilePhone("12345").withWorkPhone("12345").withMail("cos@wp.pl")
                .inGroup(groups.iterator().next());
        app.contact().homePage();
        app.contact().initContactCreation();
        app.contact().fillContactForm(newContact, true);
        app.contact().submitContactCreation();
        app.contact().returnToHomePage();


    }



    @Test (enabled = false) // tests na znalezienie sciezki bezwzglednej
    public void testCurrentDir(){
        File currentDir = new File (".");
        System.out.println(currentDir.getAbsolutePath());
        File photo = new File("src/tests/resources/stru.png");
        System.out.println(photo.getAbsolutePath());
        System.out.println(photo.exists());
        }

}
