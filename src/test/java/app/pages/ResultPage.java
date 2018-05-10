package app.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

public class ResultPage extends AbstractPage{

    public static By resultTitleVstraivaemayaPosudomoechnyeMashiny = By.xpath("//div[@class='heading']/h1");

    public ResultPage(WebDriver driver){
        super(driver);
    }
}
