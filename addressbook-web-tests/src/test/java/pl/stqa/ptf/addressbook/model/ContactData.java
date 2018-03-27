package pl.stqa.ptf.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id;
  private final String name;
  private final String surname;
  private final String tel;
  private final String mail;
  private final String group;


  @Override
  public String toString() {
    return "ContactData{" +
            "name='" + name + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return Objects.equals(name, that.name) &&
            Objects.equals(surname, that.surname);
  }

  @Override
  public int hashCode() {

    return Objects.hash(name, surname);
  }

  public ContactData(String name, String surname, String tel, String mail, String group) {
    this.id = Integer.MAX_VALUE;
    this.name = name;
    this.surname = surname;
    this.tel = tel;
    this.mail = mail;
    this.group = group;
  }

  public ContactData(int id, String name, String surname, String tel, String mail, String group) {
    this.id = id;
    this.name = name;
    this.surname = surname;
    this.tel = tel;
    this.mail = mail;
    this.group = group;
  }

  public int getId() {
    return id;
  }

  public void setId(int id) {
    this.id = id;

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
