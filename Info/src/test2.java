import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.regex.Pattern;
import java.util.concurrent.TimeUnit;

import org.junit.*;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.Select;

import com.csvreader.CsvReader;

public class test2 {
  private WebDriver driver;
  private String baseUrl;
  private boolean acceptNextAlert = true;
  private StringBuffer verificationErrors = new StringBuffer();

  @Before
  public void setUp() throws Exception {
    driver = new FirefoxDriver();
    baseUrl = "http://www.ncfxy.com";
    driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
  }

  @Test
  public void test2() throws Exception {
    String inString = "";
    String num = "";
    String email="";
    String pwd="";
    File inFile = new File("D://TestCourse/info.csv"); // 读取的CSV文件
   
    try {
        BufferedReader reader = new BufferedReader(new FileReader(inFile));
        
        CsvReader creader = new CsvReader(reader, ',');
        driver.get(baseUrl + "/");
        String w1=driver.getWindowHandle();
       
        while(creader.readRecord()){
            inString = creader.getRawRecord();//读取一行数据
                String[] info=inString.split(",");
                num=info[0].trim();
                email=info[1].trim();
                
                
                driver.findElement(By.id("name")).clear();
                driver.findElement(By.id("name")).sendKeys(num);
                driver.findElement(By.id("pwd")).clear();
                
                pwd=num.substring(4);
                driver.findElement(By.id("pwd")).sendKeys(pwd);
                driver.findElement(By.id("submit")).click();    
                
                String newWindow = driver.getWindowHandle();
                String num2=driver.findElement(By.xpath("//*[@id='table-main']/tr[2]/td[2]")).getText();
                String email2=driver.findElement(By.xpath("//*[@id='table-main']/tr[1]/td[2]")).getText();
                Assert.assertEquals(num, num2);
                Assert.assertEquals(email, email2);
                
                driver.get(baseUrl + "/");
                w1=driver.getWindowHandle();                
                driver.switchTo().window(w1);
                
       
        }  
        creader.close();
       
    } catch (IOException ex) {
        ex.printStackTrace();
    }
}
    
   

  @After
  public void tearDown() throws Exception {
    driver.quit();
    String verificationErrorString = verificationErrors.toString();
    if (!"".equals(verificationErrorString)) {
      fail(verificationErrorString);
    }
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
}
