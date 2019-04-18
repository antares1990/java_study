package ru.stqa.study.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.ContactAdd;
import ru.stqa.study.addressbook.model.Contacts;

import java.io.File;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class CreateContact extends TestBase {

  @Test
  public void testCreateContact() throws Exception {
    Contacts before = app.contact().allcontact();
    File photo = new File("src/test/resources/tiger.jpg");
    ContactAdd contact = new ContactAdd().withFirstname("test").withMiddlename("test")
            .withLastname("test").withNickname("test").withEmail("test@test.ru").withPhoto(photo);
    app.contact().CreateContact(contact);
    assertThat(app.contact().count(),equalTo(before.size() + 1));
    Contacts after = app.contact().allcontact();
    assertThat(after, equalTo(before.withAdded(
            contact.withId(after.stream().mapToInt(g -> g.getId()).max().getAsInt()))));
  }


  @Test
  public void testBadCreateContact() throws Exception {
    Contacts before = app.contact().allcontact();
    File photo = new File("src/test/resources/tiger.jpg");
    ContactAdd contact = new ContactAdd().withFirstname("test33'").withLastname("test33").withEmail("test@test.ru").withPhoto(photo);
    app.contact().CreateContact(contact);
    assertThat(app.contact().count(),equalTo(before.size()));
    Contacts after = app.contact().allcontact();
    assertThat(after, equalTo(before));
  }

  /*@Test
  public void testCurrentDir() {
    File currentDir = new File(".");
    File photo = new File("src/test/resources/tiger.jpg");
    System.out.println(currentDir.getAbsoluteFile());
    System.out.println(photo.exists());
  }*/


}
