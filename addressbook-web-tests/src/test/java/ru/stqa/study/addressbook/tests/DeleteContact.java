package ru.stqa.study.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.study.addressbook.model.ContactAdd;
import ru.stqa.study.addressbook.model.GroupDate;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class DeleteContact extends TestBase{
  WebDriver wd;

  @Test
  public void testDeleteContact() throws Exception {
    app.getNavigationHelper().clickHome();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().CreateContact(new ContactAdd("test", "test", "test", "test", "test@test.ru"));
    }
    List<ContactAdd> before = app.getContactHelper().getContactList();
    app.getContactHelper().clickContactID(before.size() - 1);
    app.getContactHelper().clickDeleteContact();
    app.AlertAccept();
    app.getContactHelper().returnToHome();
    List<ContactAdd> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() - 1);

    before.remove(before.size() - 1);
    Assert.assertEquals(before, after);

  }

}
