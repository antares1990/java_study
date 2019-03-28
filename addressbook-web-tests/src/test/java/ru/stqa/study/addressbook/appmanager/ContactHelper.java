package ru.stqa.study.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
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
    }

    public void clickDeleteContact() {
      click(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input"));
    }

    public void clickContactID() {
      click(By.name("selected[]"));
    }
}
