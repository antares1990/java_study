package ru.stqa.study.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.GroupDate;

public class ModifyGroup extends TestBase{

    @Test
    public void testGroupModify() {

        app.getNavigationHelper().gotoGroupPage();
        if (! app.getGroupHelper().isThereAGroup()) {
            app.getGroupHelper().CreateGroup(new GroupDate("test1", null, null));
        }
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().clickEdit();
        app.getGroupHelper().fillGroupForm(new GroupDate("newtest1", "newtest2", "newtest3"));
        app.getGroupHelper().clickUpdate();

    }

}
