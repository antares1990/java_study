package ru.stqa.study.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.study.addressbook.model.GroupDate;
import ru.stqa.study.addressbook.model.Groups;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class GroupHelper extends HelperBase {

    public GroupHelper(WebDriver wd) {
        super(wd);

    }

    public void returnToGroupPage() {
        click(By.linkText("groups"));
    }

    public void submitGroupCreation() {
        click(By.name("submit"));
    }

    public void fillGroupForm(GroupDate groupDate) {
        type(By.name("group_name"), groupDate.getName());
        type(By.name("group_header"), groupDate.getHeader());
        type(By.name("group_footer"), groupDate.getFooter());
    }

    public void initGroupCreation() {
        click(By.name("new"));
    }

    public void clickDelete() {
        click(By.xpath("(//input[@name='delete'])[2]"));
    }


    public void selectGroupById(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }

    public void clickEdit() {
        click(By.xpath("(//input[@name='edit'])[2]"));
    }

    public void clickUpdate() {
        click(By.name("update"));
    }

    public void create(GroupDate group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        groupCash = null;
        returnToGroupPage();
    }

    public void modifyGroup(GroupDate group) {
        selectGroupById(group.getId());
        clickEdit();
        fillGroupForm(group);
        clickUpdate();
        groupCash = null;
        returnToGroupPage();
    }


    public void delete(GroupDate group) {
        selectGroupById(group.getId());
        clickDelete();
        groupCash = null;
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Groups groupCash = null;


    public Groups all() {
        if (groupCash !=null) {
            return new Groups(groupCash);
        }

        groupCash = new Groups();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            groupCash.add(new GroupDate().withId(id).withName(name));
        }
        return new Groups(groupCash);
    }
}
