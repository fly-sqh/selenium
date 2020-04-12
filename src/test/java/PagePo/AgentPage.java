package PagePo;

import org.openqa.selenium.By;

public class AgentPage {
    public static By agentsearch= By.id("keywords");//代理输入框
    public static By modify=By.xpath("//*[@id=\"dataTables\"]/tbody/tr/td[9]/button[1]");//修改按钮
    public static By contantinfo=By.xpath("//*[@id=\"dataTables\"]/tbody/tr/td[9]/button[2]");//联系信息按钮
    public static By infoback=By.xpath("//*[@id=\"main-content\"]/section/div/div/section/header/span/button/i");//返回按钮--联系信息
    public static By creatagent=By.id("add-btn");//新建代理
    public static By back=By.xpath("//*[@id=\"main-content\"]/section/div[1]/div/section/header/span/button[1]");//返回按钮--新建代理
    public static By searchbutton=By.id("search-btn");//搜索按钮
}
