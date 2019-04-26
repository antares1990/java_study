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
    if (app.db().groups().size() == 0) {
    app.goTo().groupPage();
    app.group().create(new GroupDate().withName("Testtest"));
    }
  }

  @Test
  public void testDeleteGroup() throws Exception {
    Groups before = app.db().groups();
    GroupDate deletedGroup = before.iterator().next();
    app.goTo().groupPage();
    app.group().delete(deletedGroup);
    assertEquals(app.group().count(), before.size() - 1);
    Groups after = app.db().groups();


    assertThat(after, equalTo(before.without(deletedGroup)));

  }

}
