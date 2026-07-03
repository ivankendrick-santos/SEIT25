package io.cucumber.pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasicAuthPage extends Page {

    public BasicAuthPage(ChromeDriver driver) {
        super(driver);
    }

    @FindBy(css = ".example p")
    private WebElement successMessage;

    public boolean isCongratulationsDisplayed() {
        return successMessage.getText()
                .contains("Congratulations");
    }
}
