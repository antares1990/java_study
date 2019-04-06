package ru.stqa.study.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.*;
import ru.stqa.study.addressbook.model.ContactAdd;
import ru.stqa.study.addressbook.model.GroupDate;

import java.util.concurrent.TimeUnit;

public class DeleteContact extends TestBase{
  WebDriver wd;

  @Test
  public void testDeleteContact() throws Exception {
    app.getNavigationHelper().clickHome();
    if (! app.getContactHelper().isThereAContact()) {
      app.getContactHelper().CreateContact(new ContactAdd("test", "test", "test", "test", "test@test.ru"));
    }
    app.getContactHelper().clickContactID();
    app.getContactHelper().clickDeleteContact();
    app.AlertAccept();
  }

}
