package Packing;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class SeleniumWebDriver {
    public static WebDriver dr;
    public static WebDriver open(String browser) {
        String path = System.getProperty("user.dir");
        try{
        if (browser.equals("chrome")) {
            System.setProperty("webdriver.chrome.driver",path+"\\WebDirver\\chromedriver.exe");
            dr = new ChromeDriver();
        }
    }catch (Exception e){
            System.out.println("你输入的浏览器有误");
            e.printStackTrace();
        }
        return dr;
    }

}
