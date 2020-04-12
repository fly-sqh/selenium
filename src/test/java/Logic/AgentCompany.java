package Logic;

import PagePo.AgentPage;
import org.openqa.selenium.WebDriver;

public class AgentCompany {
    public static void assertagentcompant(WebDriver dr) throws InterruptedException {
      dr.findElement(AgentPage.creatagent).click();
      Thread.sleep(2000);
      dr.findElement(AgentPage.back).click();
      Thread.sleep(2000);
    }
    public static void modifyagent(WebDriver dr,String agent) throws InterruptedException {
        dr.findElement(AgentPage.agentsearch).sendKeys(agent);
        Thread.sleep(1000);
        dr.findElement(AgentPage.searchbutton).click();
        Thread.sleep(2000);
        dr.findElement(AgentPage.modify).click();
        Thread.sleep(2000);
        dr.findElement(AgentPage.back).click();
        Thread.sleep(1000);
    }
    public static void contantinfo(WebDriver dr) throws InterruptedException {
        dr.findElement(AgentPage.contantinfo).click();
        Thread.sleep(1000);
        dr.findElement(AgentPage.infoback).click();
        Thread.sleep(1000);
    }
}
