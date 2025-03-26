package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

public class SearchResultsPage extends BasePage  {

    public By resultsChartsTitlesLabel = By.xpath( ("//article//*[contains(@class,'post-content')]//h2[*]"));
    public By noResultsMessageLabel = By.xpath(("//*[@class='no-results not-found']"));
    public By searchButton = By.xpath(("//*[@class='search-submit']"));
    public By searchField = By.xpath(("//*[@class='page-content']/..//*[@id='search-field']"));
    public By resultsLoader = By.xpath(("//*[contains(@class, 'infinity-success')]"));

    /**
     * Verifica se todos os cards de artigos exibidos na tela de resultados possuem o título informado.
     * @param searchText Título que será buscado.
     * @param partial false (Busca pelo o texto exato) || true (busca por um termo específico)
     */
    public void articlesListAssert(String searchText, Boolean partial) {
           waitForElement(resultsLoader);
           var resultsLength = driver.findElements(resultsChartsTitlesLabel);
           for(int i = 1; i < resultsLength.size(); i++)
           {
               new Actions(driver).scrollToElement(resultsLength.get(i)).perform();
               if(partial) {
                   if(!resultsLength.get(i).getText().toUpperCase().contains(searchText.toUpperCase())){
                       throw new Error("O texto " + searchText + " não foi encontrado no card " + resultsLength.get(i).getText());
                   }
               } else {
                   Assert.assertEquals(resultsLength.get(i).getText().toUpperCase(), searchText.toUpperCase());
               }
           }
       }

    /**
     * Refaz a busca de um artigo a partir da tela de resultados não encontrados
     * @param searchText Texto que ser será pesquisado.
     */
    public void retrySearchArticle(String searchText) {
           waitForElement(searchField);
           driver.findElement(searchField).sendKeys(searchText);
           driver.findElement(searchButton).click();
       }
}
