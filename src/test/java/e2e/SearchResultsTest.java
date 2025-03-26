package e2e;

import helpers.Configs;
import org.testng.annotations.*;
import pages.HomePage;

public class SearchResultsTest extends Configs {

    public HomePage homePage = new HomePage();
    public String searchText = "Conta";
    public String searchInvalidText = "nullk";

    @Test
    public void sucessfullySearch() throws InterruptedException {
        homePage.searchArticle(searchText);
        searchResultsPage.articlesListAssert(searchText, true);
    }

    @Test
    public void searchWithNoResults() throws InterruptedException {
        homePage.searchArticle(searchInvalidText);
        searchResultsPage.waitForElement(searchResultsPage.noResultsMessageLabel);
    }

    @Test public void retrySearch() throws InterruptedException {
        homePage.searchArticle(searchInvalidText);
        searchResultsPage.retrySearchArticle(searchText);
        searchResultsPage.articlesListAssert(searchText, true);
    }
}
