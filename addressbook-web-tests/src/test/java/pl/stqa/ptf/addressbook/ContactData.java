package pl.stqa.ptf.addressbook;

public class ContactData {
  private final String name;
  private final String surname;
  private final String tel;
  private final String mail;

  public ContactData(String name, String surname, String tel, String mail) {
    this.name = name;
    this.surname = surname;
    this.tel = tel;
    this.mail = mail;
  }

  public String getName() {
    return name;
  }

  public String getSurname() {
    return surname;
  }

  public String getTel() {
    return tel;
  }

  public String getMail() {
    return mail;
  }
}
