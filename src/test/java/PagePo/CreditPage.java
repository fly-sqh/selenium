package PagePo;

import org.openqa.selenium.By;

public class CreditPage {
    public static By agentsearch= By.id("keywords");//代理搜索框
    public static By searchbutton=By.id("search-btn");//搜索按钮
    public static By addcredit=By.xpath("//*[@id=\"dataTables\"]/tbody/tr/td[9]/button[1]");//添加临时额度
    public static By temporarylimit=By.id("provisionalCredit");//临时额度输入框
    public static By expiredate=By.id("expireDate");//过期时间输入框
    public static By save=By.xpath("//*[@id=\"dataForm\"]/div[4]/div/div/button");//保存按钮
    public static By back=By.id("backTo");//返回按钮--添加临时额度里面
    public static By history=By.xpath("//*[@id=\"dataTables\"]/tbody/tr[1]/td[9]/button[2]");//查看使用记录按钮
    public static By historyback=By.id("backTo");//返回按钮--查看使用记录里面
    public static By massge=By.id("infoMsg");//保存信息

}
