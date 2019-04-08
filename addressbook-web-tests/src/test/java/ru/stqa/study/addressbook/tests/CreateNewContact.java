package ru.stqa.study.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.*;
import ru.stqa.study.addressbook.model.ContactAdd;
import ru.stqa.study.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class CreateNewContact extends TestBase {

  @Test
  public void testCreateNewContact() throws Exception {
    List<ContactAdd> before = app.getContactHelper().getContactList();
    app.getContactHelper().gotoAddContact();
    ContactAdd contact = new ContactAdd("test33", "test33", "test33", "test", "test@test.ru");
    app.getContactHelper().createNewContact(contact);
    app.getContactHelper().submitNewContact();
    app.getContactHelper().returnToHome();
    List<ContactAdd> after = app.getContactHelper().getContactList();
    Assert.assertEquals(after.size(), before.size() + 1);

    /*int max = 0;
    for (ContactAdd c : after) {
      if (c.getId() > max) {
        max = c.getId();
      }
    }*/

    before.add(contact);
    Comparator<? super ContactAdd> byId = (g1,g2) -> Integer.compare(g1.getId(), g2.getId());
    before.sort(byId);
    after.sort(byId);
    Assert.assertEquals(before, after);

  }


}
