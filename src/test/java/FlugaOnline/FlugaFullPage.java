package FlugaOnline;

import Logic.AgentCompany;
import Logic.CreditControl;
import Logic.Login;
import PagePo.MenuBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import javax.xml.crypto.Data;
import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class FlugaFullPage {
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
        dr = new ChromeDriver();
        dr.manage().window().maximize();
        dr.get("https://www.fluga.com/#/page");
        Login.Login(dr, "megacap", "XdD2w74W");//登录
        Thread.sleep(2000);
        dr.findElement(MenuBar.customerrelation).click();//点击客户关系
        Thread.sleep(1000);
        dr.findElement(MenuBar.agentcompany).click();//点击代理公司管理
        dr.switchTo().frame("content-iframe");
        Thread.sleep(1000);
        AgentCompany.assertagentcompant(dr);//校验添加代理页面
        AgentCompany.modifyagent(dr,"CSHI");//检验修改代理页面
        AgentCompany.contantinfo(dr);//检验联系信息页面
        dr.switchTo().defaultContent();
        dr.findElement(MenuBar.creditcontrol).click();//点击信用额度管理
        dr.switchTo().frame("content-iframe");
        CreditControl.searchagent(dr,"CSHI");//搜索代理CSHI
        DateFormat dateformat= new SimpleDateFormat("yyyy-MM-dd");//将日期存储为yyyy-mm-dd的形式
        Date date =new Date();//获取当前日期
        String date1=dateformat.format(date);//将当前日期存储为yyyy-mm-dd的类型
        CreditControl.Temporarylimit(dr,"1",date1);//添加临时额度
        CreditControl.history(dr);//查看使用记录




    }
}
