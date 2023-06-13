
import org.openqa.selenium.By;

import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.emulation.Emulation;
import org.testng.annotations.Test;

import java.util.Optional;

public class MobileEmulatorTest {
    public static void main(String[] args) throws InterruptedException {

        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IamBh\\IdeaProjects\\SeleniumFeatureLatest\\src\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        //send commends to CDP Methods-> CDP methods will invoke and get access to Chrome dev tools
        devTools.send(Emulation.setDeviceMetricsOverride(600, 1000, 50, true, Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty(), Optional.empty()));
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");

        driver.findElement(By.cssSelector(".navbar-toggler-icon")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//a[normalize-space()='Library']")).click();


        System.out.println(driver.getTitle());
        driver.close();

    }
}
