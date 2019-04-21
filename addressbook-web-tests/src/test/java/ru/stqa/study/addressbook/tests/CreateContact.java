package ru.stqa.study.addressbook.tests;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.thoughtworks.xstream.XStream;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.ContactAdd;
import ru.stqa.study.addressbook.model.Contacts;
import ru.stqa.study.addressbook.model.GroupDate;

import java.io.*;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

import static org.hamcrest.CoreMatchers.*;
import static org.hamcrest.MatcherAssert.*;

public class CreateContact extends TestBase {

  @DataProvider
  public Iterator<Object[]> validContactsFromXml() throws IOException {
    List<Object[]> list = new ArrayList<Object[]>();
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.xml")));
    String xml = "";
    String line = reader.readLine();
    while (line != null) {
      xml += line;
      line = reader.readLine();
    }
    XStream xstream = new XStream();
    xstream.processAnnotations(ContactAdd.class);
    List<ContactAdd> contacts = (List<ContactAdd>) xstream.fromXML(xml);
    return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();

  }

  @DataProvider
  public Iterator<Object[]> validContactsFromJson() throws IOException {
    BufferedReader reader = new BufferedReader(new FileReader(new File("src/test/resources/contacts.json")));
    String json = "";
    String line = reader.readLine();
    while (line != null) {
      json += line;
      line = reader.readLine();
    }
    Gson gson = new Gson();
    List<ContactAdd> contacts = gson.fromJson(json, new TypeToken<List<ContactAdd>>(){}.getType());
    return contacts.stream().map((g) -> new Object[] {g}).collect(Collectors.toList()).iterator();
  }

  @Test(dataProvider = "validContactsFromJson")
  public void testCreateContact(ContactAdd contact) {
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
