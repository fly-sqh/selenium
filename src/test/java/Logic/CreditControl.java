package Logic;

import PagePo.CreditPage;
import org.openqa.selenium.WebDriver;

public class CreditControl {
    public static void searchagent(WebDriver dr,String agentcode) throws InterruptedException {
        dr.findElement(CreditPage.agentsearch).sendKeys(agentcode);
        Thread.sleep(1000);
        dr.findElement(CreditPage.searchbutton).click();
        Thread.sleep(2000);
    }
    public static void Temporarylimit(WebDriver dr,String credit,String expiredate) throws InterruptedException {
        dr.findElement(CreditPage.addcredit).click();
        Thread.sleep(2000);
        dr.findElement(CreditPage.temporarylimit).sendKeys(credit);
        dr.findElement(CreditPage.expiredate).sendKeys(expiredate);
        dr.findElement(CreditPage.save).click();
        Thread.sleep(1000);
        dr.switchTo().defaultContent();
        String Massge=dr.findElement(CreditPage.massge).getAttribute("innerHTML");
        System.out.println(Massge);
        dr.switchTo().frame("content-iframe");
        Thread.sleep(1000);
        dr.findElement(CreditPage.back).click();
        Thread.sleep(1000);
    }
    public static void history(WebDriver dr) throws InterruptedException {
        dr.findElement(CreditPage.history).click();
        Thread.sleep(2000);
        dr.findElement(CreditPage.historyback).click();
        Thread.sleep(1000);
    }

}
