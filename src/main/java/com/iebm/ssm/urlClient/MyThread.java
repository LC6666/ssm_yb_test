package com.iebm.ssm.urlClient;

public class MyThread implements Runnable{
	private String startCreateTime;
	private String endCreateTime;
	private String menuName;
	
	public MyThread(String startCreateTime,String endCreateTime,String menuName) {
		// TODO Auto-generated constructor stub
		this.startCreateTime = startCreateTime;
		this.endCreateTime = endCreateTime;
		this.menuName = menuName;
	}
	
	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
		if(menuName.equals("binglichaxun")) {
			BingLiChaXun binglichaxun = new BingLiChaXun(startCreateTime,endCreateTime);
			
				binglichaxun.savePerPages(binglichaxun.getPerPages(binglichaxun.setDefaultValuePair(0)));
			
			}
		if(menuName.equals("yidianchaxun")) {
			YiDianChaXun yidianchaxun = new YiDianChaXun(startCreateTime,endCreateTime);
				yidianchaxun.savePerPages(yidianchaxun.getPerPages(yidianchaxun.setDefaultValuePair(0)));
			
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
	}
}



