package ru.stqa.study.addressbook.tests;

import org.testng.annotations.*;

public class DeleteContact extends TestBase{

  @Test
  public void testDeleteContact() throws Exception {
    app.getNavigationHelper().clickHome();
    app.getContactHelper().clickContactID();
    app.getContactHelper().clickDeleteContact();
    app.AlertAccept();
  }

}
