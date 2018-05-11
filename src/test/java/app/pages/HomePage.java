package app.pages;

import app.pages.ResultPages.VstraivaemayaPosudomoechnayaMashinaPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class HomePage extends AbstractPage{

    public By ukrLangLoc = By.xpath("//header//span[@data-language='uk']");
    public By bt = By.xpath("//a[@href='/bt/']");
    public By vstraivaemayaTehnika = By.xpath("//span[@class='vstraivaemaya-tehnika']");
    public By posudomoechnyeMashiny = By.xpath("//a[@class='posudomoechnye-mashiny']");



    public HomePage (WebDriver driver){
        super(driver);
    }

    public void chageLanguage(By langBtnLoc){
        WebElement langBtn = driver.findElement(langBtnLoc);
        langBtn.click();
    }

    public VstraivaemayaPosudomoechnayaMashinaPage chooseCategory(By categoryFirstStepLoc, By categorySecondStepLoc, By categoryThirdStepLoc) throws InterruptedException {
        Actions action1 = new Actions(driver);
        WebElement categoryFirstStep = driver.findElement(categoryFirstStepLoc);
        action1.moveToElement(categoryFirstStep).build().perform();
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.visibilityOfElementLocated(categorySecondStepLoc));
        WebElement categorySecondStep = driver.findElement(categorySecondStepLoc);
        categorySecondStep.click();
        WebElement categoryThirdStep = driver.findElement(categoryThirdStepLoc);
        categoryThirdStep.click();
        return new VstraivaemayaPosudomoechnayaMashinaPage(driver);
    }

    public void chooseFirstCategory(By categoryFirstStepLoc){
        Actions action1 = new Actions(driver);
        WebElement categoryFirstStep = driver.findElement(categoryFirstStepLoc);
        action1.moveToElement(categoryFirstStep).build().perform();
    }
}
