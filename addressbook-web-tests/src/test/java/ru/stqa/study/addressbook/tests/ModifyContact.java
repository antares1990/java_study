package ru.stqa.study.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.ContactAdd;

import java.util.HashSet;
import java.util.List;

public class ModifyContact extends TestBase{
    WebDriver wd;

    @Test
    public void testContactModify() {

        app.getNavigationHelper().clickHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().CreateContact(new ContactAdd("test", "123", "test", "345", "678"));
        }
        List<ContactAdd> before = app.getContactHelper().getContactList();
        app.getContactHelper().clickContactID(before.size() - 1);
        app.getContactHelper().clickEditContact();
        ContactAdd contact = new ContactAdd(before.get(before.size() - 1).getId(),"newtest", "middle", "test", "123", "newtest");
        app.getContactHelper().createNewContact(contact);
        app.getContactHelper().clickUpdateContact();
        app.getContactHelper().returnToHome();
        List<ContactAdd> after = app.getContactHelper().getContactList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(contact);
        Assert.assertEquals(new HashSet<Object>(before), new HashSet<Object>(after));

    }
}
