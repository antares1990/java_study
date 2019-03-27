package ru.stqa.study.addressbook.model;

public class ContactAdd {
    private final String firstname;
    private final String middlename;
    private final String lastname;
    private final String nickname;
    private final String email;

    public ContactAdd(String firstname, String middlename, String lastname, String nickname, String email) {
        this.firstname = firstname;
        this.middlename = middlename;
        this.lastname = lastname;
        this.nickname = nickname;
        this.email = email;
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
}
