package app.pages.ResultPages;

import app.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

public class ResultPage extends AbstractPage {

    public static By titleLocator = By.xpath("//div[@class='heading']/h1");
    By checkedFiltersTabLoc = By.xpath("//ul[@data-tab-nav='tabs-filters']//span[contains (text(), 'Вибрані')]");
    public By resultItemLoc = By.xpath("//li[@class='product-item']");
    public By expandOtherFiltersLoc = By.xpath("//div[@class='filters-item filters-expand']");
    public By resultPricesLoc = By.xpath("//div[@class='text-sm']");

    public ResultPage(WebDriver driver){
        super(driver);
    }

    public String checkResultPageTitle() {
        WebElement title = driver.findElement(titleLocator);
        String actualTitleText = title.getText();
        return actualTitleText;
    }

    public void setFilter(By filterLocator) throws InterruptedException {
        WebElement filter = driver.findElement(filterLocator);
        filter.click();
    }

    public void setFilters(List<By> filters) throws InterruptedException {
        for (By filterLoc:filters) {
            WebElement filter = driver.findElement(filterLoc);
            filter.click();
        }
    }

    public Boolean checkFilterIsSet(By checkedFilterLocator){
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(checkedFiltersTabLoc));
        WebElement checkedFiltersTab = driver.findElement(checkedFiltersTabLoc);
        checkedFiltersTab.click();
        WebElement checkedFilter = driver.findElement(checkedFilterLocator);
        Boolean isFilterChecked = checkedFilter.isDisplayed();
        return isFilterChecked;
    }

    public List<Boolean> checkFiltersAreSet(List<By> checkedFilters){
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(checkedFilters.get(checkedFilters.size()-1)));
        System.out.println("Last filter is:" + checkedFilters.get(checkedFilters.size()-1));
        WebElement checkedFiltersTab = driver.findElement(checkedFiltersTabLoc);
        checkedFiltersTab.click();

        List<Boolean> areFiltersDisplayedList = new ArrayList<Boolean>();
        for (By filterLoc:checkedFilters) {
            WebElement checkedFilter = driver.findElement(filterLoc);
            Boolean isFilterChecked = checkedFilter.isDisplayed();
            areFiltersDisplayedList.add(isFilterChecked);
        }
        return areFiltersDisplayedList;
    }

    public void expandOtherFilters(){
        WebElement expandOtherFilters = driver.findElement(expandOtherFiltersLoc);
        expandOtherFilters.click();
    }

    public void openAllWithPrice(int maxPrice, By resultPricesLocator){
        List<WebElement> resultPricesList;

        resultPricesList = driver.findElements(resultPricesLocator);
        System.out.println("Count: " + resultPricesList.size());
    }

}
