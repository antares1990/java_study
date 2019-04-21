package ru.stqa.study.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;

import java.io.File;
import java.util.Objects;

@XStreamAlias("contact")

public class ContactAdd {
    @XStreamOmitField
    private int id = Integer.MAX_VALUE;
    @Expose
    private String firstname;
    @Expose
    private String middlename;
    @Expose
    private String lastname;
    @Expose
    private String nickname;
    @Expose
    private String email;
    @Expose
    private String groups;
    @Expose
    private String homePhone;
    @Expose
    private String mobilePhone;
    @Expose
    private String workPhone;
    @Expose
    private String allPhones;
    @Expose
    private String address;
    @Expose
    private String email2;
    @Expose
    private String email3;
    @Expose
    private String allemails;

    public ContactAdd withAllemails(String allemails) {
        this.allemails = allemails;
        return this;
    }

    public String getAllemails() {
        return allemails;
    }

    public ContactAdd withEmail2(String email2) {
        this.email2 = email2;
        return this;
    }

    public ContactAdd withEmail3(String email3) {
        this.email3 = email3;
        return this;
    }

    public String getEmail2() {
        return email2;
    }

    public String getEmail3() {
        return email3;
    }

    public ContactAdd withAddress(String address) {
        this.address = address;
        return this;
    }

    public String getAddress() {
        return address;
    }

    private File photo;

    public File getPhoto() {
        return photo;
    }

    public ContactAdd withPhoto(File photo) {
        this.photo = photo;
        return this;
    }

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

    public ContactAdd withMobilePhone(String mobilePhone) {
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
