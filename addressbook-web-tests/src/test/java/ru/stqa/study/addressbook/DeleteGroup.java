package ru.stqa.study.addressbook;

import org.testng.annotations.Test;

public class DeleteGroup extends TestBase{

  @Test
  public void testDeleteGroup() throws Exception {
    gotoGroupPage();
    selectGroup();
    clickDelete();
    returnToGroupPage();
  }

}
