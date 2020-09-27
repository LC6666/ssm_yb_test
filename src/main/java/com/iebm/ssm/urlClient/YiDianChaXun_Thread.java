package com.iebm.ssm.urlClient;

import java.util.Map;

public class YiDianChaXun_Thread extends Thread{
	
	
	private YiDianChaXun_FeesDetail yd;
	private int method_index=0;
	private Map infoMap;
	
	public YiDianChaXun_Thread(Map infoMap,int method_index) {
		// TODO Auto-generated constructor stub
		this.method_index = method_index;
		this.yd = new YiDianChaXun_FeesDetail(infoMap);
		this.infoMap = infoMap;
		
	}
	public void getMethod() throws Exception {
		if(method_index==1) {
			yd.getDrugFeesDetail();
		}
		if(method_index==2) {
			yd.getInspectionFeesDetail();		
		}
		if(method_index==3) {
			yd.getCureFeesDetail();
		}
		if(method_index==4) {
			yd.getMaterialsFeesDetail();
		}
		if(method_index==5) {
			yd.getOtherFeesDetail();
		}
		if(method_index==6) {
			YiDianChaXun_illegalInfo ydinfo = new YiDianChaXun_illegalInfo(infoMap);
			ydinfo.getIllegalInfo();
		}
		if(method_index==7) {
			YiDianChaXun_BasicInfo by = new YiDianChaXun_BasicInfo();
//			by.getBasicInfo(by.saveBasiInfo(infoMap.get("miid").toString()));
//			by.saveBasiInfo(infoMap.get("miid").toString());
			by.saveBasiInfo(by.getBasiInfo(infoMap.get("miid").toString()));
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




