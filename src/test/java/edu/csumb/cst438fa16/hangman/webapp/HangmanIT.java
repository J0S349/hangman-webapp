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

import javax.validation.constraints.AssertTrue;

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
        String pattern = driver.findElement(By.id("pattern")).getText();
        assertThat(pattern, equalTo("ca."));
        //assertThat(By.id("pattern").toString(), equalTo("ca."));
        // Success
    }

    /**
     *  Acceptance Test:
     *      Given I am on the hangman webpage
     *      When I enter the words 'xyz'
     *      Then I see an output of '...'
     */

    /**
     * This function is going to test when the user enters number as values into the
     * web application.
     */
    @Test
    public void testingInputWithNoValidWords(){
        driver.findElement(By.id("newGuesses")).sendKeys("123"); // similar to entering 'xyz' in webapp
        driver.findElement(By.id("submit")).click();

        // The greeting is rendered automatically with Javascript
        // Wait maximum of 10 sec to load
        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBe(By.id("pattern"), "..."));
        String pattern = driver.findElement(By.id("pattern")).getText();
        assertThat(pattern, equalTo("..."));
    }

    /**
     *  Acceptance Test:
     *      Given I am on the hangman webpage
     *      When I enter nothing
     *      Then I expect the output on word to be '...'
     */

    /**
     *  This is going to be testing whether the web application is able to handle when the user
     *  doesn't enter any data into the input.
     */

    @Test
    public void testingInputWithNoInputEntered(){
        driver.findElement(By.id("newGuesses")).sendKeys("");
        driver.findElement(By.id("submit")).click();

        // The greeting is rendered automatically with Javascript,
        // Wait maximum of 10 seconds to load

        (new WebDriverWait(driver, 10))
                .until(ExpectedConditions.textToBe(By.id("pattern"), "..."));

        String pattern = driver.findElement(By.id("pattern")).getText();
        assertThat(pattern, equalTo("..."));
    }
}
