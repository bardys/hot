package app.tests;

import app.pages.HomePage;
import app.pages.ResultPages.ResultPage;
import app.pages.ResultPages.VstraivaemayaPosudomoechnayaMashinaPage;
import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import static com.sun.org.apache.xerces.internal.util.PropertyState.is;

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
        Boolean isFilterChecked =
                vstraivaemayaPosudomoechnayaMashinaPage.checkFilterIsSet(vstraivaemayaPosudomoechnayaMashinaPage.checkedPolovynaZavantazhenniaFilterLoc);
        System.out.println("Actual: " + isFilterChecked);
        Assert.assertTrue (isFilterChecked);
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

//    @Test
//    public void setAllFilters() throws InterruptedException {
//        HomePage homePage = new HomePage(driver);
//        VstraivaemayaPosudomoechnayaMashinaPage vstraivaemayaPosudomoechnayaMashinaPage =
//                homePage.chooseCategory(homePage.bt, homePage.vstraivaemayaTehnika, homePage.posudomoechnyeMashiny);
//        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.polovynaZavantazhenniaFilterLoc);
//        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.zamochuvanniaFilterLoc);
//        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.timerFilterLoc);
//        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.komplektiv8FilterLoc);
//        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.komplektiv12FilterLoc);
//        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.shyryna42FilterLoc);
//
//        vstraivaemayaPosudomoechnayaMashinaPage.expandOtherFilters();
//        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.vysota80FilterLoc);
//        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.hlybyna55FilterLoc);
//        vstraivaemayaPosudomoechnayaMashinaPage.setFilter(vstraivaemayaPosudomoechnayaMashinaPage.pidlohoviFilterLoc);
//
//        Boolean isFilterChecked =
//                vstraivaemayaPosudomoechnayaMashinaPage.checkFilterIsSet(vstraivaemayaPosudomoechnayaMashinaPage.checkedPolovynaZavantazhenniaFilterLoc);
//        System.out.println("Actual: " + isFilterChecked);
//        Assert.assertTrue (isFilterChecked);
//        Thread.sleep(1000);
//    }

    @Test
    public void setFilters() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        VstraivaemayaPosudomoechnayaMashinaPage vstraivaemayaPosudomoechnayaMashinaPage =
                homePage.chooseCategory(homePage.bt, homePage.vstraivaemayaTehnika, homePage.posudomoechnyeMashiny);

        vstraivaemayaPosudomoechnayaMashinaPage.expandOtherFilters();

        List<By> filtersLocators = Arrays.asList(
                vstraivaemayaPosudomoechnayaMashinaPage.polovynaZavantazhenniaFilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.zamochuvanniaFilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.timerFilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.komplektiv8FilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.komplektiv12FilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.shyryna42FilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.vysota80FilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.hlybyna55FilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.pidlohoviFilterLoc
                );

        vstraivaemayaPosudomoechnayaMashinaPage.setFilters(filtersLocators);

        List<By> checkedFiltersLocators = Arrays.asList(
                vstraivaemayaPosudomoechnayaMashinaPage.checkedPolovynaZavantazhenniaFilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.checkedZamochuvanniaFilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.checkedTimerFilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.checkedKomplektiv8FilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.checkedKomplektiv12FilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.checkedShyryna42FilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.checkedVysota80FilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.checkedHlybyna55FilterLoc,
                vstraivaemayaPosudomoechnayaMashinaPage.checkedPidlohoviFilterLoc
        );

        List<Boolean> actualAreFiltersDisplayed =
                vstraivaemayaPosudomoechnayaMashinaPage.checkFiltersAreSet(checkedFiltersLocators);

        List<Boolean> expectedAreFiltersDisplayed = new ArrayList<Boolean>();

        for (Boolean element : actualAreFiltersDisplayed) {
            expectedAreFiltersDisplayed.add(true);
        }

        System.out.println("Expected: " + expectedAreFiltersDisplayed);
        System.out.println("Actual: " + actualAreFiltersDisplayed);

        Assert.assertTrue (actualAreFiltersDisplayed.equals(expectedAreFiltersDisplayed));
    }

    @Test
    public void openAllWithPrice() throws InterruptedException {
        HomePage homePage = new HomePage(driver);
        VstraivaemayaPosudomoechnayaMashinaPage vstraivaemayaPosudomoechnayaMashinaPage =
                homePage.chooseCategory(homePage.bt, homePage.vstraivaemayaTehnika, homePage.posudomoechnyeMashiny);
        vstraivaemayaPosudomoechnayaMashinaPage.openAllWithPrice(6, vstraivaemayaPosudomoechnayaMashinaPage.resultPricesLoc);
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
//        System.out.println(expectedAttribute);
//        System.out.println(actualAttribute);
//        System.out.println(result);
    }




}
