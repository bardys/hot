package app.pages.ResultPages;

import app.pages.ResultPages.ResultPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class VstraivaemayaPosudomoechnayaMashinaPage extends ResultPage {


    public By polovynaZavantazhenniaFilterLoc = By.xpath("//input[@data-filter-value='1842']/..");
    public By zamochuvanniaFilterLoc = By.xpath("//input[@data-filter-value='1840']/..");
    public By timerFilterLoc = By.xpath("//input[@data-filter-value='1848']/..");
    public By komplektiv8FilterLoc = By.xpath("//input[@data-filter-value='1812']/..");
    public By komplektiv12FilterLoc = By.xpath("//input[@data-filter-value='1813']/..");
    public By shyryna42FilterLoc = By.xpath("//input[@data-filter-value='1829']/..");
    public By vysota80FilterLoc = By.xpath("//input[@data-filter-value='1826']/..");
    public By hlybyna55FilterLoc = By.xpath("//input[@data-filter-value='115792']/..");
    public By pidlohoviFilterLoc = By.xpath("//input[@data-filter-value='1816']/..");

    public By checkedPolovynaZavantazhenniaFilterLoc = By.xpath("//span[@data-catalog-selected-filter='1842']");
    public By checkedZamochuvanniaFilterLoc = By.xpath("//span[@data-catalog-selected-filter='1840']");
    public By checkedTimerFilterLoc = By.xpath("//span[@data-catalog-selected-filter='1848']");
    public By checkedKomplektiv8FilterLoc = By.xpath("//span[@data-catalog-selected-filter='1812']");
    public By checkedKomplektiv12FilterLoc = By.xpath("//span[@data-catalog-selected-filter='1813']");
    public By checkedShyryna42FilterLoc = By.xpath("//span[@data-catalog-selected-filter='1829']");
    public By checkedVysota80FilterLoc = By.xpath("//span[@data-catalog-selected-filter='1826']");
    public By checkedHlybyna55FilterLoc = By.xpath("//span[@data-catalog-selected-filter='115792']");
    public By checkedPidlohoviFilterLoc = By.xpath("//span[@data-catalog-selected-filter='1816']");


    public VstraivaemayaPosudomoechnayaMashinaPage(WebDriver driver){
        super(driver);
    }

}
