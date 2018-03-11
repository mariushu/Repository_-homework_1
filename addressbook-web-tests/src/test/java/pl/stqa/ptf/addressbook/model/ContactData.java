package pl.stqa.ptf.addressbook.model;

public class ContactData {
  private final String name;
  private final String surname;
  private final String tel;
  private final String mail;
  private String group;

  public ContactData(String name, String surname, String tel, String mail, String group) {
    this.name = name;
    this.surname = surname;
    this.tel = tel;
    this.mail = mail;
    this.group = group;
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

  public String getGroup() {
    return group;
  }

}
