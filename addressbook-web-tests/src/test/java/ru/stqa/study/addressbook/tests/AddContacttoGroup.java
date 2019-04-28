package ru.stqa.study.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.ContactAdd;
import ru.stqa.study.addressbook.model.Contacts;
import ru.stqa.study.addressbook.model.GroupDate;

public class AddContacttoGroup extends TestBase{
    WebDriver wd;

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().contacts().size() == 0) {
            app.goTo().clickHome();
            app.contact().CreateContact(new ContactAdd().withFirstname("test33").withMiddlename("test33").withLastname("test33").withNickname("test").withEmail("test@test.ru"));
        }
            if (app.db().groups().size() == 0) {
                app.goTo().groupPage();
                app.group().create(new GroupDate().withName("test1"));
            }
        }

    @Test
    public void testAddContacttoGroup() {
        app.goTo().clickHome();
        ContactAdd contact = app.db().contacts().iterator().next();
        app.contact().AddtoGroup(contact);
    }
}
