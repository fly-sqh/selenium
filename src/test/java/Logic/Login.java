package Logic;

import PagePo.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login {
    public  static void Login(WebDriver dr,String username,String password) throws InterruptedException {
        dr.findElement(LoginPage.homelogin).click();//点击登录
        Thread.sleep(2000);
        dr.findElement(LoginPage.username).sendKeys(username);//输入账号
        dr.findElement(LoginPage.password).sendKeys(password);//输入密码
        dr.findElement(LoginPage.loginbutton).click();//点击登录
        Thread.sleep(5000);

    }
}

