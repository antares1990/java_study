package ru.stqa.study.addressbook.model;

import java.util.Objects;

public class ContactAdd {

    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String middlename;
    private String lastname;
    private String nickname;
    private String email;
    private String groups;
    private String homePhone;
    private String mobilePhone;
    private String workPhone;
    private String allPhones;


    public ContactAdd withAllPhones(String allPhones) {
        this.allPhones = allPhones;
        return this;
    }

    public String getAllPhones() {
        return allPhones;
    }

    public String getHomePhone() { return homePhone; }

    public ContactAdd withHomePhone(String homePhone) {
        this.homePhone = homePhone;
        return this;
    }

    public String getMobilePhone() { return mobilePhone; }

    public ContactAdd withMobilePhone(String MobilePhone) {
        this.mobilePhone = mobilePhone;
        return this;
    }

    public String getWorkPhone() { return workPhone; }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactAdd that = (ContactAdd) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname);
    }

    public ContactAdd withWorkPhone(String workPhone) {
        this.workPhone = workPhone;
        return this;
    }


    @Override
    public String toString() {
        return "ContactAdd{" +
                "id='" + id + '\'' +
                ", firstname='" + firstname + '\'' +
                ", lastname='" + lastname + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }


    public ContactAdd withId(int id) {
        this.id = id;
        return this;
    }

    public ContactAdd withFirstname(String firstname) {
        this.firstname = firstname;
        return this;
    }

    public ContactAdd withMiddlename(String middlename) {
        this.middlename = middlename;
        return this;
    }

    public ContactAdd withLastname(String lastname) {
        this.lastname = lastname;
        return this;
    }

    public ContactAdd withNickname(String nickname) {
        this.nickname = nickname;
        return this;
    }

    public ContactAdd withEmail(String email) {
        this.email = email;
        return this;
    }

    public ContactAdd withGroups(String groups) {
        this.groups = groups;
        return this;
    }


    public String getFirstname() {
        return firstname;
    }

    public String getMiddlename() {
        return middlename;
    }

    public String getLastname() {
        return lastname;
    }

    public String getNickname() {
        return nickname;
    }

    public String getEmail() {
        return email;
    }

    public String getGroups() {
        return groups;
    }
}
