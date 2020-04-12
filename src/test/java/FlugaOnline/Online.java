package FlugaOnline;

import Logic.*;
import PagePo.MenuBar;
import PagePo.OfflinePage;
import PagePo.OnlinePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Online {
    WebDriver dr=null;
    @BeforeTest
    public void setUp(){
        System.setProperty("webdriver.chrome.driver","D:\\chrome\\chromedriver.exe");
    }
    @AfterTest
    public void tearDown(){

        dr.quit();
    }

    @Test
    public void Order() throws InterruptedException, IOException {
        dr=new ChromeDriver();
        dr.manage().window().maximize();
        dr.get("https://www.fluga.com/#/page");
        Login.Login(dr,"megacap","XdD2w74W");//登录
        Thread.sleep(2000);
        dr.findElement(MenuBar.booking).click();//点击订单管理
        Thread.sleep(2000);
        dr.findElement(MenuBar.online).click();//点击订舱单online
        Thread.sleep(1000);
        dr.switchTo().frame("content-iframe");
        Booking.Online(dr);//online下单
        OperationOrder.ConfirmOrder(dr,"CSHI");//接受订单
        dr.switchTo().frame("content-iframe");
        Thread.sleep(1000);
        CBA.CBA(dr);//点击CBA
        String FirstHandle = dr.getWindowHandle();//获取当前窗口句柄
        for(String winHandle : dr.getWindowHandles()) {
            if (winHandle.equals(FirstHandle)) {
                continue;
            }
            dr.switchTo().window(winHandle);
            System.out.println(dr.getCurrentUrl());
            break;
        }//获取所有窗口句柄，切换至除前面获取到的窗口句柄处
        dr.manage().window().maximize();
        CBA.Fetch(dr,"2020-01-31","1","200","1");//分批
        CBA.CBAsave(dr);//排舱
        dr.close();//关闭CBA窗口
        dr.switchTo().window(FirstHandle);//切回飞鲸网页
        dr.switchTo().frame("content-iframe");
        dr.findElement(OnlinePage.awbinfo).click();//点击单号进入订舱详情
        Thread.sleep(5000);
        String fetchGrossWeight=dr.findElement(By.xpath("//*[@id='flightDetail']/div[2]/div/div/div[2]/div/input")).getAttribute("value");
        OperationOrder.AssertSaveOrder(dr);//校验保存订单是否成功
        Manifest.AssertManifest(dr,"GA893","2020-01-30");//生成舱单
        String ActualGrossWeight=dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr/td[5]")).getText();
        Assert.assertEquals(ActualGrossWeight + "0",fetchGrossWeight,"舱单数据不正确");//校验舱单数据是否正确
        dr.switchTo().defaultContent();
        dr.findElement(MenuBar.online).click();//点击订舱单online
        Thread.sleep(2000);
        dr.switchTo().frame("content-iframe");
        Thread.sleep(2000);
        dr.findElement(OnlinePage.unfold).click();//点击展开
        Thread.sleep(1000);
        OperationOrder.CancelOrder(dr,"CSHI");//取消订单
        dr.switchTo().frame("content-iframe");
        Thread.sleep(3000);
        dr.findElement(OnlinePage.search).click();//点击搜索
        Thread.sleep(2000);
        String Massege=dr.findElement(By.xpath("//*[@id='dataTables']/tbody/tr/td")).getText();
        Assert.assertEquals(Massege,"没有查询到数据","单号已取消");//校验订单是否取消成功
        Thread.sleep(1000);
        Booking.Mail(dr);//邮件批量上传
        dr.switchTo().frame("content-iframe");
        dr.findElement(OnlinePage.agentcode).clear();
        OperationOrder.NoacceptCancel(dr,"CSHI");//取消订单
        Thread.sleep(3000);
        dr.switchTo().frame("content-iframe");
        Booking.Offline(dr);//offline订单批量上传
        Thread.sleep(1000);
        dr.findElement(MenuBar.offline).click();//点击订舱单offline
        dr.switchTo().frame("content-iframe");
        Thread.sleep(1000);
        OperationOrder.OfflineConfirmOrder(dr,"CSHI");
        dr.switchTo().frame("content-iframe");
        Thread.sleep(1000);
        OperationOrder.OfflineChangeFlight(dr,"2020-01-06","cz473","LAX");
        Thread.sleep(2000);
        dr.switchTo().frame("content-iframe");
        dr.findElement(OfflinePage.offlineflightdate).clear();
        dr.findElement(OfflinePage.offlineflightdateto).clear();
        dr.findElement(OnlinePage.agentcode).clear();
        Thread.sleep(1000);
        OperationOrder.OfflineCancel(dr,"CSHI");















    }
}
