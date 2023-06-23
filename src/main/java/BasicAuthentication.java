import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.devtools.DevTools;
import org.testng.annotations.Test;

import java.net.URI;
import java.util.function.Predicate;

@Test
public class BasicAuthentication {
    public void BasicAuthentication()
    {
        System.setProperty("webdriver.chrome.driver","C:\\Users\\IamBh\\IdeaProjects\\SeleniumFeatureLatest\\src\\Driver\\chromedriver.exe");
        ChromeOptions options=new ChromeOptions();
        options.addArguments("--remote-allow-origins=*");
        ChromeDriver driver=new ChromeDriver(options);

        Predicate<URI> uriPredicate= uri->uri.getHost().contains("httpbin.org");
         ((HasAuthentication)driver).register(uriPredicate, UsernameAndPassword.of("foo","bar"));
        driver.get("http://httpbin.org/basic-auth/foo/bar");
        driver.close();
        System.out.println("pull request commited");

    }
}
