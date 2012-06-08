package de.ct.client.deleter;

import java.io.IOException;
import java.io.UnsupportedEncodingException;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;

public abstract class Deleter {

	private HttpClient client = new DefaultHttpClient();
	private HttpPost post;
	private HttpResponse response;

	public void initConnection(final String aUrlString) {
		post = new HttpPost(aUrlString);
	}

	public void writeProduct(final long aId) {
		write(aId);
		evaluateServerResponse();
	}

	private void write(final long aId) {
		try {
			post.setEntity(new StringEntity(String.valueOf(aId)));
		} catch (UnsupportedEncodingException e1) {
			e1.printStackTrace();
		}
		try {
			response = client.execute(post);
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	private void evaluateServerResponse() {
		String responseBody = null;
		try {
			responseBody = EntityUtils.toString(response.getEntity());
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(responseBody);
	}
}
