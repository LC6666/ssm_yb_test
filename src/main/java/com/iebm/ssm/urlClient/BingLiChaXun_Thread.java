package com.iebm.ssm.urlClient;

public class BingLiChaXun_Thread extends Thread{
	
	
	private BingLiChaXun_FeesDetail bd;
	private int method_index=0;
	
	public BingLiChaXun_Thread(BingLiChaXun_FeesDetail d,int method_index) {
		// TODO Auto-generated constructor stub
		this.bd = d;
		this.method_index = method_index;
	}
	public void getMethod() throws Exception {
		if(method_index==1) {
			bd.getDrugFeesDetail();
		}
		if(method_index==2) {
			bd.getInspectionFeesDetail();		
		}
		if(method_index==3) {
			bd.getCureFeesDetail();
		}
		if(method_index==4) {
			bd.getMaterialsFeesDetail();
		}
		if(method_index==5) {
			bd.getOtherFeesDetail();
		}
	}


	@Override
	public void run() {
		// TODO Auto-generated method stub
		try {
			getMethod();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	

	

}




