package ru.stqa.study.addressbook.tests;

import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.GroupDate;
import ru.stqa.study.addressbook.model.Groups;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.testng.Assert.assertEquals;

public class GroupModificationTests extends TestBase{

    @BeforeMethod
    public void ensurePreconditions() {
        if (app.db().groups().size() == 0) {
            app.goTo().groupPage();
            app.group().create(new GroupDate().withName("test1"));
        }
    }

    @Test
    public void testGroupModify() {
        Groups before = app.db().groups();
        GroupDate modify = before.iterator().next();
        GroupDate group = new GroupDate().withId(modify.getId()).withName("1new").withHeader("newtest3").withFooter("newtest3");
        app.goTo().groupPage();
        app.group().modifyGroup(group);
        assertThat(app.group().count(), equalTo(before.size()));
        Groups after = app.db().groups();
        assertThat(after, equalTo(before.without(modify).withAdded(group)));
        verifyGroupListUI();

    }


}
