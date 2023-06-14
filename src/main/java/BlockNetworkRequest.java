import com.google.common.collect.ImmutableList;
import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.testng.annotations.Test;

import java.util.Optional;
@Test
public class BlockNetworkRequest {

    public void BlockNetwork()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IamBh\\IdeaProjects\\SeleniumFeatureLatest\\src\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        DevTools devTools= driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.send(Network.setBlockedURLs(ImmutableList.of("*.jpg","*.css")));
        Long startTime=System.currentTimeMillis();
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.linkText("Browse Products")).click();
        driver.findElement(By.linkText("Selenium")).click();
        driver.findElement(By.cssSelector(".add-to-cart"));
        System.out.println(driver.findElement(By.cssSelector("p")).getText());
        Long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);

    }

}
