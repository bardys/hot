package app.pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AbstractPage {
    public static final String BASE_URL = "https://hotline.ua";
    public WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
    }

    public void openInNewTab(WebElement link) {
        new Actions(driver)
                .keyDown(Keys.CONTROL)
                .click(link)
                .keyUp(Keys.CONTROL)
                .build()
                .perform();
    }

}
