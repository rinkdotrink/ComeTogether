package de.ct.client.deleter;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

public abstract class Deleter {
	
	protected HttpURLConnection conn;
	
	protected void initConnection(final String urlString) {
		String request = urlString;
		URL url = null;
		try {
			url = new URL(request);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}		
		try {
			conn = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		conn.setDoOutput(true);
		conn.setDoInput(true);
		conn.setInstanceFollowRedirects(false);
		try {
			conn.setRequestMethod("POST");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		conn.setRequestProperty("Content-Type",
				"application/x-www-form-urlencoded");
		conn.setRequestProperty("charset", "utf-8");
		conn.setUseCaches(false);
	}

	protected void write(final long aId) {
		String aIdString = String.valueOf(aId);
		String urlParameters = "param1=" + aIdString;
		conn.setRequestProperty("Content-Length",
				"" + Integer.toString(urlParameters.getBytes().length));
		DataOutputStream wr = null;
		try {
			wr = new DataOutputStream(conn.getOutputStream());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			wr.writeBytes(urlParameters);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			wr.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			wr.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		conn.disconnect();
	}

	protected void evaluateServerResponse() {
		try {
			if ((conn.getResponseCode() != HttpURLConnection.HTTP_CREATED)
					&& (conn.getResponseCode() != HttpURLConnection.HTTP_OK)) {
				throw new RuntimeException("Failed : HTTP error code : "
						+ conn.getResponseCode());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}

		BufferedReader br = null;
		try {
			br = new BufferedReader(new InputStreamReader(
					(conn.getInputStream())));
		} catch (IOException e) {
			e.printStackTrace();
		}
		String output;
		System.out.println("Output from Server .... \n");
		try {
			while ((output = br.readLine()) != null) {
				System.out.println(output);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
