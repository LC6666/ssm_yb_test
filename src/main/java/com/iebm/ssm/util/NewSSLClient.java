package com.iebm.ssm.util;

import java.net.URI;
import java.security.KeyManagementException;
import java.security.NoSuchAlgorithmException;
import java.security.cert.CertificateException;
import java.security.cert.X509Certificate;
import java.util.Arrays;

import javax.net.ssl.SSLContext;
import javax.net.ssl.TrustManager;
import javax.net.ssl.X509TrustManager;

import org.apache.http.Header;
import org.apache.http.HeaderIterator;
import org.apache.http.HttpHost;
import org.apache.http.ProtocolVersion;
import org.apache.http.RequestLine;
import org.apache.http.client.HttpClient;
import org.apache.http.client.config.AuthSchemes;
import org.apache.http.client.config.CookieSpecs;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.HttpRequestBase;
import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.config.Registry;
import org.apache.http.config.RegistryBuilder;
import org.apache.http.conn.socket.ConnectionSocketFactory;
import org.apache.http.conn.socket.PlainConnectionSocketFactory;
import org.apache.http.conn.ssl.NoopHostnameVerifier;
import org.apache.http.conn.ssl.SSLConnectionSocketFactory;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.impl.conn.PoolingHttpClientConnectionManager;
import org.apache.http.params.HttpParams;

import okhttp3.internal.http.HttpMethod;

public class NewSSLClient {
	
public static HttpClient SSLClient() throws NoSuchAlgorithmException, KeyManagementException {
		
		X509TrustManager trustManager = new X509TrustManager() {

			@Override
			public X509Certificate[] getAcceptedIssuers() {
				// TODO Auto-generated method stub
				return null;
			}

			@Override
			public void checkServerTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				// TODO Auto-generated method stub

			}

			@Override
			public void checkClientTrusted(X509Certificate[] chain, String authType) throws CertificateException {
				// TODO Auto-generated method stub

			}
		};

		SSLContext ctx = SSLContext.getInstance(SSLConnectionSocketFactory.TLS);
		ctx.init(null, new TrustManager[] { trustManager }, null);
		SSLConnectionSocketFactory soketFactory = new SSLConnectionSocketFactory(ctx, NoopHostnameVerifier.INSTANCE);

		// 创建Registry
		RequestConfig requestConfig = RequestConfig.custom().setCookieSpec(CookieSpecs.STANDARD_STRICT)
				.setExpectContinueEnabled(Boolean.TRUE)
				.setTargetPreferredAuthSchemes(Arrays.asList(AuthSchemes.NTLM, AuthSchemes.DIGEST))
				.setProxyPreferredAuthSchemes(Arrays.asList(AuthSchemes.BASIC)).build();
		Registry<ConnectionSocketFactory> socketFactoryRegistry = RegistryBuilder.<ConnectionSocketFactory>create()
				.register("http", PlainConnectionSocketFactory.INSTANCE).register("https", soketFactory).build();

		// 创建ConnectionManager，添加Connection配置信息
		PoolingHttpClientConnectionManager connectionManager = new PoolingHttpClientConnectionManager(
				socketFactoryRegistry);
		CloseableHttpClient closeableHttpClient = HttpClients.custom().setConnectionManager(connectionManager)
				.setDefaultRequestConfig(requestConfig).build();

		return closeableHttpClient;
		
	}



	/**
	 * 设置代理
	 * @param method 请求方法
	 * @param proxyIp IP地址
	 * @param proxyPort 代理端口
	 * @return
	 */
	public static HttpRequestBase setProxy(HttpRequestBase method,String proxyIp,int proxyPort) {
		
		CloseableHttpClient httpClient = HttpClients.createDefault();
		
		HttpHost proxy = new HttpHost(proxyIp,proxyPort,"http");
		
		RequestConfig requestConfig=RequestConfig.custom().setProxy(proxy).build();
		
		method.setConfig(requestConfig);
		
		return method;
	}

}
