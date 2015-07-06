package code;

import java.util.Date;
import java.util.Calendar;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

public class Implementation {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();
  Calendar calendar = Calendar.getInstance();
  java.util.Date currentTime = calendar.getTime();

//==========================================================GeneralCode====================================
  @Before
  public void setUp() throws Exception {
	  //System.setProperty("webdriver.firefox.bin","C:\\Program Files\\Mozilla Firefox\\Firefox.exe");
    driver = new FirefoxDriver();
    baseUrl = "https://www.google.at/";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void testLogin(String userID, String passWD) throws Exception {
    driver.get(baseUrl + "/");
    driver.findElement(By.id("gb_70")).click();
    driver.findElement(By.id("Email")).clear();
    driver.findElement(By.id("Email")).sendKeys(userID);
    driver.findElement(By.id("next")).click();
    driver.findElement(By.id("Passwd")).clear();
    driver.findElement(By.id("Passwd")).sendKeys(passWD);
    driver.findElement(By.id("signIn")).click();
  }

  public void logincheck (String userID) throws Exception {
 driver.getPageSource().contains(userID);
  }
  
  public void logout () throws Exception {
    driver.get("https://accounts.google.com/SignOutOptions?hl=de&continue=https://www.google.at/");
    driver.findElement(By.id("signout")).click();
  }
  
  @After
  public void tearDown() throws Exception {
	//  Thread.sleep(1000);
	  driver.close();
      driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
  // throw  new RuntimeException();
  }

  private boolean isElementPresent(By by) {
    try {
      driver.findElement(by);
      return true;
    } catch (NoSuchElementException e) {
      return false;
    }
  }

  private boolean isAlertPresent() {
    try {
      driver.switchTo().alert();
      return true;
    } catch (NoAlertPresentException e) {
      return false;
    }
  }

  private String closeAlertAndGetItsText() {
    try {
      Alert alert = driver.switchTo().alert();
      String alertText = alert.getText();
      if (acceptNextAlert) {
        alert.accept();
      } else {
        alert.dismiss();
      }
      return alertText;
    } finally {
      acceptNextAlert = true;
    }
  }
  
//==========================================================TC0002.Search====================================
  
  public void TC0001GoToCreate() throws Exception {
	  driver.get("https://translate.google.at/"); 
  }
  
  public void TC0001FillIn(String name, int size, String status) throws Exception {
	  driver.findElement(By.id("source")).sendKeys(name +" "+ size +" "+ status +" "+ currentTime);
      driver.findElement(By.id("gt-submit")).click();   
  }
  
 public void TC0001Check(String data) throws Exception {
	 driver.getPageSource().contains(data);
  }
 
 
//==========================================================TC0002.Search====================================
  public void TC0002Search(String book) throws Exception {
	    driver.findElement(By.id("lst-ib")).sendKeys(book);
  }
  
  public void TC0002SearchResult(String result) throws Exception {
  driver.findElement(By.linkText(result)).isDisplayed();
  }
  
//==========================================================TC0010.ErrorLogin====================================
  public void TC0010LoginError() throws Exception {
	  driver.findElement(By.id("errormsg_0_Passwd")).isDisplayed();
	  }
  
  public void TC0010AccChoose() throws Exception {
	  driver.findElement(By.className("tagline")).isDisplayed();
	  }

}
