package lt.techin.example;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.time.Duration;

public class CalculatorPage {

    @FindBy(css = "#number1")
    private WebElement number1InputField;

    @FindBy(css = "#function")
    private WebElement functionSelector;

    @FindBy(css = "#number2")
    private WebElement number2InputField;

    @FindBy(css = "#calculate")
    private WebElement clickCalculateButton;

    @FindBy(css = "#answer")
    private WebElement checkDisplayedResultWindow;

    WebDriver driver;

    public CalculatorPage(WebDriver driver) {
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }
    //input number 3 into input field 1
    public void inputThreeIntoNumber1Field() {
        waitForElementToBeClickable(number1InputField).sendKeys("3");
    }
    //select plus from function selector
    public void selectPlusFromFunctionSelector() {
        selectFunctionByVisibleText("plus");
    }
    //select minus from function selector
    public void selectMinusFromFunctionSelector() {
        selectFunctionByVisibleText("minus");
    }
    //select multiply from function selector
    public void selectMultiplyFromFunctionSelector() {
        selectFunctionByVisibleText("times");
    }
    //select division from function selector
    public void selectDivisionFromFunctionSelector() {
        selectFunctionByVisibleText("divide");
    }
    //input number 2 into input field 2
    public void inputTwoIntoNumber2Field() {
        waitForElementToBeClickable(number2InputField).sendKeys("2");
    }
    //click on calculate button for result
    public void clickOnCalculateButton() {
        waitForElementToBeClickable(clickCalculateButton).click();
    }
    //get the result
    public String getResult() {
        return waitForElementToBeVisible(checkDisplayedResultWindow).getText();
    }
    //select function by using text in selector
    private void selectFunctionByVisibleText(String visibleText) {
        waitForElementToBeClickable(functionSelector);
        Select select = new Select(functionSelector);
        select.selectByVisibleText(visibleText);
    }
    //waiting for elements to be clickable - to prevent driver from glossing over them
    private WebElement waitForElementToBeClickable(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.elementToBeClickable(element));
    }
    //waiting for elements to be visible -||-
    private WebElement waitForElementToBeVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }
}
