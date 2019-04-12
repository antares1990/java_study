package ru.stqa.study.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.ContactAdd;
import ru.stqa.study.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ModifyContact extends TestBase{
    WebDriver wd;

    @Test 
    public void testContactModify() {

        app.goTo().clickHome();
        if (! app.contact().isThereAContact()) {
            app.contact().CreateContact(new ContactAdd().withFirstname("test33").withMiddlename("test33").withLastname("test33").withNickname("test").withEmail("test@test.ru"));
        }
        Contacts before = app.contact().allcontact();
        ContactAdd modify = before.iterator().next();
        ContactAdd contact = new ContactAdd().withId(modify.getId()).withFirstname("test33").withMiddlename("test33").withLastname("test33").withNickname("test").withEmail("test@test.ru");
        app.contact().modifyContact(contact);
        Contacts after = app.contact().allcontact();
        assertEquals(after.size(), before.size());

        assertThat(after, equalTo(before.withAdded(modify).withAdded(contact)));

    }


}
