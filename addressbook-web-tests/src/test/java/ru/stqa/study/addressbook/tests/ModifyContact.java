package ru.stqa.study.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.ContactAdd;

import java.util.concurrent.TimeUnit;

public class ModifyContact extends TestBase{
    WebDriver wd;

    @Test
    public void testContactModify() {

        app.getNavigationHelper().clickHome();
        if (! app.getContactHelper().isThereAContact()) {
            app.getContactHelper().CreateContact(new ContactAdd("test", "test", "test", "test", "test@test.ru"));
        }
        app.getContactHelper().clickContactID();
        app.getContactHelper().clickEditContact();
        app.getContactHelper().createNewContact(new ContactAdd("newtest", "newtest", "newtest", "newtest", "newtest@test.ru"));
        app.getContactHelper().clickUpdateContact();

    }
}
