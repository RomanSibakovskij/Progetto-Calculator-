package lt.techin.example;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    WebDriver driver;

    @BeforeEach
    void setup() {
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get("https://testpages.herokuapp.com/styled/calculator");
    }
    //Original test
    @Test
    void inputSubtractionTest() {
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        //Task 2
        calculatorPage.inputThreeIntoNumber1Field();
        //Task 3
        calculatorPage.selectMinusFromFunctionSelector();
        //Task 4
        calculatorPage.inputTwoIntoNumber2Field();
        //Task 5
        calculatorPage.clickOnCalculateButton();
        //Task 6
        String result = calculatorPage.getResult();
        assertEquals("1", result);
    }

    @Test
    void inputSumTest(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        //Task 2
        calculatorPage.inputThreeIntoNumber1Field();
        //Task 3
        calculatorPage.selectPlusFromFunctionSelector();
        //Task 4
        calculatorPage.inputTwoIntoNumber2Field();
        //Task 5
        calculatorPage.clickOnCalculateButton();
        //Task 6
        String result = calculatorPage.getResult();
        assertEquals("5", result);
    }

    @Test
    void inputMultiplicationTest(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        //Task 2
        calculatorPage.inputThreeIntoNumber1Field();
        //Task 3
        calculatorPage.selectMultiplyFromFunctionSelector();
        //Task 4
        calculatorPage.inputTwoIntoNumber2Field();
        //Task 5
        calculatorPage.clickOnCalculateButton();
        //Task 6
        String result = calculatorPage.getResult();
        assertEquals("6", result);
    }

    @Test
    void inputDivisionTest(){
        CalculatorPage calculatorPage = new CalculatorPage(driver);

        //Task 2
        calculatorPage.inputThreeIntoNumber1Field();
        //Task 3
        calculatorPage.selectDivisionFromFunctionSelector();
        //Task 4
        calculatorPage.inputTwoIntoNumber2Field();
        //Task 5
        calculatorPage.clickOnCalculateButton();
        //Task 6
        String result = calculatorPage.getResult();
        assertEquals("1.5", result);
    }

    @AfterEach
    void close() {
        driver.quit();

    }
}
