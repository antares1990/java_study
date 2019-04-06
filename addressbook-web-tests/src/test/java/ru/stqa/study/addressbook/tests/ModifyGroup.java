package ru.stqa.study.addressbook.tests;

import org.testng.Assert;
import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.GroupDate;

public class ModifyGroup extends TestBase{

    @Test
    public void testGroupModify() {

        app.getNavigationHelper().gotoGroupPage();
        int before = app.getGroupHelper().getGroupCount();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().CreateGroup(new GroupDate("test1", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().clickEdit();
        app.getGroupHelper().fillGroupForm(new GroupDate("newtest1", "newtest2", "newtest3"));
        app.getGroupHelper().clickUpdate();
        app.getGroupHelper().returnToGroupPage();
        int after = app.getGroupHelper().getGroupCount();
        if (before == 0) {
            Assert.assertEquals(after, before + 1);
        } else {
            Assert.assertEquals(after, before);
        }

    }

}
