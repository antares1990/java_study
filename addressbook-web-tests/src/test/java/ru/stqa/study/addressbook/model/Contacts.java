package ru.stqa.study.addressbook.model;

import com.google.common.collect.ForwardingSet;

import java.util.HashSet;
import java.util.Set;

public class Contacts extends ForwardingSet<ContactAdd> {

    private Set<ContactAdd> delegate;

    public Contacts(Contacts contacts) {
        this.delegate = new HashSet<ContactAdd>(contacts.delegate);
    }

    public Contacts() {
        this.delegate = new HashSet<ContactAdd>();
    }

    @Override
    protected Set<ContactAdd> delegate() {
        return delegate;
    }

    public Contacts withAdded(ContactAdd contact) {
        Contacts contacts = new Contacts(this);
        contacts.add(contact);
        return contacts;
    }

    public Contacts without(ContactAdd contact) {
        Contacts contacts = new Contacts(this);
        contacts.remove(contact);
        return contacts;
    }
}
