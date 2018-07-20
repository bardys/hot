package app.tests;

import app.pages.AbstractPage;
import org.junit.After;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class BaseTest {
    public WebDriver driver;

    @Before
    public void setUp(){
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        navigateTo(AbstractPage.BASE_URL);
    }

    @After
    public void tearDown(){
        driver.quit();
    }

    public void navigateTo(String url){
        driver.navigate().to(url);
    }

}
