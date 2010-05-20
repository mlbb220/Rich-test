
package rich.httpclient;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.methods.GetMethod;

import rich.util.TestUtil;

public class TestHttlpClient {

	public void getFromUrl(){
		String url = "http://richnesttest.appspot.com/api/statuses/public_timeline.json";
		HttpClient client = new HttpClient();
		GetMethod getMethod = new GetMethod(url);
		try {
			
			int statecode = client.executeMethod(getMethod);
			if(statecode != 200){
				TestUtil.printLog("error with code:" + statecode);
			}else{
				BufferedReader is = new BufferedReader(new InputStreamReader(getMethod.getResponseBodyAsStream()));
				String line ;
				while()
			}
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
