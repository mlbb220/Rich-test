package rich.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpResponse;
import org.apache.http.auth.AuthScope;
import org.apache.http.auth.Credentials;
import org.apache.http.auth.UsernamePasswordCredentials;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.junit.Test;

import rich.util.TestUtil;

public class TestApacheHttpClient {

	@Test
	public void testGetPublicTimeline() {
		HttpClient client = new DefaultHttpClient();
		String url = "http://richnesttest.appspot.com/api/statuses/public_timeline.xml";
		HttpGet get = new HttpGet(url);
		try {
			HttpResponse response = client.execute(get);
			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF-8"));
				String line;
				while ((line = reader.readLine()) != null) {
					TestUtil.printLog("ling is " + new String(line.getBytes("UTF-8"),"UTF-8"));
				}
			} else {
				TestUtil.printLog("Response is error : " + statusCode);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@Test
	public void testGetDirectorMessage() {
		DefaultHttpClient client = new DefaultHttpClient();
		String url = "http://richnesttest.appspot.com/api/statuses/home_timeline.json?since_id=14401935261&count=200";
		HttpGet get = new HttpGet(url);
		String userId = "";
		String password = "";
		String base64String = new String(Base64.encodeBase64((userId + ":" + password).getBytes()));
		System.out.println(base64String);
		get.addHeader("Authorization", "Basic " + base64String);
		try {
			HttpResponse response = client.execute(get);

			int statusCode = response.getStatusLine().getStatusCode();
			if (statusCode == 200) {
				BufferedReader reader = new BufferedReader(new InputStreamReader(response.getEntity().getContent(),"UTF-8"));
				String line;
				while ((line = reader.readLine()) != null) {
					TestUtil.printLog("line is " + line);
				}
			} else {
				TestUtil.printLog("Response is error : " + statusCode);
			}
		} catch (ClientProtocolException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
