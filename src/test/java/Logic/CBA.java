package Logic;

import PagePo.OnlinePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class CBA {
    public static void CBA(WebDriver dr) throws InterruptedException {
        //点击CBA
        dr.findElement(OnlinePage.operate).click();//点击操作
        Thread.sleep(1000);
        dr.findElement(OnlinePage.CBA).click();//点击CBA
    }
    public static void Fetch(WebDriver dr,String flightdate,String piece,String weight,String volume) throws InterruptedException {
        //分批
        dr.findElement(By.xpath("//*[@id='gridview-1024']/table/tbody/tr[2]/td[1]/div/div")).click();//CBA中选中订单
        Thread.sleep(1000);
        dr.findElement(By.xpath("//*[@id='gridview-1024']/table/tbody/tr[2]/td[12]/div/img")).click();//点击分批
        Thread.sleep(1000);
        dr.findElement(By.id("operateTime-inputEl")).clear();//清空航班日期
        dr.findElement(By.id("operateTime-inputEl")).sendKeys(flightdate);//输入分批航班
        dr.findElement(By.id("splitCheckBox-inputEl")).click();//勾选分批
        Thread.sleep(1000);
        dr.findElement(By.id("splitPiece-inputEl")).sendKeys(piece);//输入件数1
        dr.findElement(By.id("splitWeight-inputEl")).sendKeys(weight);//输入重量200
        dr.findElement(By.id("splitVolume-inputEl")).sendKeys(volume);//输入体积1
        dr.findElement(By.id("confirmBtn")).click();//点击确定

    }
public static void CBAsave(WebDriver dr) throws InterruptedException {
        //排舱
    Thread.sleep(4000);
    dr.findElement(By.id("button-1051-btnEl")).click();//点击创建区域
    WebElement a=dr.findElement(By.xpath("//*[@id='gridview-1024']/table/tbody/tr[2]/td[9]/div"));
    WebElement b=dr.findElement(By.id("gridview-1104"));
    Actions action = new Actions(dr);
    action.dragAndDrop(a,b).perform();//拖动订单从CBA左边拖到右边完成排舱操作
    dr.findElement(By.id("saveCBA-btnEl")).click();//点击保存CBA
    Thread.sleep(2000);

}
}
