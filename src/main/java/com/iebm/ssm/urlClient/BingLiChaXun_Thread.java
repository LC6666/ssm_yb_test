package com.iebm.ssm.urlClient;import java.util.Map;public class BingLiChaXun_Thread extends Thread{		private Map infoMap;	private int method_index=0;		public BingLiChaXun_Thread(Map infoMap,int method_index) {		// TODO Auto-generated constructor stub		this.infoMap = infoMap;		this.method_index = method_index;	}	public void getMethod() throws Exception {		if(1<= method_index&&method_index<=6) {			BingLiChaXun_FeesDetail bd = new BingLiChaXun_FeesDetail(infoMap);			if(method_index==1) {				bd.getDrugFeesDetail();			}			if(method_index==2) {				bd.getInspectionFeesDetail();					}			if(method_index==3) {				bd.getCureFeesDetail();			}			if(method_index==4) {				bd.getMaterialsFeesDetail();			}			if(method_index==5) {				bd.getOtherFeesDetail();			}			if(method_index==6) {				new BingLiChaXun_info().cureInfoJointforHis(infoMap);			}		}			}	@Override	public void run() {		// TODO Auto-generated method stub		try {			getMethod();		} catch (Exception e) {			// TODO Auto-generated catch block			System.out.println(infoMap.get("sicode").toString());			e.printStackTrace();		}	}			}