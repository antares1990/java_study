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
    if (! app.contact().isThereAContact()) {
      app.contact().CreateContact(new ContactAdd().withFirstname("test33").withMiddlename("test33").withLastname("test33").withNickname("test").withEmail("test@test.ru"));
    }
    Contacts before = app.contact().allcontact();
    ContactAdd delete = before.iterator().next();
    app.contact().deleteContact(delete);
    Contacts after = app.contact().allcontact();
    assertThat(after.size(),equalTo(before.size() - 1));

    assertThat(after, equalTo(before.without(delete)));

  }

}
