package ru.stqa.study.addressbook.tests;

import org.hamcrest.CoreMatchers;
import org.hamcrest.MatcherAssert;
import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.ContactAdd;
import ru.stqa.study.addressbook.model.Contacts;

import java.util.Set;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;
import static org.testng.Assert.*;

public class CreateNewContact extends TestBase {

  @Test
  public void testCreateNewContact() throws Exception {
    Contacts before = app.contact().allcontact();
    ContactAdd contact = new ContactAdd().withFirstname("test33").withMiddlename("test33").withLastname("test33").withNickname("test").withEmail("test@test.ru");
    app.contact().gotoAddContact();
    app.contact().createNewContact(contact);
    app.contact().submitNewContact();
    app.contact().returnToHome();
    Contacts after = app.contact().allcontact();
    assertThat(after.size(),equalTo(before.size() + 1));

    /*int max = 0;
    for (ContactAdd c : after) {
      if (c.getId() > max) {
        max = c.getId();
      }
    }*/

    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));

  }


}
