package ru.stqa.study.addressbook.tests;

import org.testng.annotations.*;
import ru.stqa.study.addressbook.model.ContactAdd;

public class CreateNewContact extends TestBase {

  @Test
  public void testCreateNewContact() throws Exception {
    app.getContactHelper().gotoAddContact();
    app.getContactHelper().createNewContact(new ContactAdd("test", "test", "test", "test", "test@test.ru"));
    app.getContactHelper().submitNewContact();
  }


}
