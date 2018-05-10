package app.pages;

import org.openqa.selenium.WebDriver;

public class AbstractPage {
    public static final String BASE_URL = "https://hotline.ua";
    WebDriver driver;

    public AbstractPage(WebDriver driver){
        this.driver = driver;
    }
}
