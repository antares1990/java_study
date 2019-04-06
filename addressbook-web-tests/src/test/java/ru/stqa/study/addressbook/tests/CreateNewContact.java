package ru.stqa.study.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.study.addressbook.model.ContactAdd;

public class CreateNewContact extends TestBase {

  @Test
  public void testCreateNewContact() throws Exception {
    int before = app.getContactHelper().getContactCount();
    app.getContactHelper().gotoAddContact();
    app.getContactHelper().createNewContact(new ContactAdd("test", "test", "test", "test", "test@test.ru"));
    app.getContactHelper().submitNewContact();
    app.getContactHelper().returnToHome();
    int after = app.getContactHelper().getContactCount();
    Assert.assertEquals(after, before +1);

  }


}
