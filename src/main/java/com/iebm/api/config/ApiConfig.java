package com.iebm.api.config;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.Document;
import org.dom4j.DocumentException;
import org.dom4j.Element;
import org.dom4j.io.SAXReader;

import okhttp3.internal.http2.Header;

public class ApiConfig {
	
	private String rootUrl;
	private Map<String,String> headers = new HashMap<String,String>();
	private Map<String,String> params = new HashMap<String,String>();
	
	public ApiConfig(String configFilePath) throws DocumentException{
		SAXReader reader = new SAXReader();
		Document documet = reader.read(configFilePath);
		Element rootElement = documet.getRootElement();
		
		rootUrl = rootElement.element("rootUrl").getTextTrim();
		
		@SuppressWarnings("unchecked")
		List<Element> headersElements = rootElement.element("headers").elements("header");
		headersElements.forEach((header)->{
			headers.put(header.attributeValue("name"), header.attributeValue("value"));
			});
		
		@SuppressWarnings("unchecked")
		List<Element> paramsElements = rootElement.element("params").elements("param");
		paramsElements.forEach((param)->{
			params.put(param.attributeValue("name"), param.attributeValue("value"));
			});
		
	}

	public String getRootUrl() {
		return rootUrl;
	}

	public Map<String, String> getHeaders() {
		return headers;
	}

	public Map<String, String> getParams() {
		return params;
	}


	
	

}
