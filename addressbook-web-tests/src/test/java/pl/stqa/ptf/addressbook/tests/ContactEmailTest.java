package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactEmailTest  extends TestBase{



  @BeforeMethod
  public void ensurePreconditions() {
    app.contact().homePage();
    if (app.contact().all().size() == 0) {
      app.contact().create(new ContactData()
              .withFirstname("Martin").withLastname("Grey").withTel("555 555 555").withMail("emial@gmail.com"));//.withGroup("[none]"));
    }
  }


  @Test
  public void testContactEmails() {
    app.contact().homePage();
    ContactData contact = app.contact().all().iterator().next();
    ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
    assertThat(contact.getAllMails(), equalTo(mergeEmails(contactInfoFromEditForm)));

    System.out.println(contact.getAllMails());


  }

  private String mergeEmails(ContactData contact) {
    return Arrays.asList(contact.getMail(), contact.getMail2(), contact.getMail3())
            .stream().filter((s) -> ! s.equals(""))
            .map(ContactEmailTest::cleaned)
            .collect(Collectors.joining("\n"));
  }
  public static String cleaned(String mail) {
    return mail.replaceAll("\\s", "").replaceAll("[-()]", "");
  }


}

