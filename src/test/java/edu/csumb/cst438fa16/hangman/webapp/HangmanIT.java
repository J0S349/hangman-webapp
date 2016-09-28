package edu.csumb.cst438fa16.hangman.webapp;

import static org.junit.Assert.*;
import static org.hamcrest.CoreMatchers.*;

import org.junit.*;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.SystemClock;
import org.openqa.selenium.support.ui.WebDriverWait;
/**
 * Created by Peeps on 9/27/16.
 */
public class HangmanIT {
    WebDriver driver = new ChromeDriver();

    @Before
    public void setUp() {
        driver.get("http://localhost:8080/hangman.html");

        // driver.get("http://localhost:8080/hangman.html");
    }

    @After
    public void tearDown() {
        driver.quit(); // close browser
    }

    /**
     * Acceptance Test:
     *  Given I am on the hangmen page
     *  When I enter the word 'abc'
     *  Then I expect an output like 'ca.'
     */

    @Test
    public void testingInputWithTwoCorrectLetters()
    {
        driver.findElement(By.id("newGuesses")).sendKeys("abc");
        driver.findElement(By.id("submit")).click();
        // The greeting is rendered automatically with Javascript
        // Wait maximum of 10 sec to load
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBe(By.id("pattern"), "ca."));

        // Success
    }

    /**
     *  Acceptance Test:
     *      Given I am on the hangman webpage
     *      When I enter the words 'xyz'
     *      Then I see an output of '...'
     */

    @Test
    public void testingInputWithNoValidWords(){
        driver.findElement(By.id("newGuesses")).sendKeys("xyz"); // similar to entering 'xyz' in webapp
        driver.findElement(By.id("submit")).click();

        // The greeting is rendered automatically with Javascript
        // Wait maximum of 10 sec to load
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBe(By.id("pattern"), "..."));
    }

    /**
     *  Acceptance Test:
     *      Given I am on the hangman webpage
     *      When I enter nothing
     *      Then I expect the output on word to be '...'
     */

    @Test
    public void testingInputWithNoInputEntered(){
        driver.findElement(By.id("newGuesses")).sendKeys("");
        driver.findElement(By.id("submit")).click();

        // The greeting is rendered automatically with Javascript,
        // Wait maximum of 10 seconds to load

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBe(By.id("pattern"), "..."));
    }
}
