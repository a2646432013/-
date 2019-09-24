package ATMProgram;
import java.util.Scanner;
import java.util.HashMap;
import java.util.Map;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

 

/**
 * 银行的服务类，实现用户的创建
 * @Carraway 
 *
 */
 
 public class Manager {
   public static void main(String[] args)throws Exception {
	Scanner input = new Scanner(System.in);
    Scanner Ninput=new Scanner(System.in);  
     //创建BankServer()类对象
     BankServer server = new BankServer();
     //创建User类对象，先令其为空
     User user = null;
     //调用creatAccount()方法生成四个用户
     server.creatAccount();
      
     //while循环控制流程
     if(true){
    	 System.out.println("========ATM========");
       System.out.println("请输入您的账号：");
       String id = input.nextLine();
       System.out.println("请输入您的密码：");
       String password = Ninput.nextLine();
       try{  
    	 user=server.chick(id, password);//调用chick()方法，让user有意义
         System.out.println("===========欢迎进入ATM取款系统===========");
         System.out.println("【1】查询余额");
         System.out.println("【2】存款取款业务");
         System.out.println("【3】修改个人密码");
         System.out.println("【4】退出系统");
         System.out.println("请选择操作选项：");
         int temp=input.nextInt();
         switch(temp) {
         case 1:
         System.out.println("您的账户余额为："+user.getMoney()+"￥");
         break;
         case 2:{
         while(true){
           System.out.println("请输入您的取款金额（必须大于100￥，小于30000￥）：");
           double money = input.nextDouble();
           server.getMoney(user, money);
           input.nextLine();
           System.out.println("请问您需要继续取款吗？ “是” 或 “否”");
           String selec = input.nextLine();
           if(selec.equalsIgnoreCase("否")){
             System.out.println("欢迎使用！");
         }break;
         }
         }
        
         case 3:
        	 while(true) {
        		 System.out.println("请输入旧密码：");
        		 String oldPassword=input.next();
        		 System.out.println("请输入新密码：");
        		 String newPassword=input.next();
        		 server.changePassword(id,oldPassword,newPassword);
        	/** System.out.println("您是否要重新登陆？请选择“ 是 ”或 “否”");
             String selec = input.nextLine();
             switch(selec) {
             case "是":
               System.out.println("已退出程序，再见");
               break;
             case "否":
            	 System.out.println("转载界面中......");
            	 break;
             }**/
             break;
        	 }
         case 4:
        	 System.out.println("已退出程序，再见");
        	 break;
         }
       } catch (Exception e) {
         System.out.println(">>> 账号/密码错误！请重新登录输入 <<<");
       }
     }
   }
 }
  
 

