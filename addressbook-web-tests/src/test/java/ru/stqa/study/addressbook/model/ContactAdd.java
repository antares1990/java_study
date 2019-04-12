package ru.stqa.study.addressbook.model;

import java.util.Objects;

public class ContactAdd {
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactAdd that = (ContactAdd) o;
        return id == that.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    private int id = Integer.MAX_VALUE;
    private String firstname;
    private String middlename;
    private String lastname;
    private String nickname;
    private String email;
    private String groups;


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
