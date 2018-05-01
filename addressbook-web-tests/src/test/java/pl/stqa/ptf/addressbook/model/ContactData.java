package pl.stqa.ptf.addressbook.model;

import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

public class ContactData {
  @XStreamOmitField
  private int id = Integer.MAX_VALUE;
  private String name;
  private String surname;
  private String tel;
  private String mail;
  private String mail2;
  private String mail3;
  private String allMails;
  private String group;
  private String homePhone;
  private String mobilePhone;
  private String workPhone;
  private String address;
  private String allPhones;
  private File photo;

  public File getPhoto() {
    return photo;
  }

  public ContactData withPhoto(File photo) {
    this.photo = photo;
    return this;
  }

  public String getAllPhones() {
    return allPhones;
  }

  public ContactData withAllPhones(String allPhones) {
    this.allPhones = allPhones;
    return this;
  }

  public String getHomePhone () {
    return homePhone;
  }

  public ContactData withHomePhone (String homePhone){
    this.homePhone = homePhone;
    return this;
  }

  public String getMobilePhone () {
    return mobilePhone;
  }

  public ContactData withMobilePhone (String mobilePhone){
    this.mobilePhone = mobilePhone;
    return this;
  }

  public String getWorkPhone () {
    return workPhone;
  }

  public ContactData withWorkPhone (String workPhone){
    this.workPhone = workPhone;
    return this;
  }
  public String getAddress () {
    return address;
  }

  public ContactData withAddress (String address){
    this.address = address;
    return this;
  }


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

  public ContactData withFirstname(String name) {
    this.name = name;
    return this;
  }

  public ContactData withLastname(String surname) {
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

    public String getMail2 () {
    return mail2;
  }
  public ContactData withMail2(String mail2) {
    this.mail2 = mail2;
    return this;
  }
    public String getMail3 () {
    return mail3;
  }
  public ContactData withMail3(String mail3) {
    this.mail3 = mail3;
    return this;
  }

  public String getAllMails() {
    return allMails;
  }
  public ContactData withAllMail(String allMails) {
    this.allMails = allMails;
    return this;
  }

  public ContactData withGroup(String group) {

    this.group = group;
    return this;
  }

  public String getFirstname() {
    return name;
  }

  public String getLastname() {
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
            ", tel='" + tel + '\'' +
            ", mail='" + mail + '\'' +
            ", mail2='" + mail2 + '\'' +
            ", mail3='" + mail3 + '\'' +
            ", allMails='" + allMails + '\'' +
            ", group='" + group + '\'' +
            ", homePhone='" + homePhone + '\'' +
            ", mobilePhone='" + mobilePhone + '\'' +
            ", workPhone='" + workPhone + '\'' +
            ", address='" + address + '\'' +
            ", allPhones='" + allPhones + '\'' +
            '}';
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    ContactData that = (ContactData) o;
    return id == that.id &&
            Objects.equals(name, that.name) &&
            Objects.equals(surname, that.surname) &&
            Objects.equals(tel, that.tel) &&
            Objects.equals(mail, that.mail) &&
            Objects.equals(mail2, that.mail2) &&
            Objects.equals(mail3, that.mail3) &&
            Objects.equals(allMails, that.allMails) &&
            Objects.equals(group, that.group) &&
            Objects.equals(homePhone, that.homePhone) &&
            Objects.equals(mobilePhone, that.mobilePhone) &&
            Objects.equals(workPhone, that.workPhone) &&
            Objects.equals(address, that.address) &&

            Objects.equals(allPhones, that.allPhones);
  }

  @Override
  public int hashCode() {

    return Objects.hash(id, name, surname, tel, mail, mail2, mail3, allMails, group, homePhone, mobilePhone, workPhone, address,  allPhones);
  }

}