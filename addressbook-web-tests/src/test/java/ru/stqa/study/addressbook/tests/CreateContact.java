package ru.stqa.study.addressbook.tests;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.ContactAdd;
import ru.stqa.study.addressbook.model.Contacts;

import java.io.File;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class CreateContact extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContacts() {
    List<Object[]> list = new ArrayList<Object[]>();
    list.add(new Object[] {new ContactAdd().withFirstname("test1").withLastname("test1")});
    list.add(new Object[] {new ContactAdd().withFirstname("test2").withLastname("test2")});
    list.add(new Object[] {new ContactAdd().withFirstname("test3").withLastname("test3")});
    return list.iterator();

  }

  @Test(dataProvider = "validContacts")
  public void testCreateContact(ContactAdd contact) throws Exception {
    Contacts before = app.contact().allcontact();
    File photo = new File("src/test/resources/tiger.jpg");
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
