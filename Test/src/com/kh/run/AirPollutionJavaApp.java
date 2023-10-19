package com.kh.run;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

public class AirPollutionJavaApp {
	
	public static final String serviceKey = "agiuUdLsVNZz0LQVohUAXEFqoudHAhEb67Xh/cYgAjuSFvr84K/bNQwUi3b7UhROrcQL8pFd9dC8szPBlgWD3g==";
	
	public static void main(String[] args) throws IOException {
		
		String url = "https://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getMinuDustFrcstDspth";
		
		url += "?serviceKey=" + "서비스키";
		url += "&sideName=" + URLEncoder.encode("서울", "UTF-8");
		url += "&returnType=json";
		
		URL requestUrl = new URL(url);
		HttpURLConnection urlConnection = (HttpURLConnection) requestUrl.openConnection();
		urlConnection.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConnection.getInputStream()));
		String line = null;
		while((line = br.readLine()) != null) {
			System.out.println(line);
		}
		br.close();
		urlConnection.disconnect();
	}
}
