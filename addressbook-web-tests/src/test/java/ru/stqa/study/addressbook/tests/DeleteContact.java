package ru.stqa.study.addressbook.tests;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.ContactAdd;
import ru.stqa.study.addressbook.model.Contacts;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class DeleteContact extends TestBase{
  WebDriver wd;

  @Test
  public void testDeleteContact() throws Exception {
    app.goTo().clickHome();
    if (app.db().contacts().size() == 0) {
      app.contact().CreateContact(new ContactAdd().withFirstname("test33").withMiddlename("test33").withLastname("test33").withNickname("test").withEmail("test@test.ru"));
    }
    Contacts before = app.db().contacts();
    ContactAdd delete = before.iterator().next();
    app.contact().deleteContact(delete);
    app.goTo().clickHome();
    assertThat(app.contact().count(),equalTo(before.size() - 1));
    Contacts after = app.db().contacts();
    assertThat(after, equalTo(before.without(delete)));
    verifyContactListUI();

  }

}
