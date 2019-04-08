package ru.stqa.study.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.GroupDate;

import java.util.Comparator;
import java.util.HashSet;
import java.util.List;

public class ModifyGroup extends TestBase{

    @Test
    public void testGroupModify() {

        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().CreateGroup(new GroupDate("test1", null, null));
        }
        List<GroupDate> before = app.getGroupHelper().getGroupList();
        app.getGroupHelper().selectGroup(before.size() - 1);
        app.getGroupHelper().clickEdit();
        GroupDate group = new GroupDate(before.get(before.size() - 1).getId(),"1new", "newtest3", "newtest3");
        app.getGroupHelper().fillGroupForm(group);
        app.getGroupHelper().clickUpdate();
        app.getGroupHelper().returnToGroupPage();
        List<GroupDate> after = app.getGroupHelper().getGroupList();
        Assert.assertEquals(after.size(), before.size());

        before.remove(before.size() - 1);
        before.add(group);
        Comparator<? super GroupDate> byId = (g1, g2) -> Integer.compare(g1.getId(), g2.getId());
        before.sort(byId);
        after.sort(byId);
        Assert.assertEquals(before, after);

    }

}
