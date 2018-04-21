package pl.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase{





    @Test
    public void testContactCreation() {
        List<ContactData> before = app.contact().list();
        ContactData contact = new ContactData("Martin","Grey", null, null,"[none]");
        app.contact().create(contact);
        List<ContactData> after = app.contact().list();

        Assert.assertEquals(after.size(), before.size() + 1);


        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byID);
        after.sort(byID);


        Assert.assertEquals(before, after);



    }


}
