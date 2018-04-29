package pl.stqa.ptf.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;



  public class ContactDetailsTest  extends TestBase {

    @BeforeMethod
    public void ensurePreconditions() {
      app.contact().homePage();
      if (app.contact().all().size() == 0) {
        app.contact().create(new ContactData()
                .withFirstname("Martin").withLastname("Grey").withTel("555 555 555").withMail("emial@gmail.com").withGroup("[none]"));
      }
    }



    @Test

    public void testContactDetails() {
      app.contact().homePage();
      ContactData contact = app.contact().all().iterator().next();
      ContactData contactInfoFromEditForm = app.contact().infoFromEditForm(contact);
      String contactInfoFromDetailsPage = app.contact().infoFromDetailsPage(contact);
      assertThat(mergeAllData(contactInfoFromEditForm), equalTo(contactInfoFromDetailsPage));

    }



    private String mergeAllData(ContactData contact) {
      return Arrays.asList(contact.getFirstname(), contact.getLastname(), contact.getAddress(),
              contact.getHomePhone(), contact.getMobilePhone(), contact.getWorkPhone(),
              contact.getMail(), contact.getMail2(), contact.getMail3())
              .stream()
              .filter((s) -> !s.equals(""))
              .collect(Collectors.joining(" "));
    }
  }






