package ru.stqa.study.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.study.addressbook.model.ContactAdd;
import ru.stqa.study.addressbook.model.Contacts;
import ru.stqa.study.addressbook.model.GroupDate;

import java.util.*;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd)  {
        super(wd);
    }

    public void submitNewContact() {
      click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void createNewContact(ContactAdd contactAdd) {
        type(By.name("firstname"), contactAdd.getFirstname());
        type(By.name("middlename"), contactAdd.getFirstname());
        type(By.name("lastname"), contactAdd.getLastname());
        type(By.name("nickname"), contactAdd.getNickname());
        type(By.name("email"), contactAdd.getEmail());
        Object contact;
    }

    public void clickDeleteContact() {
      click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
    }


    public void clickContactIDbyID(int id) {
        wd.findElement(By.cssSelector("input[value='" + id + "']")).click();
    }


    public void clickEditContactById(int id) {
        wd.findElement(By.cssSelector(String.format("a[href='edit.php?id=%s']", id))).click();
    }

    public void clickUpdateContact() {
        click(By.xpath("//input[@name='update']"));
    }

    public void gotoAddContact() {
        click(By.linkText("add new"));
    }

    public void returnToHome() {
        click(By.linkText("home"));
    }

    public void CreateContact(ContactAdd contact) {
        gotoAddContact();
        createNewContact(contact);
        submitNewContact();
        contactCash = null;
        returnToHome();

    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int count() {
        return wd.findElements(By.name("selected[]")).size();
    }

    private Contacts contactCash = null;


    public Contacts allcontact() {
        if (contactCash != null) {
            return new Contacts(contactCash);
        }

        contactCash = new Contacts();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            contactCash.add(new ContactAdd().withId(id).withFirstname(firstname).withLastname(lastname));
        }
        return new Contacts(contactCash);
    }


    public void AlertAccept() {
        wd.switchTo().alert().accept();
    }

    public void deleteContact(ContactAdd contact) {
        clickContactIDbyID(contact.getId());
        clickDeleteContact();
        AlertAccept();
        contactCash = null;
        returnToHome();
    }

    public void modifyContact(ContactAdd contact) {
        clickEditContactById(contact.getId());
        createNewContact(contact);
        clickUpdateContact();
        contactCash = null;
        returnToHome();
    }
}
