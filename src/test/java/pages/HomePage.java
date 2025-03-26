package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;

public class HomePage extends BasePage {

    public By searchResultsButton = By.xpath("//div[@class='ast-search-menu-icon slide-search']");
    public By searchResultsField = By.id("search-field");
    public By pageLoader = By.xpath("//*[@class='entry-content clear']//div[@style='visibility: visible;']");

    /**
     * Realiza a busca de um artigo a partir do campo de busca do header.
     * @param searchText Texto que ser será pesquisado.
     */
    public void searchArticle(String searchText) {
        waitForElement(pageLoader);
        driver.findElement(searchResultsButton).click();
        driver.findElement(searchResultsField).sendKeys(searchText + Keys.ENTER);
    }
}
