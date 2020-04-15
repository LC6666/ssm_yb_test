package com.iebm.api.test;

import java.nio.file.Paths;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import com.iebm.ssm.util.Log;

public class ApiTest {
	
	@Parameters("envName")
	@BeforeSuite
	public void init(@Optional("api-config.xml")String envName){
		String configFilePath = Paths.get(System.getProperty("user.dir"), envName).toString();
		System.out.println("user.dir="+configFilePath);
//		Log.info("api config path:"+configFilePath);
		
		
	}
	
	@Test
	public void apiTest(){
		System.out.println("apiTest");
	}
}
