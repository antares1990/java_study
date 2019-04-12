package ru.stqa.study.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.GroupDate;
import ru.stqa.study.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.*;

public class GroupCreationTests extends TestBase {

  @Test
  public void testGroupCreation() throws Exception {
    app.goTo().groupPage();
    Groups before = app.group().all();
    GroupDate group = new GroupDate().withName("test2");
    app.group().initGroupCreation();
    app.group().fillGroupForm(group);
    app.group().submitGroupCreation();
    app.group().returnToGroupPage();
    Groups after = app.group().all();
    assertEquals(after.size(),before.size() + 1);


    assertThat(after, equalTo(before.withAdded(
            group.withId(after.stream().mapToInt((g) -> g.getId()).max().getAsInt()))));
  }


}
