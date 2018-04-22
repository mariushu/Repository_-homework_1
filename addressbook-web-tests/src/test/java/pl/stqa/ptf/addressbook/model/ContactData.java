package pl.stqa.ptf.addressbook.model;

import java.util.Objects;

public class ContactData {
  private int id = Integer.MAX_VALUE;
  private String name;
  private String surname;
  private String tel;
  private String mail;
  private String group;


  public int getId() {
    return id;
  }

  public ContactData setId(int id) {
    this.id = id;
    return this;
  }
  public ContactData withId(int id) {
    this.id = id;
    return this;
  }

  public ContactData withName(String name) {
    this.name = name;
    return this;
  }

  public ContactData withSurname(String surname) {
    this.surname = surname;
    return this;
  }

  public ContactData withTel(String tel) {
    this.tel = tel;
    return this;
  }

  public ContactData withMail(String mail) {
    this.mail = mail;
    return this;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(name, that.name) &&
            Objects.equals(surname, that.surname);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, name, surname);
  }

  public ContactData withGroup(String group) {

    this.group = group;
    return this;
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

  @Override
  public String toString() {
    return "ContactData{" +
            "id=" + id +
            ", name='" + name + '\'' +
            ", surname='" + surname + '\'' +
            '}';
  }

}