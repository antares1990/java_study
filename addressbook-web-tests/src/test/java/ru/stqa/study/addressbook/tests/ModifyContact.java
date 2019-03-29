package ru.stqa.study.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.ContactAdd;

public class ModifyContact extends TestBase{

    @Test
    public void testContactModify() {

        app.getNavigationHelper().clickHome();
        app.getContactHelper().clickContactID();
        app.getContactHelper().clickEditContact();
        app.getContactHelper().createNewContact(new ContactAdd("newtest", "newtest", "newtest", "newtest", "newtest@test.ru"));
        app.getContactHelper().clickUpdateContact();

    }
}
