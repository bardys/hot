package app.pages.ResultPages;

import app.pages.AbstractPage;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;
import java.util.List;

import static org.apache.xalan.xsltc.compiler.util.Type.Int;

public class ResultPage extends AbstractPage {

    public static By titleLocator = By.xpath("//div[@class='heading']/h1");
    By checkedFiltersTabLoc = By.xpath("//ul[@data-tab-nav='tabs-filters']//span[contains (text(), 'Вибрані')]");
    public By resultItemLoc = By.xpath("//li[@class='product-item']");
    public By expandOtherFiltersLoc = By.xpath("//div[@class='filters-item filters-expand']");
    public By resultPricesLoc = By.xpath("//div[@class='text-sm']");
    public By resultSinglePriceLoc = By.xpath("//div/span/span[@class='value']");
    public By resultPagesNumberLoc = By.xpath("//div[@class='pages-list cell-sm']/child::*");
    public By nextPageLoc = By.xpath("//span[@class='pages active']/following-sibling::a[1]");

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

    public void setFilters(List<By> filters, List<By> checkedFilters) throws InterruptedException {
        for (By filterLoc:filters) {
            WebElement filter = driver.findElement(filterLoc);
            filter.click();
            WebElement waitForCheckedFilterLocator = (new WebDriverWait(driver, 10))
                    .until(ExpectedConditions.presenceOfElementLocated(checkedFilters.get(filters.indexOf(filterLoc))));
        }
        Thread.sleep(5000);
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



    public void openAllWithPrice(int priceLimit) {

        List<WebElement> resultPagesList;
        resultPagesList = driver.findElements(resultPagesNumberLoc);

        for (int j=0; j<resultPagesList.size(); j++) {


            List<WebElement> resultItemList;
            resultItemList = driver.findElements(resultItemLoc);

            List<WebElement> resultPriceList;
            resultPriceList = driver.findElements(resultPricesLoc);
            System.out.println("Count: " + resultPriceList.size());

            for (int i = 1; i <= resultPriceList.size(); i++) {
                By resultPriceLoc = By.xpath("(//div[@class='text-sm'])[" + i + "]");
                WebElement resultPrice = driver.findElement(resultPriceLoc);

                String text = resultPrice.getText();
                String minPriceText = text.substring(0, text.indexOf("–") - 1).replace(" ", "");
                int minPrice = Integer.valueOf(minPriceText);

                System.out.println(text);
                System.out.println(minPrice);


                if (minPrice < priceLimit) {
                    By resultLinkLoc = By.xpath("(//div[@class='info-description']//a)[" + i + "]");
                    WebElement resultLink = driver.findElement(resultLinkLoc);
                    new ResultPage(driver).openInNewTab(resultLink);

                }
            }

            if (resultPriceList.size() < resultItemList.size()) {
                List<WebElement> resultSinglePriceList;
                resultSinglePriceList = driver.findElements(resultSinglePriceLoc);

                for (int i = 1; i <= resultSinglePriceList.size(); i++) {
                    By resultSinglePriceLoc = By.xpath("(//div/span/span[@class='value'])[" + i + "]");
                    WebElement resultSinglePrice = driver.findElement(resultSinglePriceLoc);

                    String singlePriceText = resultSinglePrice.getText().replace(" ", "");
                    int singlePrice = Integer.valueOf(singlePriceText);

                    System.out.println(singlePrice);

                    if (singlePrice < priceLimit) {
                        By resultLinkLoc = By.xpath("(//div/span/span[@class='value'])[" + i + "]/ancestor::div[@class='item-price stick-bottom']/preceding-sibling::div[@class='item-info']/div[@class='info-description']//a");
                        WebElement resultLink = driver.findElement(resultLinkLoc);
                        new ResultPage(driver).openInNewTab(resultLink);

                    }
                }
            }

            if(j<resultPagesList.size()-1){openNextPage();}
        }

    }

    public void openNextPage(){
        WebElement nextPage = driver.findElement(nextPageLoc);
        nextPage.click();
    }

}
