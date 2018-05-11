package app.tests;

import app.pages.HomePage;
import app.pages.ResultPages.VstraivaemayaPosudomoechnayaMashinaPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.List;

public class Smoke extends BaseTest {
    Boolean result;

    @Before
    public void changeLanguageToUkr() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        checkAttribute(homePage.ukrLangLoc, "class", "js-change-language");
        if (result==true){
            homePage.chageLanguage(homePage.ukrLangLoc);
        }
        checkAttribute(homePage.ukrLangLoc, "class", "active js-change-language");
        Assert.assertTrue(result);
    }

    @Test
    public void openVstraivaemayaPosudomoechnyeMashiny() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        VstraivaemayaPosudomoechnayaMashinaPage vstraivaemayaPosudomoechnayaMashinaPage =
                homePage.chooseCategory(homePage.bt, homePage.vstraivaemayaTehnika, homePage.posudomoechnyeMashiny);
        String actualTitleText = vstraivaemayaPosudomoechnayaMashinaPage.checkResultPageTitle();
        String expectedTitleText = "Вбудована посудомийна машина";
        System.out.println("Expected: " + expectedTitleText);
        System.out.println("Actual: " + actualTitleText);
        Assert.assertEquals(expectedTitleText, actualTitleText);
    }

    @Test
    public void setPolovynaZavantazhenniaFilter() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        VstraivaemayaPosudomoechnayaMashinaPage vstraivaemayaPosudomoechnayaMashinaPage =
                homePage.chooseCategory(homePage.bt, homePage.vstraivaemayaTehnika, homePage.posudomoechnyeMashiny);
        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.polovynaZavantazhenniaFilterLoc);
        String actualCheckedFilterText =
                vstraivaemayaPosudomoechnayaMashinaPage.checkFilterIsSet(vstraivaemayaPosudomoechnayaMashinaPage.checkedPolovynaZavantazhenniaFilterLoc);
        String expectedCheckedFilterText = "половинна завантаження";
        System.out.println("Expected: " + expectedCheckedFilterText);
        System.out.println("Actual: " + actualCheckedFilterText);
        Assert.assertEquals(expectedCheckedFilterText, actualCheckedFilterText);
    }

    @Test
    public void resultsCount() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        VstraivaemayaPosudomoechnayaMashinaPage vstraivaemayaPosudomoechnayaMashinaPage =
                homePage.chooseCategory(homePage.bt, homePage.vstraivaemayaTehnika, homePage.posudomoechnyeMashiny);
        List<WebElement> resultsList = driver.findElements(vstraivaemayaPosudomoechnayaMashinaPage.resultItemLoc);
        System.out.println("Count: " + resultsList.size());
        Assert.assertEquals(24, resultsList.size());
    }

    @Test
    public void setAllFilters() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        VstraivaemayaPosudomoechnayaMashinaPage vstraivaemayaPosudomoechnayaMashinaPage =
                homePage.chooseCategory(homePage.bt, homePage.vstraivaemayaTehnika, homePage.posudomoechnyeMashiny);
        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.polovynaZavantazhenniaFilterLoc);
        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.zamochuvanniaFilterLoc);
        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.timerFilterLoc);
        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.komplektiv8FilterLoc);
        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.komplektiv12FilterLoc);
        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.shyryna42FilterLoc);

        vstraivaemayaPosudomoechnayaMashinaPage.expandOtherFilters();
        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.vysota80FilterLoc);
        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.hlybyna55FilterLoc);
        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.pidlohoviFilterLoc);

        String actualSetFilterText =
                vstraivaemayaPosudomoechnayaMashinaPage.checkFilterIsSet(vstraivaemayaPosudomoechnayaMashinaPage.checkedPolovynaZavantazhenniaFilterLoc);
        String expectedSetFilterText = "половинна завантаження";
        System.out.println("Expected: " + expectedSetFilterText);
        System.out.println("Actual: " + actualSetFilterText);
        Assert.assertEquals(expectedSetFilterText, actualSetFilterText);
        Thread.sleep(3000000);
    }


    @Ignore
    @Test
    public void openFirstCategory() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
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
