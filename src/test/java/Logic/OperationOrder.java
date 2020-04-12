package Logic;

import FlugaOnline.Offline;
import PagePo.OfflinePage;
import PagePo.OnlinePage;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import javax.jws.Oneway;

public class OperationOrder {
    public static void ConfirmOrder(WebDriver dr,String agent) throws InterruptedException {
        //接受订单
        dr.findElement(OnlinePage.unfold).click();//点击展开
        dr.findElement(OnlinePage.agentcode).sendKeys(agent);
        dr.findElement(OnlinePage.search).click();//点击搜索
        Thread.sleep(2000);
        //String awbno= dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr/td[3]/a")).getText();//获取运单号
        dr.findElement(OnlinePage.flightinfo).click();//点击航班号/日期
        Thread.sleep(1000);
        dr.findElement(OnlinePage.accept).click();//点击接受
        Thread.sleep(1000);
        dr.switchTo().defaultContent();
        dr.findElement(OnlinePage.confirm).click();//点击确定
        Thread.sleep(2000);
    }
    public static void OfflineConfirmOrder(WebDriver dr,String agent) throws InterruptedException {
        //接受订单
        dr.findElement(OnlinePage.unfold).click();//点击展开
        dr.findElement(OnlinePage.agentcode).sendKeys(agent);
        dr.findElement(OnlinePage.search).click();//点击搜索
        Thread.sleep(2000);
        //String awbno= dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr/td[3]/a")).getText();//获取运单号
        dr.findElement(OnlinePage.flightinfo).click();//点击航班号/日期
        Thread.sleep(1000);
        dr.findElement(OfflinePage.offlinecomfirm).click();//点击接受
        Thread.sleep(1000);
        dr.switchTo().defaultContent();
        dr.findElement(OnlinePage.confirm).click();//点击确定
        Thread.sleep(2000);
    }
    public static void CancelOrder(WebDriver dr,String agentcode) throws InterruptedException {
        //取消订单
        dr.findElement(OnlinePage.agentcode).sendKeys(agentcode);//输入代理代码
        dr.findElement(OnlinePage.search).click();//点击搜索
        Thread.sleep(2000);
        dr.findElement(OnlinePage.cancel).click();//点击取消
        Thread.sleep(1000);
        dr.switchTo().defaultContent();
        dr.findElement(OnlinePage.confirm).click();//点击确定
    }
    public static void AssertSaveOrder(WebDriver dr) throws InterruptedException {
        //校验订单详情保存订单是否成功
        dr.findElement(By.xpath("//*[@id=\"main-content\"]/section/div[2]/div[1]/section[1]/header/span[1]/button")).click();//点击编辑信息
        Thread.sleep(1000);
        dr.findElement(By.id("orderSaveBtn")).click();//点击保存
        Thread.sleep(1000);
        dr.switchTo().defaultContent();
        String Massge=dr.findElement(OnlinePage.massge).getText();//获取提示信息文案
        System.out.println(Massge);
        Assert.assertEquals(Massge,"保存成功","保存订单失败");
        Thread.sleep(4000);
        ((JavascriptExecutor) dr).executeScript("window.scrollTo(0, 0)");//滚动条滚至顶部
        Thread.sleep(1000);
        dr.switchTo().frame("content-iframe").findElement(By.id("backToHistory")).click();//点击返回
        Thread.sleep(2000);
    }
    public static void NoacceptCancel(WebDriver dr,String agentcode) throws InterruptedException {
        dr.findElement(OnlinePage.agentcode).sendKeys(agentcode);//输入代理代码
        dr.findElement(OnlinePage.search).click();//点击搜索
        Thread.sleep(2000);
        dr.findElement(OnlinePage.noacceptordercancel).click();//点击取消
        Thread.sleep(1000);
        dr.switchTo().defaultContent();
        dr.findElement(OnlinePage.confirm).click();//点击确定
    }
    public static void OfflineCancel(WebDriver dr,String agentcode) throws InterruptedException {
        dr.findElement(OnlinePage.agentcode).sendKeys(agentcode);//输入代理代码
        dr.findElement(OnlinePage.search).click();//点击搜索
        Thread.sleep(2000);
        dr.findElement(OfflinePage.offlinecancel).click();//点击取消
        Thread.sleep(1000);
        dr.switchTo().defaultContent();
        String Massge=dr.findElement(OnlinePage.massge).getAttribute("innerHTML");
        System.out.println(Massge);
        Assert.assertEquals(Massge,"操作成功","订单取消失败");
        dr.findElement(OnlinePage.confirm).click();//点击确定
    }
    public static void  OfflineChangeFlight(WebDriver dr,String flightdate,String flightno,String transferpoint)
            throws InterruptedException {
        dr.findElement(OfflinePage.chageflight).click();
        Thread.sleep(1000);
        dr.findElement(OfflinePage.flightdate).clear();
        Thread.sleep(1000);
        dr.findElement(OfflinePage.flightdate).sendKeys(flightdate);
        dr.findElement(OfflinePage.blank).click();
        Thread.sleep(1000);
        dr.findElements(OfflinePage.flightno).get(1).sendKeys(flightno);
        dr.findElement(OfflinePage.pointoftransfer).sendKeys(transferpoint);
        dr.findElement(OfflinePage.confirm).click();
        dr.switchTo().defaultContent();
        Thread.sleep(2000);
        String Massge =dr.findElement(OnlinePage.massge).getAttribute("innerHTML");
        System.out.println(Massge);
        Assert.assertEquals(Massge,"操作成功","更改航班失败");
    }


}
