import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.openqa.selenium.devtools.v85.network.Network;
import org.openqa.selenium.devtools.v85.network.model.Request;
import org.openqa.selenium.devtools.v85.network.model.Response;
import org.testng.annotations.Test;

import java.util.Optional;

public class NetworkLogActivity {

    @Test
    public void NetworkLog() {
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\IamBh\\IdeaProjects\\SeleniumFeatureLatest\\src\\Driver\\chromedriver.exe");
        ChromeOptions options = new ChromeOptions();

        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver = new ChromeDriver(options);
        DevTools devTools = driver.getDevTools();
        devTools.createSession();
        devTools.send(Network.enable(Optional.empty(), Optional.empty(), Optional.empty()));
        //Event will get Fired

        devTools.addListener(Network.requestWillBeSent(), request ->
        {
           Request req=request.getRequest();
            //System.out.println(req.getUrl());


        });
        devTools.addListener(Network.responseReceived(), response ->
        {
            Response res = response.getResponse();
           // System.out.println(res.getUrl());
            //System.out.println(res.getStatus());
            if (res.getStatus().toString().startsWith("4"))
            {
                System.out.println(res.getUrl() +"is failing with status code" +res.getStatus());
            }

        });
        driver.get("https://rahulshettyacademy.com/angularAppdemo/");
        driver.findElement(By.xpath("//button[text()=' Virtual Library ']")).click();
        driver.close();

    }
}