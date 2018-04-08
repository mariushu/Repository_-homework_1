package pl.stqa.ptf.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.util.Comparator;
import java.util.List;

public class ContactCreationTest extends TestBase{





    @Test(enabled = false)
    public void testContactCreation() {
        List<ContactData> before = app.getContactHelper().getContactList();
        ContactData contact = new ContactData("Martin","Grey", null, null,"[none]");
        app.getContactHelper().createContact(contact);
        //app.getContactHelper().returnToHomePage();

        //app.getContactHelper().initContactCreation();
       // app.getContactHelper().fillContactForm(new ContactData("Martin", "Grey", "555 555 555 ", "test1@gmail.com", "[none]"), true);
        //app.getContactHelper().submitContactCreation();

        List<ContactData> after = app.getContactHelper().getContactList();

        Assert.assertEquals(after.size(), before.size() + 1);




        contact.setId(after.stream().max((o1, o2) -> Integer.compare(o1.getId(), o2.getId())).get().getId());
        before.add(contact);
        Comparator<? super ContactData> byID = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byID);
        after.sort(byID);


        Assert.assertEquals(before, after);



    }


}
