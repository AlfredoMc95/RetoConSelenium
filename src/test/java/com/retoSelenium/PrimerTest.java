package com.retoSelenium;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.*;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.UnsupportedFlavorException;
import java.io.IOException;
import java.time.Duration;

public class PrimerTest {

    private WebDriver driver;

    @BeforeEach
    public void setUp() {
        FirefoxOptions firefoxOptions = new FirefoxOptions();
        firefoxOptions.setAcceptInsecureCerts(true);
        driver = new FirefoxDriver(firefoxOptions);
        driver.manage().window().maximize();
        driver.get("https://www.uitestingplayground.com/home");
    }

    @Test
    public void test1Click() {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='Click']"));
        testClick.click();
        Delay(1);
        WebElement buttonTest = driver.findElement(By.xpath("//button[@id='badButton']"));
        buttonTest.click();
        Delay(1);
    }

    @Test
    public void test2DinamicBtn() {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='Dynamic ID']"));
        testClick.click();
        Delay(1);
        WebElement buttonTest = driver.findElement(By.xpath("//button[normalize-space()='Button with Dynamic ID']"));
        buttonTest.click();
        Delay(1);

        String buttonId = buttonTest.getAttribute("id");
        System.out.println("ID del botón : " + buttonId);

        buttonTest.click();
        Delay(1);
    }

    @Test
    public void test3TextInput() {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='Text Input']"));
        testClick.click();
        Delay(1);
        WebElement inputTest = driver.findElement(By.xpath("//input[@id='newButtonName']"));
        inputTest.sendKeys("AlfredoMC");
        Delay(1);
        WebElement buttonTest = driver.findElement(By.xpath("//button[@id='updatingButton']"));
        buttonTest.click();
        Delay(1);
    }

    @Test
    public void test4ClassAttribute() {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='Class Attribute']"));
        testClick.click();
        Delay(1);
        WebElement buttonTest = driver.findElement(By.xpath("//button[contains(concat(' ', normalize-space(@class), ' '), ' btn-primary ')]"));
        buttonTest.click();
        Delay(1);
        Alert alert = driver.switchTo().alert();
        alert.accept();
        Delay(1);
    }

    @Test
    public void test5LoadDelay() {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='Load Delay']"));
        testClick.click();
        WebElement home = driver.findElement(By.xpath("//a[normalize-space()='Home']"));
        home.click();
        WebElement testClick2 = driver.findElement(By.xpath("//a[normalize-space()='Load Delay']"));
        testClick2.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(5));
        WebElement buttonTest = wait.until(ExpectedConditions.visibilityOfElementLocated(
                By.xpath("//button[normalize-space()='Button Appearing After Delay']")
        ));
        buttonTest.click();
        Delay(1);
    }

    @Test
    public void test6HiddenLayers() {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='Hidden Layers']"));
        testClick.click();
        Delay(1);
        WebElement buttonTest = driver.findElement(By.xpath("//button[@id='greenButton']"));
        buttonTest.click();
        Delay(1);
    }

    @Test
    public void test7AJAXData() {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='AJAX Data']"));
        testClick.click();
        WebElement buttonTest = driver.findElement(By.xpath("//button[@id='ajaxButton']"));
        buttonTest.click();
        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(60));
        wait.until(ExpectedConditions.textToBePresentInElementLocated(
                By.id("content"), "Data loaded with AJAX get request."
        ));
        Delay(1);
    }

    @Test
    public void test8ProgressBar() {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='Progress Bar']"));
        testClick.click();
        WebElement buttonTest = driver.findElement(By.xpath("//button[@id='startButton']"));
        buttonTest.click();
        WebElement progressBar = driver.findElement(By.id("progressBar"));
        int progress = 0;
        while (progress < 75) {
            String progressValue = progressBar.getAttribute("aria-valuenow");
            progress = Integer.parseInt(progressValue);
            System.out.println("Progreso actual: " + progress + "%");
        }
        WebElement buttonStop = driver.findElement(By.id("stopButton"));
        buttonStop.click();

        Delay(2);
    }

    @Test
    public void test9SampleApp() {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='Sample App']"));
        testClick.click();
        WebElement userInput = driver.findElement(By.xpath("//input[@name='UserName']"));
        userInput.sendKeys("AlfredoMC");
        WebElement PassInput = driver.findElement(By.xpath("//input[@name='Password']"));
        PassInput.sendKeys("pwd");
        WebElement logIn = driver.findElement(By.xpath("//button[@id='login']"));
        logIn.click();

        Delay(1);
    }

    @Test
    public void test10Alerts() {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='Alerts']"));
        testClick.click();
        WebElement testAlert = driver.findElement(By.xpath("//button[@id='alertButton']"));
        testAlert.click();
        Delay(1);
        Alert alert = driver.switchTo().alert();
        Delay(1);
        alert.accept();
        WebElement buttonTest = driver.findElement(By.xpath("//button[@id='confirmButton']"));
        buttonTest.click();
        Delay(1);
        Alert alert2 = driver.switchTo().alert();
        Delay(1);
        alert2.accept();
        WebElement buttonTestPrompt = driver.findElement(By.xpath("//button[@id='promptButton']"));
        buttonTestPrompt.click();
        Delay(1);
        Alert alert3 = driver.switchTo().alert();
        alert3.sendKeys("Dog");
        Delay(1);
        alert3.accept();



        Delay(1);
    }

    @Test
    public void test11overlappedElement() {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='Overlapped Element']"));
        testClick.click();
        WebElement inputId = driver.findElement(By.xpath("//input[@id='id']"));
        Delay(1);
        inputId.sendKeys("123456789");
        WebElement inputField = driver.findElement(By.id("name"));
        JavascriptExecutor js = (JavascriptExecutor) driver;
        js.executeScript("arguments[0].scrollIntoView(true);", inputField);
        inputField.sendKeys("Alfredo");
        WebElement inputaSubject = driver.findElement(By.xpath("//input[@id='subject']"));
        inputaSubject.sendKeys("Saludo");

        Delay(2);
    }

    @Test
    public void test12NonBreakingSpace() {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='Non-Breaking Space']"));
        testClick.click();
        WebElement button = driver.findElement(By.xpath("//button[text()='My\u00A0Button']"));
        button.click();

        Delay(2);
    }

    @Test
    public void test13ShadowDOM()throws UnsupportedFlavorException, IOException {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='Shadow DOM']"));
        testClick.click();

        WebElement shadowHost = driver.findElement(By.xpath("//div[@class='container']//guid-generator"));
        SearchContext shadowRoot = shadowHost.getShadowRoot();

        WebElement generateButton = shadowRoot.findElement(By.id("buttonGenerate"));
        generateButton.click();

        WebElement copyButton = shadowRoot.findElement(By.id("buttonCopy"));
        copyButton.click();

        WebElement inputField = shadowRoot.findElement(By.id("editField"));

        String getValue = inputField.getAttribute("value");

        Toolkit toolkit = Toolkit.getDefaultToolkit();
        Clipboard clipboard = toolkit.getSystemClipboard();
        String clipboardText = (String) clipboard.getData(DataFlavor.stringFlavor);

        Assertions.assertEquals(getValue, clipboardText, "El GUID copiado no coincide con el generado.");
        System.out.println("el id es: "+getValue);
        Delay(2);
    }

    @Test
    public void test14AnimatedButton() {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='Animated Button']"));
        testClick.click();

        WebElement startAnimationButton = driver.findElement(By.xpath("//button[@id='animationButton']"));
        startAnimationButton.click();

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        WebElement movingTarget = driver.findElement(By.xpath("//button[@id='movingTarget']"));

        wait.until(ExpectedConditions.attributeToBeNotEmpty(movingTarget, "class"));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeContains(movingTarget, "class", "spin")));

        movingTarget.click();

        Delay(2);
    }

    @Test
    public void test15DisabledInput() {
        WebElement testClick = driver.findElement(By.xpath("//a[normalize-space()='Disabled Input']"));
        testClick.click();

        WebElement disableField = driver.findElement(By.xpath("//button[@id='enableButton']"));
        disableField.click();

        WebElement inputField = driver.findElement(By.xpath("//input[@id='inputField']"));

        WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.not(ExpectedConditions.attributeToBe(inputField, "disabled", "true")));

        inputField.sendKeys("Alfredo");

        Delay(2);
    }

    @AfterEach
    public void tearDown() {
        driver.quit();
    }

    public void Delay(int seconds) {
        try {
            Thread.sleep(seconds * 1000); // Convertir segundos a milisegundos
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

}
