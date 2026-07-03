package io.cucumber.pages;

import io.cucumber.models.UserRecord;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.List;

public class DataTablesPage extends Page {

    public DataTablesPage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(css = "#table1 tbody tr")
    private List<WebElement> tableRows;

    public List<UserRecord> getExample1Table() {

        List<UserRecord> rows = new ArrayList<>();

        for (WebElement row : tableRows) {

            List<WebElement> cells = row.findElements(By.tagName("td"));

            rows.add(new UserRecord(
                    cells.get(0).getText(),
                    cells.get(1).getText(),
                    cells.get(2).getText(),
                    cells.get(3).getText(),
                    cells.get(4).getText()
            ));
        }

        return rows;
    }
}