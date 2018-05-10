package app.tests;

import app.pages.HomePage;
import app.pages.ResultPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

public class Smoke extends BaseTest {
    Boolean result;
    HomePage homePage;
    ResultPage resultPage;

    @Before
    public void changeLanguageToUkr() throws InterruptedException {
        homePage = new HomePage(driver);
        checkAttribute(homePage.ukrLangLoc, "class", "js-change-language");
        if (result==true){
            homePage.chageLanguage(homePage.ukrLangLoc);
        }
        checkAttribute(homePage.ukrLangLoc, "class", "active js-change-language");
        Assert.assertTrue(result);
    }

    @Test
    public void openVstraivaemayaPosudomoechnyeMashiny() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.chooseCategory(homePage.bt, homePage.vstraivaemayaTehnika, homePage.posudomoechnyeMashiny);
        resultPage = new ResultPage(driver);
        WebElement title = driver.findElement(resultPage.resultTitleVstraivaemayaPosudomoechnyeMashiny);
        String actualTitleText = title.getText();
        String expectedTitleText = "Вбудована посудомийна машина";
        System.out.println(actualTitleText);
        System.out.println(expectedTitleText);
        Assert.assertEquals(actualTitleText, expectedTitleText);
    }

    @Ignore
    @Test
    public void openFirstCategory() throws InterruptedException {
        homePage = new HomePage(driver);
        homePage.chooseFirstCategory(homePage.bt);
        Thread.sleep(10000);
    }


    public void checkAttribute(By elementLoc, String attributeName, String expectedAttribute){
        WebElement element = driver.findElement(elementLoc);
        String actualAttribute = element.getAttribute(attributeName);
        result = expectedAttribute.contentEquals(actualAttribute);
        System.out.println(expectedAttribute);
        System.out.println(actualAttribute);
        System.out.println(result);
    }
}
