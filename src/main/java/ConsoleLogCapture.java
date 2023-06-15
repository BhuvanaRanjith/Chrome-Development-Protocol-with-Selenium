import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.logging.LogEntries;
import org.openqa.selenium.logging.LogEntry;
import org.openqa.selenium.logging.LogType;
import org.testng.annotations.Test;

import java.util.List;
@Test
public class ConsoleLogCapture {
    public void consolelogcapture()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IamBh\\IdeaProjects\\SeleniumFeatureLatest\\src\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        //Listener onTest Failure
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart")).click();
        driver.findElement(By.linkText("Cart")).click();
        driver.findElement(By.id("exampleInputEmail1")).clear();
        driver.findElement(By.id("exampleInputEmail1")).sendKeys("2");
        LogEntries entries= driver.manage().logs().get(LogType.BROWSER);//Get Logentries to object
       List<LogEntry> logEntry=entries.getAll();//LogEntry object get all the menthod and store the values
       for (LogEntry e:logEntry)
       {
           System.out.println(e.getMessage());//Getthe message from list of logentry
       }
        driver.close();

    }
}
