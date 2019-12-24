package org.selenium.example.resources;

import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.ArrayList;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

public class CommonMethods extends IntegrationTestParent{

    public static void verifyTopMenu(){
        ArrayList<String> list = new ArrayList<>();
        list.add(0, Constants.SALE);
        list.add(1, Constants.CHRISTMAS);
        list.add(2, Constants.MENS);
        list.add(3, Constants.LADIES);
        list.add(4, Constants.KIDS);
        list.add(5, Constants.FOOTBALL);
        list.add(6, Constants.RUNNING);
        list.add(7, Constants.ACCESSORIES);
        list.add(8, Constants.SPORTS);
        list.add(9, Constants.BRANDS);
        list.add(10, Constants.DIALS);

        for (int i = 0; i < 1; i++) {
            int a = i + 1;
            assertThat(driver.findElement(By.xpath("//*[@id=\"topMenu\"]/ul/li[" + a + "]/a")).getText(), is(list.get(i)));
        }
    }

    public static void verifyAndCloseIfCristmasSalesPagePresent(){
        WebElement myLink = driver.findElement(By.xpath("/html/body/form/div[13]/div/div/div[1]/button"));

        if(myLink.isDisplayed()){
            driver.findElement(By.xpath("/html/body/form/div[13]/div/div/div[1]/button")).click();
        }
    }

    public static void waitUntilElementWillVisibleByCssSelector(String cssElement){

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.cssSelector(cssElement)));
    }

    public static void waitUntilElementWillVisibleById(String Id){

        WebDriverWait wait = new WebDriverWait(driver, 10);

        wait.until(ExpectedConditions.visibilityOfElementLocated(By.id(Id)));
    }

    public static void clickAndVerifyTextButtonByCssSelector(String cssSelector, String buttonNameRegex){

        WebElement button = driver.findElement(By.cssSelector(cssSelector));

        Assert.assertEquals(buttonNameRegex, button.getText());

        button.click();
    }

    public static void clickTextButtonByCssSelector(String cssSelector){

        WebElement button = driver.findElement(By.cssSelector(cssSelector));

        button.click();
    }

    public static void clickAndVerifyTextButtonByLinkText(String linkText, String buttonNameRegex){

        WebElement button = driver.findElement(By.linkText(linkText));

        Assert.assertEquals(buttonNameRegex, button.getText());

        button.click();
    }

    public static void clickAndVerifyTextButtonByXpath(String xpath, String buttonNameRegex){

        WebElement button = driver.findElement(By.xpath(xpath));

        Assert.assertEquals(buttonNameRegex, button.getText());

        button.click();
    }

    public static void clickAndVerifyTextButtonById(String id, String buttonNameRegex){

        WebElement button = driver.findElement(By.id(id));

        Assert.assertEquals(buttonNameRegex, button.getText());

        button.click();
    }

    public static void clickOnTextFieldById(String id){
        WebElement button = driver.findElement(By.id(id));
        button.click();
    }

    public static void fillTextFieldById(String id, String text){
        driver.findElement(By.id(id)).sendKeys(text);
    }

    public static void scrollDown(){
        JavascriptExecutor jse = (JavascriptExecutor)driver;
        jse.executeScript("scroll(0, 250);");
    }
}
