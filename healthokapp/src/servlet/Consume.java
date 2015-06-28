package servlet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
 
public class Consume {
 
	// http://localhost:8080/RESTfulExample/json/product/get
	public static void main(String[] args) {
 
	  try {
 
		URL url = new URL("http://www.google.com/url?q=http%3A%2F%2Fwww.medindia.net%2Fincludes-rwd%2Fwidgets%2Fdrug-price%2Fgetdrugs-ge.asp%3Ftxt%3Dcrocin&sa=D&sntz=1&usg=AFQjCNEB8s2XFwr9PqZcffOVvTahlG3gOw");
		HttpURLConnection conn = (HttpURLConnection) url.openConnection();
		conn.setRequestMethod("GET");
		conn.setRequestProperty("Accept", "application/json");
 
		if (conn.getResponseCode() != 200) {
			throw new RuntimeException("Failed : HTTP error code : "
					+ conn.getResponseCode());
		}
 
		BufferedReader br = new BufferedReader(new InputStreamReader(
			(conn.getInputStream())));
 
		String output;
		System.out.println("Output from Server .... \n");
		while ((output = br.readLine()) != null) {
			System.out.println(output);
		}
 
		conn.disconnect();
 
	  } catch (MalformedURLException e) {
 
		e.printStackTrace();
 
	  } catch (IOException e) {
 
		e.printStackTrace();
 
	  }
 
	}
 
}
