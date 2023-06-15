import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.fetch.Fetch;
import org.testng.annotations.Test;

import java.util.Optional;
@Test

public class NetworkMocking {
    public void Neteorkmock() throws InterruptedException {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IamBh\\IdeaProjects\\SeleniumFeatureLatest\\src\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        DevTools devTools=driver.getDevTools();
        devTools.createSession();
        devTools.send(Fetch.enable(Optional.empty(),Optional.empty()));
        devTools.addListener(Fetch.requestPaused(),request->
        {
            if(request.getRequest().getUrl().contains("shetty"))
            {
                String mockedUrl=request.getRequest().getUrl().replace("=shetty","=BadGuy");
                System.out.println(mockedUrl);
                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(mockedUrl), Optional.ofNullable(request.getRequest().getMethod()),Optional.empty(),Optional.empty()));
            }
            else
            {
                devTools.send(Fetch.continueRequest(request.getRequestId(), Optional.of(request.getRequest().getUrl()), Optional.ofNullable(request.getRequest().getMethod()),Optional.empty(),Optional.empty()));
            }
        });

        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.manage().window().maximize();
        driver.findElement(By.xpath("//button[text()=' Virtual Library ']")).click();
        Thread.sleep(3000);
        System.out.println(driver.findElement(By.cssSelector("p")).getText());
        driver.close();
    }
}
