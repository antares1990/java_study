package ru.stqa.study.addressbook.model;

import com.google.gson.annotations.Expose;
import com.thoughtworks.xstream.annotations.XStreamAlias;
import com.thoughtworks.xstream.annotations.XStreamOmitField;
import org.hibernate.annotations.Type;

import javax.persistence.*;
import java.io.File;
import java.util.Objects;

@Entity
@Table(name = "addressbook")
@XStreamAlias("contact")

public class ContactAdd {
    @XStreamOmitField
    @Id
    @Column(name = "id")
    private int id = Integer.MAX_VALUE;
    @Expose
    @Column(name = "firstname")
    private String firstname;
    @Expose
    @Column(name = "middlename")
    private String middlename;
    @Expose
    @Column(name = "lastname")
    private String lastname;
    @Expose
    @Column(name = "nickname")
    private String nickname;
    @Expose
    @Column(name = "email")
    @Type(type = "text")
    private String email;
    @Expose
    @Transient
    private String groups;
    @Expose
    @Column(name = "home")
    @Type(type = "text")
    private String homePhone;
    @Expose
    @Column(name = "mobile")
    @Type(type = "text")
    private String mobilePhone;
    @Expose
    @Column(name = "work")
    @Type(type = "text")
    private String workPhone;
    @Expose
    @Transient
    private String allPhones;
    @Expose
    @Column(name = "address")
    @Type(type = "text")
    private String address;
    @Expose
    @Column(name = "email2")
    @Type(type = "text")
    private String email2;
    @Expose
    @Column(name = "email3")
    @Type(type = "text")
    private String email3;
    @Expose
    @Transient
    private String allemails;
    @Column(name = "photo")
    @Type(type = "text")
    private String photo;

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


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactAdd that = (ContactAdd) o;
        return id == that.id &&
                Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname) &&
                Objects.equals(homePhone, that.homePhone) &&
                Objects.equals(mobilePhone, that.mobilePhone) &&
                Objects.equals(workPhone, that.workPhone) &&
                Objects.equals(address, that.address);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, firstname, lastname, homePhone, mobilePhone, workPhone, address);
    }

    public File getPhoto() {
        return new File(photo);
    }

    public ContactAdd withPhoto(File photo) {
        this.photo = photo.getPath();
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
