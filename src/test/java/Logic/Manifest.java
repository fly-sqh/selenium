package Logic;

import PagePo.MenuBar;
import PagePo.OnlinePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class Manifest {
    public static void AssertManifest(WebDriver dr, String flightno,String flightdate) throws InterruptedException {
        //生成舱单
        dr.findElement(OnlinePage.operate).click();//点击操作
        Thread.sleep(1000);
        dr.findElement(OnlinePage.manifest).click();//点击生成舱单（新）
        Thread.sleep(1000);
        dr.switchTo().defaultContent();
        String Manifest=dr.findElement(OnlinePage.massge).getText();//获取生成舱单后的提示信息文案
        System.out.println(Manifest);
        Assert.assertEquals(Manifest,"生成舱单成功","舱单正常生成");//校验生成舱单是否报错
        Thread.sleep(2000);
        dr.findElement(MenuBar.manifest).click();//点击舱单管理
        Thread.sleep(2000);
        dr.switchTo().frame("content-iframe").findElement(By.id("flightNo")).sendKeys(flightno);//输入航班
        dr.findElement(By.id("depDate")).clear();//清除航班日期内容
        dr.findElement(By.id("depDate")).sendKeys(flightdate);//输入航班日期
        dr.findElement(By.id("search-btn")).click();//点击搜索
        Thread.sleep(2000);
    }
}
