package app.pages.ResultPages;

import app.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ResultPage extends AbstractPage {

    public static By titleLocator = By.xpath("//div[@class='heading']/h1");
    By checkedFiltersTabLoc = By.xpath("//ul[@data-tab-nav='tabs-filters']//span[contains (text(), 'Вибрані')]");
    public By resultItemLoc = By.xpath("//li[@class='product-item']");
    public By expandOtherFiltersLoc = By.xpath("//div[@class='filters-item filters-expand']");

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

    public String checkFilterIsSet(By checkedFilterLocator){
        WebElement myDynamicElement = (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.presenceOfElementLocated(checkedFiltersTabLoc));
        WebElement checkedFiltersTab = driver.findElement(checkedFiltersTabLoc);
        checkedFiltersTab.click();
        WebElement checkedFilter = driver.findElement(checkedFilterLocator);
        String actualCheckedFilterText = checkedFilter.getText();
        return actualCheckedFilterText;
    }

    public void expandOtherFilters(){
        WebElement expandOtherFilters = driver.findElement(expandOtherFiltersLoc);
        expandOtherFilters.click();
    }



}
