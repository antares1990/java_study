package ru.stqa.study.addressbook.tests;

import org.testng.annotations.Test;
import ru.stqa.study.addressbook.model.GroupDate;

public class ModifyGroup extends TestBase{

    @Test
    public void testGroupModify() {

        app.getNavigationHelper().gotoGroupPage();
        app.getGroupHelper().selectGroup();
        app.getGroupHelper().clickEdit();
        app.getGroupHelper().fillGroupForm(new GroupDate("newtest1", "newtest2", "newtest3"));
        app.getGroupHelper().clickUpdate();

    }

}
