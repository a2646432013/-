package ATMProgram;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class User {
	  private double balance;//用户账户金额
	  private String id;//用户账号名
	  private String passward;//用户密码
	  private List<String> list=new ArrayList<String>() ;//用于存储用户取款记录的日志集合
	   
	  //无参构造方法
	  public User() {
	    super();
	  }
	  //有参构造方法
	  public User(String id, String passward,double money) {
	    super();
	    this.balance = money;
	    this.id = id;
	    this.passward = passward;
	  }
	   
	  //各个属性的set和get方法
	  public double getMoney() {
	    return balance;
	  }
	  public void setMoney(int money) {
	    this.balance = money;
	  }
	  public String getAccount() {
	    return id;
	  }
	  public void setAccount(String account) {
	    this.id = account;
	  }
	  public String getPassward() {
	    return passward;
	  }
	  public void setPassward(String passward) {
	    this.passward = passward;
	  }
	  public List<String> getList() {
	    return list;
	  }
	  public void setList(List<String> list) {
	    this.list = list;
	  }
	  public double getBalance() {
	    return balance;
	  }
	  public void setBalance(double balance) {
	    this.balance = balance;
	  }
	   
	  /**
	   * 因为账户的密码被装在map集合中，不方便直接访问，所以在User类中定义一个检查密码是否正确的方法
	   * 其返回一个布尔类型的值
	   * @param password
	   * @return
	   */
	  public boolean checkPassword(String password){
	    if(password.equals(this.passward)){
	      return true;
	    }else{
	      return false;
	    }
	  }
	   
	   
	  /**
	   * 与上面的方法同理，判断取款金额是否合理的方法，返回一个布尔类型的值
	   * @param money
	   * @return
	   * @throws Exception
	   */
	  public boolean getMoney(double money) throws Exception {
	 
	    if (money < 100 || money > 5000) {  //规定每次取款金额的范围，超过这个范围则抛出异常
	      throw new Exception("取款金额不合理！取款金额必须大于100，小于5000");
	    }
	    if (this.balance < money) {//这个判断条件被许多人忽略，当账户内余额不足时，抛出异常
	      throw new Exception("您的余额不足！");
	    }
	    //从帐号余额中扣除相应金额
	    this.balance -= money;
	     
	    //将取款记录到日志中
	    String logStr = User.currentTime()+"\t取款 " + money +"元， 余额："+this.balance;
	    this.list.add(logStr);  //将记录添加进list集合中
	    return true;  //返回true
	     
	  }
	  /**
	   * 获取当前时间的方法
	   * @return
	   */
	  public static String currentTime(){
	    long ct = System.currentTimeMillis();
	    Date d = new Date(ct);
	    SimpleDateFormat sdf = new SimpleDateFormat("yyyy年MM月dd日 HH:ss:mm");
	    return sdf.format(d);
	  }
	}
