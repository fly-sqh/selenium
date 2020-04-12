package PagePo;

import org.openqa.selenium.By;

public class LoginPage {

    public static By homelogin=By.xpath("//*[@id=\"root\"]/section/div/div/div[2]/div[2]/a[2]/div");//首页登录
    public static By username=By.id("username");//用户名输入框
    public static By password=By.id("password");//密码输入框
    public static By loginbutton=By.xpath("//*[@id='root']/section/section/main/div/div/div[2]/div[3]/div/button[2]");//登录
}
