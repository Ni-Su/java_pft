package ru.stqa.pft.addressbook.model;

import java.util.Objects;

public class ContactData {
    private int id;
    private String firstname;
    private String lastname;
    private String group;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;


    public String getFirstname() { return firstname; }

    public String getLastname() { return lastname   ; }

    public String getGroup() { return group; }
    public int getId () {
         return id; }

    public String getHomePhone () {
        return homePhone;
    }

    public String getMobilePhone () {
        return mobilePhone;
    }

    public String getWorkPhone () {
        return workPhone;
    }

    public ContactData withId (int id) {
        this.id = id;
        return this;
    }



    public ContactData withFirstName(String firstname) {
        this.firstname = firstname;
        return  this;
    }
    public ContactData withLastName(String lastName) {
        this.firstname = lastName;
        return  this;
    }
    public ContactData withGroup(String group) {
        this.firstname = group;
        return  this;
    }
    public ContactData withHomePhone (String homePhone) {
        this.homePhone = homePhone;
        return this;
    }
    public ContactData withMobilePhone (String mobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }
    public ContactData withWorkPhone (String workPhone) {
        this.workPhone = workPhone;
        return this;
    }
    @Override
    public boolean equals (Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactData that = (ContactData) o;
        return id == that.id && Objects.equals(firstname, that.firstname);
    }
    @Override
    public int hashCode () {
        return Objects.hash(id, firstname);
    }
}
