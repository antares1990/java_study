package ru.stqa.study.addressbook.appmanager;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class NavigationHelper {
    private WebDriver wd;

    public NavigationHelper(WebDriver wd) {
        this.wd = wd;
    }

    public void gotoGroupPage() {
      wd.findElement(By.linkText("groups")).click();
    }

    public void gotoAddContact() {
      wd.findElement(By.linkText("add new")).click();
    }

    public void clickHome() {
      wd.findElement(By.linkText("home")).click();
    }

    public void LoginOut() {
        wd.findElement(By.linkText("Logout")).click();
    }

}
