package ru.stqa.study.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.GroupDate;
import ru.stqa.study.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class DeleteGroup extends TestBase{

  @BeforeMethod
  public void ensurePreconditions() {
    app.goTo().groupPage();
    if (app.group().all().size() == 0) {
      app.group().create(new GroupDate().withName("Testtest"));
    }
  }

  @Test
  public void testDeleteGroup() throws Exception {
    Groups before = app.group().all();
    GroupDate deletedGroup = before.iterator().next();
    app.group().delete(deletedGroup);
    Groups after = app.group().all();
    assertEquals(after.size(), before.size() - 1);


    assertThat(after, equalTo(before.without(deletedGroup)));

  }

}
