import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.ConnectionType;
import org.openqa.selenium.mobile.NetworkConnection;
import org.testng.annotations.Test;

import java.util.Optional;

@Test
public class NetworkSpeed {
    public void NetworkSpeed()
    {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IamBh\\IdeaProjects\\SeleniumFeatureLatest\\src\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();
        options.addArguments("- -remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        DevTools devTools= driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(),Optional.empty(),Optional.empty()));
        devTools.send(Network.emulateNetworkConditions(false,2000,2000,100000, Optional.of(ConnectionType.ETHERNET)));
        Long startTime=System.currentTimeMillis();
       driver.get("https://rahulshettyacademy.com/angularAppdemo/");
       driver.findElement(By.xpath("//button[text()=' Virtual Library ']")).click();
        Long endTime=System.currentTimeMillis();
        System.out.println(endTime-startTime);
        driver.close();
    }
}
