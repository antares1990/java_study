package ru.stqa.study.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.ContactAdd;
import ru.stqa.study.addressbook.model.Contacts;
import ru.stqa.study.addressbook.model.GroupDate;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class ModifyContact extends TestBase{
    WebDriver wd;

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().clickHome();
            app.contact().CreateContact(new ContactAdd().withFirstname("test33").withMiddlename("test33").withLastname("test33").withNickname("test").withEmail("test@test.ru"));
        }
    }

    @Test 
    public void testContactModify() {
        Contacts before = app.db().contacts();
        ContactAdd modify = before.iterator().next();
        ContactAdd contact = new ContactAdd().withId(modify.getId()).withFirstname("test33").withLastname("test33")
                .withAddress("test").withWorkPhone("11111").withHomePhone("11111").withMiddlename("23458934");
        app.goTo().clickHome();
        app.contact().modifyContact(contact);
        assertEquals(app.contact().count(), before.size());
        Contacts after = app.db().contacts();

        assertThat(after, equalTo(before.without(modify).withAdded(contact)));

    }


}
