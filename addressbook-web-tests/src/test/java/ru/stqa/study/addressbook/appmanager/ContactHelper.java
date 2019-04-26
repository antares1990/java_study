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
        /*attach(By.name("photo"), contactAdd.getPhoto());*/
        type(By.name("address"), contactAdd.getAddress());
        type(By.name("home"), contactAdd.getHomePhone());
        type(By.name("work"), contactAdd.getWorkPhone());
        type(By.name("mobile"), contactAdd.getMobilePhone());
        type(By.name("email2"), contactAdd.getEmail2());
        type(By.name("email3"), contactAdd.getEmail3());
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
            List<WebElement> cells = element.findElements(By.tagName("td"));
            String firstname = cells.get(2).getText();
            String lastname = cells.get(1).getText();
            int id = Integer.parseInt(element.findElement(By.tagName("input")).getAttribute("id"));
            String allPhones = cells.get(5).getText();
            String address = cells.get(3).getText();
            String allEmails = cells.get(4).getText();
            contactCash.add(new ContactAdd().withId(id).withFirstname(firstname).withLastname(lastname).
                    withAllPhones(allPhones).withAddress(address).withAllemails(allEmails));
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

    public ContactAdd infoFormEditForm(ContactAdd contact) {
        clickEditContactById(contact.getId());
        String firstname = wd.findElement(By.name("firstname")).getAttribute("value");
        String lastname = wd.findElement(By.name("lastname")).getAttribute("value");
        String home = wd.findElement(By.name("home")).getAttribute("value");
        String mobile = wd.findElement(By.name("mobile")).getAttribute("value");
        String work = wd.findElement(By.name("work")).getAttribute("value");
        String address = wd.findElement(By.name("address")).getText();
        String email = wd.findElement(By.name("email")).getAttribute("value");
        String email2 = wd.findElement(By.name("email2")).getAttribute("value");
        String email3 = wd.findElement(By.name("email3")).getAttribute("value");
        wd.navigate().back();
        return new ContactAdd().withId(contact.getId()).withFirstname(firstname).withLastname(lastname)
                .withHomePhone(home).withMobilePhone(mobile).withWorkPhone(work).withAddress(address)
                .withEmail(email).withEmail2(email2).withEmail3(email3);
    }
}
