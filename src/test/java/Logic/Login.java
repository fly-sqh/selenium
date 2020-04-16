package Logic;

import Packing.FindElement;
import PagePo.LoginPage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.IOException;

public class Login {
    public  static void Login(WebDriver dr,String username,String password) {
        FindElement.findElement(LoginPage.homelogin).click();//点击登录
        FindElement.findElement(LoginPage.username).sendKeys(username);//输入账号
        FindElement.findElement(LoginPage.password).sendKeys(password);//输入密码
        FindElement.findElement(LoginPage.loginbutton).click();//点击登录


    }
}

