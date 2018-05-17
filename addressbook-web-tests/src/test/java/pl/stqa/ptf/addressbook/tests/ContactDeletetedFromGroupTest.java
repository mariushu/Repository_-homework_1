package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;
import pl.stqa.ptf.addressbook.model.GroupData;
import pl.stqa.ptf.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactDeletetedFromGroupTest extends TestBase {
  @BeforeMethod()
  public void ensurePreconditions() {

    if  (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test1"));
    }

    if (app.db().contacts().size() == 0) {
      app.contact().homePage();
      app.contact().create(new ContactData().withFirstname("firstname").withLastname("lastname").withAddress("address").withHomePhone("phone")
              .withMobilePhone("12345").withWorkPhone("12345").withMail("email"));
    }
  }

  @Test
  public void testContactDeletedFromGroup() {
    GroupData groupToDeleteFrom;
    app.contact().homePage();

    ContactData contact = app.db().contacts().iterator().next();
    Groups groupsBefore = contact.getGroups();
    if (groupsBefore.size() == 0) {
      groupToDeleteFrom = app.db().groups().iterator().next();
      app.contact().addToGroup(contact, groupToDeleteFrom);
      contact = app.db().contactById(contact.getId());
      groupsBefore = contact.getGroups();
    } else {
      groupToDeleteFrom = groupsBefore.iterator().next();
    }
    app.contact().deleteFromGroup(contact, groupToDeleteFrom);
    contact = app.db().contactById(contact.getId());
    Groups groupsAfter = contact.getGroups();
    assertThat(groupsAfter, equalTo(groupsBefore.withOut(groupToDeleteFrom)));
  }
}
