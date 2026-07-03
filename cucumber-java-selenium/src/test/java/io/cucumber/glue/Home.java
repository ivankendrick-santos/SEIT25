package io.cucumber.glue;

import io.cucumber.config.TestData;
import io.cucumber.core.Context;
import io.cucumber.core.Manager;
import io.cucumber.datatable.DataTable;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import io.cucumber.models.UserRecord;
import io.cucumber.pages.BasicAuthPage;
import io.cucumber.pages.DataTablesPage;
import io.cucumber.pages.HomePage;


import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class Home extends Context {

  private final HomePage homePage;
  private final BasicAuthPage basicAuthPage;
  private final DataTablesPage dataTablesPage;

  public Home(Manager manager) {
    super(manager);
    homePage = new HomePage(getDriver());
    basicAuthPage = new BasicAuthPage(getDriver());
    dataTablesPage = new DataTablesPage(getDriver());
  }

  @When("the {string} link is opened")
  public void openExample(String example) {

    switch (example) {

      case "Basic Auth":
        homePage.clickBasicAuth();
        break;

      case "Sortable Data Tables":
        homePage.clickSortableDataTables();
        break;
    }
  }

  @When("login with valid credentials")
  public void validCredentialsAreSupplied() throws Exception {
     homePage.openBasicAuthPage(
              TestData.BASIC_AUTH_USERNAME,
              TestData.BASIC_AUTH_PASSWORD
      );
  }

  @Then("Congratulations should be displayed")
  public void congratulationsShouldBeDisplayed() {

    BasicAuthPage basicAuthPage = new BasicAuthPage(getDriver());

    assertTrue(
            basicAuthPage.isCongratulationsDisplayed(),
            "The congratulations message was not displayed."
    );
  }

  @Then("Verify table values displayed")
  public void example1ShouldDisplay(DataTable dataTable) {

    List<UserRecord> expected =
            dataTable.asMaps(String.class, String.class)
                    .stream()
                    .map(row -> new UserRecord(
                            row.get("Last Name"),
                            row.get("First Name"),
                            row.get("Email"),
                            row.get("Due"),
                            row.get("Web Site")
                    ))
                    .toList();

    assertEquals(expected, dataTablesPage.getExample1Table());
  }
}