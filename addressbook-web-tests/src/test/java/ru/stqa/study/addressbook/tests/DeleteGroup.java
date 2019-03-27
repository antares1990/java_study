package ru.stqa.study.addressbook.tests;

import org.testng.annotations.Test;

public class DeleteGroup extends TestBase{

  @Test
  public void testDeleteGroup() throws Exception {
    app.getNavigationHelper().gotoGroupPage();
    app.getGroupHelper().selectGroup();
    app.getGroupHelper().clickDelete();
    app.getGroupHelper().returnToGroupPage();
  }

}
