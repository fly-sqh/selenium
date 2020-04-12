package PagePo;

import org.openqa.selenium.By;

public class OnlinePage {
    public static By createorder=By.id("add-btn");//1下单2批量创建订单
    public static By selectfile=By.id("input-b9");//请选择文件
    public static By submit=By.id("batchUploadBtn");//提交
    public static By search=By.id("search-btn");//搜索
    public static By unfold=By.id("fold");//展开
    public static By agentcode=By.id("agentCode");//代理代码输入框
    public static By awbno=By.id("awbNo");//运单号输入框
    public static By flightinfo=By.xpath("//*[@id=\"dataTables\"]/tbody/tr[1]/td[5]/a");//第一个订单的航班
    public static By awbinfo=By.xpath("//*[@id=\"dataTables\"]/tbody/tr[1]/td[3]/a");//第一个订单的单号
    public static By operate=By.xpath("//*[@id=\"flightDataTable\"]/tbody/tr/td[4]/div/a");//操作按钮
    public static By CBA=By.id("cbaBtn");//CBA按钮
    public static By manifest=By.id("manifestBtn");//生成舱单按钮
    public static By massge=By.id("infoMsg");//提示信息
    public static By accept=By.id("acceptBtn");//接受按钮
    public static By cancel=By.xpath("//*[@id='dataTables']/tbody/tr/td[19]/button[1]");//第一个订单的取消
    public static By confirm=By.id("deleteConfirmBtn");//确定
    public static By createmailorder=By.xpath("//*[@id=\"main-content\"]/section/div[1]/div/section/header/span[3]/button");//邮件批量上传
    public static By noacceptordercancel=By.xpath("//*[@id=\"dataTables\"]/tbody/tr/td[19]/button[3]");//未接受订单取消
    public static By mailselectfile=By.id("batchMail");//邮件批量上传的选择文件
    public static By mailsubmit=By.id("batchUploadMailBtn");//邮件批量上传的提交



}
