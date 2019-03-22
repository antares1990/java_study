package ru.stqa.study.addressbook;

import org.testng.annotations.Test;

public class CreateNewContact extends TestBase {

  @Test
  public void testCreateNewContact() throws Exception {
    gotoAddContact();
    createNewContact(new ContactAdd("test", "test", "test", "test", "test@test.ru"));
    submitNewContact();
  }


}
