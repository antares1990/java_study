package ru.stqa.study.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import ru.stqa.study.addressbook.model.GroupDate;

import java.util.ArrayList;
import java.util.List;

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

    public void selectGroup(int index) {

        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void clickEdit() {
        click(By.xpath("(//input[@name='edit'])[2]"));
    }

    public void clickUpdate() {
        click(By.name("update"));
    }

    public void CreateGroup(GroupDate group) {
        initGroupCreation();
        fillGroupForm(group);
        submitGroupCreation();
        returnToGroupPage();
    }

    public boolean isThereAGroup() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getGroupCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<GroupDate> getGroupList() {
        List<GroupDate> groups = new ArrayList<GroupDate>();
        List<WebElement> elements = wd.findElements(By.cssSelector("span.group"));
        for (WebElement element : elements) {
            String name = element.getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("value"));
            GroupDate group = new GroupDate(id, name, null, null);
            groups.add(group);
        }
        return groups;
    }
}
