package io.cucumber.pages;

import io.cucumber.config.TestData;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;
import java.net.URI;
import java.util.function.Predicate;

import org.openqa.selenium.HasAuthentication;
import org.openqa.selenium.UsernameAndPassword;
import java.util.ArrayList;
import java.util.List;

public class HomePage extends Page {

  public HomePage(ChromeDriver driver) {
    super(driver);
    System.out.println("Homepage title is : " + getTitle().getText());
  }

  @FindBy(css = "h1")
  private WebElement title;

  @FindBy(css = "ul li a")
  private List<WebElement> exampleLinks;

  @FindBy(linkText = "Basic Auth")
  private WebElement basicAuthLink;

  @FindBy(linkText = "Sortable Data Tables")
  private WebElement sortableDataTablesLink;

  public WebElement getTitle() {
    return title;
  }

  public void refresh() {
    driver.navigate().refresh();
    System.out.println("Refreshed page");
  }

  public List<String> getExampleLinks() {
    List<String> links = new ArrayList<>();
    for (WebElement element : exampleLinks) {
      links.add(element.getText().trim());
    }
    return links;
  }

  public void clickBasicAuth() {
    basicAuthLink.click();
  }

  public void openBasicAuthPage(String username, String password) {

    ((HasAuthentication) driver).register(
            uri -> true,
            UsernameAndPassword.of(TestData.BASIC_AUTH_USERNAME,
                    TestData.BASIC_AUTH_PASSWORD)
    );

    basicAuthLink.click();
  }
  public void clickSortableDataTables() {
    sortableDataTablesLink.click();
  }

}
