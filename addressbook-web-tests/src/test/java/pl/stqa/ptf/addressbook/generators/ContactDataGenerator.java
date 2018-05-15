package pl.stqa.ptf.addressbook.generators;

import com.beust.jcommander.JCommander;
import com.beust.jcommander.Parameter;
import com.beust.jcommander.ParameterException;
import com.thoughtworks.xstream.XStream;
import pl.stqa.ptf.addressbook.model.ContactData;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;

public class ContactDataGenerator {

  @Parameter(names = "-x", description = "Contact count")
  public int count;

  @Parameter(names = "-y", description = "Target file")
  public String file;

  @Parameter(names = "-z", description = "Data format")
  public String format;

  public static void main(String[] args) throws IOException {
    ContactDataGenerator generator = new ContactDataGenerator();
    JCommander jCommander = new JCommander(generator);
    try {
      jCommander.parse(args);
    } catch (ParameterException ex) {
      jCommander.usage();
      return;
    }
    generator.run();
  }

  private void run() throws IOException {
    List<ContactData> contacts = generateContacts(count);

    if (format.equals("xml")) {
      saveAsXml(contacts, new File(file));

    } else {
      System.out.println("Unregogized format" + format);
    }
  }


  private void saveAsXml(List<ContactData> contacts, File file) throws IOException {
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactData.class);

    String xml = xstream.toXML(contacts);
    try(Writer writer = new FileWriter(file)) {
      writer.write(xml);

    }
  }


  private List<ContactData> generateContacts (int count) {
    List<ContactData> contacts = new ArrayList<ContactData>();
    String[]firstname = {"Jon", "Mark"};
    String[]lastname = {"Dick", "Dark"};
    String[]address = {"Polna 14, Krakow", "Rozana 18, Lublin"};
    String[]tel = {"444 333 222", "111 333 444"};
    String[]mail = {"cos@wp.pl", "tam@tlen.pl"};
    String group = "[none]";
    File[] photos = {new File("src/test/resources/stru.png"),new File("src/test/resources/stru.png")};
    for (int i = 0; i < count; i++) {
      contacts.add(new ContactData().withFirstname(firstname[i]).withLastname(lastname[i])
      .withAddress(address[i]).withTel(tel[i]).withMail(mail[i]).withPhoto(photos[i])); //.withGroup(group)));
    }
    return contacts;
  }
}

