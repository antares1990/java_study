package ru.stqa.study.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.ContactAdd;

import java.util.Arrays;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;

public class ContactAllEmails extends TestBase{

    @BeforeMethod
    public void Preconditions() {
        app.contact().returnToHome();
        if (! app.contact().isThereAContact()) {
            app.contact().CreateContact(new ContactAdd().withFirstname("Test").withLastname("Test")
                    .withAddress("This is tests for phones, address and emails")
                    .withHomePhone("10()+").withWorkPhone("+7(915)87-23-23").withMobilePhone("")
                    .withEmail("").withEmail2("12@ mas.ry y").withEmail3("123 456"));
        }
    }

    @Test
    public void testContactEmail() {
        app.contact().returnToHome();
        ContactAdd contact = app.contact().allcontact().iterator().next();
        ContactAdd contactInfoFormEditForm = app.contact().infoFormEditForm(contact);

        assertThat(contact.getAllemails(), equalTo(mergeEmails(contactInfoFormEditForm)));

    }

    private String mergeEmails(ContactAdd contact) {
        return Arrays.asList(contact.getEmail(), contact.getEmail2(), contact.getEmail3())
                .stream().filter((s) -> s!=null && !s.equals(""))
                .collect(Collectors.joining("\n"));
    }

}
