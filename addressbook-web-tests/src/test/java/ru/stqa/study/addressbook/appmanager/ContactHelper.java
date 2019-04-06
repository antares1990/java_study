package ru.stqa.study.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;
import ru.stqa.study.addressbook.model.ContactAdd;

public class ContactHelper extends HelperBase{

    public ContactHelper(WebDriver wd)  {
        super(wd);
    }

    public void submitNewContact() {
      click(By.xpath("(//input[@name='submit'])[2]"));
    }

    public void createNewContact(ContactAdd contactAdd) {
        type(By.name("firstname"), contactAdd.getFirstname());
        type(By.name("lastname"), contactAdd.getLastname());
        type(By.name("nickname"), contactAdd.getNickname());
        type(By.name("email"), contactAdd.getEmail());
        Object contact;


    }

    public void clickDeleteContact() {
      click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
    }

    public void clickContactID() {
      click(By.name("selected[]"));
    }

    public void clickEditContact() {
        click(By.xpath("//*[@alt='Edit']"));
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
}
