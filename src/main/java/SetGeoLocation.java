import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;


import java.time.Duration;
import java.util.HashMap;
import java.util.Map;

public class SetGeoLocation {
    public static void main(String[] args) throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IamBh\\IdeaProjects\\SeleniumFeatureLatest\\src\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();


            options.addArguments("--remote-allow-origins=*");
            ChromeDriver driver = new ChromeDriver(options);
                        //47 lati 122-lontitude
            DevTools devTools = driver.getDevTools();
            devTools.createSession();
            Map<String,Object> locationMap = new HashMap<>();
            locationMap.put("latitude",46);
            locationMap.put("longitude", 2);
            locationMap.put("accuracy", 1);
            driver.executeCdpCommand("Emulation.setGeolocationOverride", locationMap);
            driver.get("https://www.google.com/");
            driver.manage().window().maximize();
            driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
            driver.findElement(By.name("q")).sendKeys("netflix", Keys.ENTER);
            driver.findElements(By.cssSelector(".LC20lb")).get(0).click();
            Thread.sleep(2000);
            String title=driver.findElement(By.xpath("//h1[@data-uia='nmhp-card-hero-text-title']")).getText();
            System.out.println(title);
            driver.close();

        }

}
