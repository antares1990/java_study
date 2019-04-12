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
        app.goTo().groupPage();
        if (app.group().all().size() == 0) {
            app.group().create(new GroupDate().withName("test1"));
        }
    }

    @Test
    public void testGroupModify() {
        Groups before = app.group().all();
        GroupDate modify = before.iterator().next();
        GroupDate group = new GroupDate().withId(modify.getId()).withName("1new").withHeader("newtest3").withFooter("newtest3");
        app.group().modifyGroup(group);
        Groups after = app.group().all();
        assertThat(after.size(), equalTo(before.size()));


        assertThat(after, equalTo(before.without(modify).withAdded(group)));

    }


}
