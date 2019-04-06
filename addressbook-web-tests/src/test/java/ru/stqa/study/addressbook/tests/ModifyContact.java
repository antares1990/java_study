package ru.stqa.study.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.ContactAdd;

public class ModifyContact extends TestBase{
    WebDriver wd;

    @Test
    public void testContactModify() {

        app.getNavigationHelper().clickHome();
        int before = app.getContactHelper().getContactCount();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().CreateContact(new ContactAdd("test", "test", "test", "test", "test@test.ru"));
        }
        app.getContactHelper().clickContactID();
        app.getContactHelper().clickEditContact();
        app.getContactHelper().createNewContact(new ContactAdd("newtest", "newtest", "newtest", "newtest", "newtest@test.ru"));
        app.getContactHelper().clickUpdateContact();
        app.getContactHelper().returnToHome();
        int after = app.getContactHelper().getContactCount();
        if (before == 0) {
            Assert.assertEquals(after, before + 1);
        } else {
            Assert.assertEquals(after, before);
        }

    }
}
