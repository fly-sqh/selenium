package Logic;

import PagePo.OnlinePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Booking {
    public static void Online(WebDriver dr) throws InterruptedException {
        //online批量下单
        dr.findElements(OnlinePage.createorder).get(1).click();//切换frame，点击批量下单按钮
        Thread.sleep(2000);//等待页面
        dr.findElement(OnlinePage.selectfile).sendKeys("C:\\Users\\admin\\Documents\\Automation\\online下单.xlsx");
        Thread.sleep(2000);
        dr.findElement(OnlinePage.submit).click();//点击提交按纽
        Thread.sleep(3000);
        dr.switchTo().defaultContent();
        String ordermassge=dr.findElement(OnlinePage.massge).getAttribute("innerHTML");
        Assert.assertEquals(ordermassge,"上传成功","下单失败");
        System.out.println(ordermassge);
        Thread.sleep(2000);
        dr.switchTo().frame("content-iframe");
    }
    public static void Mail(WebDriver dr) throws InterruptedException {
        //邮件批量下单
        dr.findElement(OnlinePage.createmailorder).click();//点击邮件批量上传
        Thread.sleep(2000);
        dr.findElement(OnlinePage.mailselectfile).sendKeys("C:\\Users\\admin\\Documents\\Automation\\邮件下单.xlsx");
        Thread.sleep(2000);
        dr.findElement(OnlinePage.mailsubmit).click();
        Thread.sleep(2000);
        dr.switchTo().defaultContent();
        String Massge=dr.findElement(OnlinePage.massge).getAttribute("innerHTML");
        System.out.println(Massge);
        Assert.assertEquals(Massge,"上传成功","邮件下单失败");
        Thread.sleep(2000);

    }
    public static void Offline(WebDriver dr) throws InterruptedException {
        //offline批量下单
        dr.findElements(OnlinePage.createorder).get(1).click();//点击批量上传
        Thread.sleep(2000);
        dr.findElement(OnlinePage.selectfile).sendKeys("C:\\Users\\admin\\Documents\\Automation\\offline下单.xlsx");//上传文件
        Thread.sleep(2000);
        dr.findElement(OnlinePage.submit).click();//点击提交
        Thread.sleep(3000);
        dr.switchTo().defaultContent();
        String ordermassge=dr.findElement(OnlinePage.massge).getAttribute("innerHTML");
        Assert.assertEquals(ordermassge,"上传成功","下单失败");
        System.out.println(ordermassge);
    }

}
