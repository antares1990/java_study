package ru.stqa.study.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.study.addressbook.model.ContactAdd;
import ru.stqa.study.addressbook.model.GroupDate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;

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

    public void clickContactID(int index) {
        wd.findElements(By.name("selected[]")).get(index).click();
    }

    public void clickEditContact(int index) {
        wd.findElements(By.xpath("//*[@alt='Edit']")).get(index).click();
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
        returnToHome();


    }

    public boolean isThereAContact() {
        return isElementPresent(By.name("selected[]"));
    }

    public int getContactCount() {
        return wd.findElements(By.name("selected[]")).size();
    }

    public List<ContactAdd> getContactList() {
        List<ContactAdd> contacts = new ArrayList<ContactAdd>();
        List<WebElement> elements = wd.findElements(By.name("entry"));
        for (WebElement element : elements) {
            String firstname = element.findElement(By.xpath(".//td[3]")).getText();
            String lastname = element.findElement(By.xpath(".//td[2]")).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            ContactAdd contact = new ContactAdd(id, firstname, lastname);
            contacts.add(contact);
        }
        return contacts;
    }
}
