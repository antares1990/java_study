package ru.stqa.study.addressbook;

import java.util.concurrent.TimeUnit;
import org.testng.annotations.*;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateNewContact extends TestBase {
  private WebDriver wd;

  @BeforeMethod(alwaysRun = true)
  public void setUp() throws Exception {
    wd = new FirefoxDriver();
    wd.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
    wd.get("http://127.0.0.1:8070/addressbook/");
    Login("admin", "secret");
  }

  private void Login(String user, String password) {
    wd.findElement(By.name("user")).sendKeys(user);
    wd.findElement(By.name("pass")).sendKeys(password);
    wd.findElement(By.xpath("//input[@value='Login']")).click();
  }

  @Test
  public void testCreateNewContact() throws Exception {
    gotoAddContact();
    createNewContact(new ContactAdd("test", "test", "test", "test", "test@test.ru"));
    submitNewContact();
  }

  private void submitNewContact() {
    wd.findElement(By.xpath("(//input[@name='submit'])[2]")).click();
  }

  private void createNewContact(ContactAdd contactAdd) {
    wd.findElement(By.name("firstname")).sendKeys(contactAdd.getFirstname());
    wd.findElement(By.name("middlename")).sendKeys(contactAdd.getMiddlename());
    wd.findElement(By.name("lastname")).sendKeys(contactAdd.getLastname());
    wd.findElement(By.name("nickname")).sendKeys(contactAdd.getNickname());
    wd.findElement(By.name("email")).sendKeys(contactAdd.getEmail());
  }

  private void gotoAddContact() {
    wd.findElement(By.linkText("add new")).click();
  }

  @AfterMethod(alwaysRun = true)
  public void tearDown() throws Exception {
    Logout();
    wd.quit();

  }

  private void Logout() {
    wd.findElement(By.linkText("Logout")).click();
  }

  private boolean isElementPresent(By by) {
    try {
      wd.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      wd.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

}
