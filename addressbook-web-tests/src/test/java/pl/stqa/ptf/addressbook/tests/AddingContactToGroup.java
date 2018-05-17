package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;
import pl.stqa.ptf.addressbook.model.GroupData;
import pl.stqa.ptf.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class AddingContactToGroup extends TestBase{

  @BeforeMethod()
  public void ensurePreconditions() {

    if  (app.db().groups().size() == 0) {
      app.goTo().GroupPage();
      app.group().create(new GroupData().withName("test 0"));
    }

    if (app.db().contacts().size() == 0) {
      app.contact().homePage();
      app.contact().create(new ContactData().withFirstname("Martin").withLastname("Grey").withAddress("Laskowa").withHomePhone("345345")
              .withMobilePhone("12345").withWorkPhone("12345").withMail("email@emial.com"));
    }
  }

  /*@Test
  public void testAddingContactToGroup() { create new group and add contact
    GroupData groupToAdd = new GroupData().withName("test 0").withHeader("header").withFooter("footer");
    app.goTo().GroupPage();
    app.group().create(groupToAdd);
    groupToAdd.withId(app.db().groups().stream().mapToInt((g) -> g.getId()).max().getAsInt());
    app.contact().homePage();
    ContactData contact = app.db().contacts().iterator().next();
    Groups groupsBefore = contact.getGroups();
    app.contact().addToGroup(contact, groupToAdd);
    contact = app.db().contacts().iterator().next();
    Groups groupsAfter = contact.getGroups();
    assertThat(groupsAfter, equalTo(groupsBefore.withAdded(groupToAdd)));
     }*/

  @Test
  public void testAddingContactToGroup() {
  GroupData groups;
    app.contact().homePage();

  ContactData contact = app.db().contacts().iterator().next();
  Groups groupsBefore = contact.getGroups();
    if (groupsBefore.size() == 0) {
      groups = app.db().groups().iterator().next();
    app.contact().addToGroup(contact, groups);
    contact = app.db().contactById(contact.getId());
    groupsBefore = contact.getGroups();
  }

  contact = app.db().contactById(contact.getId());
  Groups groupsAfter = contact.getGroups();
  assertThat(groupsAfter, equalTo(groupsBefore));
}


}
