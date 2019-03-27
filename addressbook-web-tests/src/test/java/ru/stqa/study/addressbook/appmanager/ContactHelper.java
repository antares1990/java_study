package ru.stqa.study.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import ru.stqa.study.addressbook.model.ContactAdd;

public class ContactHelper {
    private WebDriver wd;

    public ContactHelper(WebDriver wd)  {
        this.wd = wd;
    }

    public void submitNewContact() {
      wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
    }

    public void createNewContact(ContactAdd contactAdd) {
        wd.findElement(By.name("firstname")).click();
        wd.findElement(By.name("firstname")).clear();
        wd.findElement(By.name("firstname")).sendKeys(contactAdd.getFirstname());
        wd.findElement(By.name("middlename")).click();
        wd.findElement(By.name("middlename")).clear();
        wd.findElement(By.name("middlename")).sendKeys(contactAdd.getMiddlename());
        wd.findElement(By.name("lastname")).click();
        wd.findElement(By.name("lastname")).clear();
        wd.findElement(By.name("lastname")).sendKeys(contactAdd.getLastname());
        wd.findElement(By.name("nickname")).click();
        wd.findElement(By.name("nickname")).clear();
        wd.findElement(By.name("nickname")).sendKeys(contactAdd.getNickname());
        wd.findElement(By.name("email")).click();
        wd.findElement(By.name("email")).clear();
        wd.findElement(By.name("email")).sendKeys(contactAdd.getEmail());
    }

    public void clickDeleteContact() {
      wd.findElement(By.xpath("//*[@id=\"content\"]/form[2]/div[2]/input")).click();
    }

    public void clickContactID() {
      wd.findElement(By.name("selected[]")).click();
    }
}
