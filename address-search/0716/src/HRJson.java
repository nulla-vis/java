

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLEncoder;
import java.nio.charset.Charset;

import org.apache.catalina.connector.Response;

import com.google.gson.Gson;
import com.google.gson.stream.JsonReader;
import com.heartrails.HeartRails;

public class HRJson {
	public static com.heartrails.Response search(String key) {
		System.out.println(key.length());
		String params = null;
		if(key.matches("\\d{7}") ) {
			key = URLEncoder.encode(key, Charset.defaultCharset());
			params = "method=searchByPostal&postal="+key;
			
			System.out.println("postal");
		}else {
			key = URLEncoder.encode(key, Charset.defaultCharset());
			params = "method=suggest&matching=like&keyword="+key;
			System.out.println("keyword");
		}
		HttpURLConnection conn = null;
		com.heartrails.Response response = null;
		
		try {
			URL url = new URL ("http://geoapi.heartrails.com/api/json?" + params);
			conn = (HttpURLConnection)url.openConnection();
			conn.connect();
			InputStream in = conn.getInputStream();
			BufferedReader br = new BufferedReader(new InputStreamReader(in,"utf-8"));
			Gson gson = new Gson();
			JsonReader jr = new JsonReader(br);
			HeartRails obj = gson.fromJson(jr,HeartRails.class);
			response = obj.getResponse();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
				
		return response;
	}
}
