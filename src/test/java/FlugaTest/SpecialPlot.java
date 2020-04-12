package FlugaTest;

import Logic.Login;
import PagePo.MenuBar;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class SpecialPlot {
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
    public void Build() throws InterruptedException {
       dr=new ChromeDriver();
       dr.manage().window().maximize();
       dr.get("http://47.100.163.174:9010/#/page");
       Login.Login(dr,"megacap","mg35ch");
       dr.findElement(MenuBar.APPoperation).click();
       Thread.sleep(1000);
       dr.findElement(MenuBar.flashsales).click();
       Thread.sleep(2000);


   }
}
