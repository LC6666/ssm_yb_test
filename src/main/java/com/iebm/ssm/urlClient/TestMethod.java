package com.iebm.ssm.urlClient;

public class TestMethod {
	
	
	public static void main(String[] args) throws Exception {
		Login login = new Login();
        login.openLoginPage();
        if(login.loginURL()){
            
        	Thread thread1 =  new Thread(new MyThread("2020-07-01","2020-07-10", "yidianchaxun"));
    		Thread thread2 = new Thread(new MyThread("2020-07-11","2020-07-20", "yidianchaxun"));
    		Thread thread3 = new Thread(new MyThread("2020-07-21","2020-07-31", "yidianchaxun"));
    		
    		thread1.start();
    		thread2.start();
    		thread3.start();
            
//            System.out.println(bc.sum_totalFee_price.toString());
        }else {
            System.out.println("登录失败!退出请求!");
        }
		
		
	}
}
