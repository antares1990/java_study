package ru.stqa.study.addressbook.model;

import java.util.Objects;

public class ContactAdd {
    private int id;
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String email;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ContactAdd that = (ContactAdd) o;
        return Objects.equals(firstname, that.firstname) &&
                Objects.equals(lastname, that.lastname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstname, lastname);
    }

    public ContactAdd(String firstname, String middlename, String lastname, String nickname, String email) {
        this.id = Integer.MAX_VALUE;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.email = email;
        this.groups = groups;
    }

    public ContactAdd(int id, String firstname, String lastname) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = null;
        this.lastname = lastname;
        this.nickname = null;
        this.email = null;
        this.groups = groups;
    }

    public void setId(int id) {
        this.id = id;
    }

    public ContactAdd(int id, String firstname, String middlename, String lastname, String nickname, String email) {
        this.id = id;
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.email = email;
        this.groups = groups;
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
