import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;

import java.util.HashMap;
import java.util.Map;

public class CdpCommendTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IamBh\\IdeaProjects\\SeleniumFeatureLatest\\src\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        DevTools devTools= driver.getDevTools();
        devTools.createSession();
        Map devicematric=new HashMap();
        devicematric.put("width",600);
        devicematric.put("height",848);
        devicematric.put("deviceScaleFactor",50);
        devicematric.put("mobile",true);
       driver.executeCdpCommand("Emulation.setDeviceMetricsOverride",devicematric);
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");


        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Library']")).click();

    }
}
