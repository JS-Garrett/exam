package org.hnjk.util;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.List;

import org.apache.http.HttpEntity;
import org.apache.http.NameValuePair;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

@Component
public class HttpClientUtil {
	
	private static Logger logger = LoggerFactory.getLogger(FTPUtil.class);
	
	
	
	public static String getContent(String url, List<NameValuePair> params) {
		CloseableHttpClient httpclient = HttpClients.createDefault();

		HttpPost httpPost = new HttpPost(url);
		
		try {
			httpPost.setEntity(new UrlEncodedFormEntity(params));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		
		try (CloseableHttpResponse response = httpclient.execute(httpPost)){
		    HttpEntity entity = response.getEntity();
		    String content = EntityUtils.toString(entity,"UTF-8");
		    return content;
		} catch (IOException  e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public static byte[] getHeadImage(String url) {
		CloseableHttpClient httpclient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(url);
		
		try(CloseableHttpResponse response = httpclient.execute(httpGet)) {
			HttpEntity entity = response.getEntity();
			
			byte[] imgByte = HQCodec.hexDecode(EntityUtils.toString(entity));
			
			return imgByte;
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
}
