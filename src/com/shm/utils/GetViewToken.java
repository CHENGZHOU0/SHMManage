package com.shm.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;

public class GetViewToken {
	public static String get(String fileId) throws IOException {
		//√ÿ‘ø
		String AppKey = "QD9UvwxQLTNl7L4xXuw275KCx4fYIlsG";
		//√‹¬Î
		String AppSecret = "8PlgtpxVaOuPBbXzYzqY1MOj5rYxukjY";
		//Header
		String Header = AppKey + ":" + AppSecret;
		//«Î«Ûpath
		String AccessTokenUrl = "https://api.bimface.com/oauth2/token";	
		
		try {
			Header ="Basic" + " " + Base64.getEncoder().encodeToString(Header.getBytes("utf-8"));
		} catch (UnsupportedEncodingException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		
		URL restURL = new URL(AccessTokenUrl);
		
	    HttpURLConnection conn = (HttpURLConnection) restURL.openConnection();
	    conn.setRequestMethod("POST");
	    conn.setRequestProperty("Authorization", Header);
	    conn.setDoOutput(true);
	    
	    BufferedReader br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    String line;
	    String AccessToken = null;
	    
	    while((line = br.readLine()) != null ){
	    	//System.out.println(line);
	    	JSONObject jsonObject = JSON.parseObject(line);
	    	AccessToken = (String) ((JSONObject) jsonObject.get("data")).get("token");
		}
		    
		br.close();
		
		String ViewTokenUrl = "https://api.bimface.com/view/token?fileId="+fileId;
	    Header = "bearer " + AccessToken;
	    		
	    restURL = new URL(ViewTokenUrl);;
		
	    conn = (HttpURLConnection) restURL.openConnection();
	    conn.setRequestMethod("GET");
	    conn.setRequestProperty("Authorization", Header);
	    
	    conn.setRequestProperty("Content-Type", "application/Json; charset=UTF-8");
	    conn.setDoOutput(true);
	    
	    br = new BufferedReader(new InputStreamReader(conn.getInputStream()));
	    
	    String viewtoken = null;
	    
	    while((line = br.readLine()) != null ){
	    	//System.out.println(line);
		    JSONObject jsonObject = JSON.parseObject(line);
			viewtoken = (String) jsonObject.get("data");
			//System.out.println(viewtoken);
		}
	    
		return viewtoken;
		
	}
}
