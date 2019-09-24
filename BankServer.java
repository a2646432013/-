package ATMProgram;

import java.util.HashMap;
import java.util.Map;

import javax.swing.JOptionPane;

public class BankServer {
	  //声明四个常量表示账户用户名
	  final String ID1 = "10010";
	  final String ID2 = "10011";
	  final String ID3 = "10012";
	  final String ID4 = "10013";
	  //声明四个常量，用于存储密码，每个账户有一个专属的密码
	  final String PASSWORD1 = "123456";
	  final String PASSWORD2 = "123456";
	  final String PASSWORD3 = "123456";
	  final String PASSWORD4 = "123456";
	 
	  //声明一个静态常量规定初始金额为100000元
	  public static final Double BALANCE = 100000.00;
	   
	  //创建一个map集合用于存储用户账号和对应的账户信息
	  Map<String, User> map = new HashMap<String,User>();
	   
	  /**
	   * 生成用户的方法，将用户存入map集合中
	   */
	  public void creatAccount(){
	    map.put(ID1, new User(ID1,PASSWORD1,BALANCE));
	    map.put(ID2, new User(ID2,PASSWORD2,BALANCE));
	    map.put(ID3, new User(ID3,PASSWORD3,BALANCE));
	    map.put(ID4, new User(ID4,PASSWORD4,BALANCE));
	  }
	   
	  /**
	   * 比较用户从控制台输入的数据是否和银行预先存储的账户一样
	   * @param id
	   * @param password
	   * @return
	   * @throws Exception
	   */
	  public User chick(String id,String password) throws Exception{
	    User Account = null;  //此时的Account对象为null
	    //密码已经被放进map集合中，不好取出,所以需要在User类中定义一个checkPassword方法，其返回的是布尔类型的值（详情见User类）
	    boolean op= (map.containsKey(id)&&
	    		map.get(id).checkPassword(password)
	    );
	    if(op=true) {Account=map.get(id);
	    	JOptionPane.showMessageDialog(null, "登录成功，正在跳转页面");
	    }else {
	    	JOptionPane.showMessageDialog(null, "账户或密码错误");
	    }
	    return Account;    //返回一个Account对象
	  } 
	  /**
	   * 这是一个取钱并将记录存入list集合的方法
	   * @param loginUA
	   * @param money
	   */
	  public void getMoney(User user, double money) {
	    try {
	      //用户余额已经被放进map集合中，同理,在User类中定义一个getMoney()方法，其返回的是布尔类型的值
	      if(user.getMoney(money)){
	        System.out.println("取款成功，用户当前余额："+user.getBalance());
	        System.out.println("==============================");
	        //输出日志
	        for (String str : user.getList()) {
	          System.out.println(str);
	        }
	      }
	    } catch (Exception e) {
	      System.out.println(e.getMessage());
	    }
	  }
	  public void changePassword(String id,String oldpassword,String newpassword)throws Exception {
		  User Account=null;
		  if(map.containsKey(id)) {
			  Account=map.get(id);
		  }
		  if(Account.checkPassword(oldpassword)) {
			  
			  map.put(id, new User(id,newpassword,BALANCE));
			  System.out.println("密码已重置，请重新登录");
		  }else {
			  throw new Exception("输入密码错误，修改失败");
		  }
	  }
}
