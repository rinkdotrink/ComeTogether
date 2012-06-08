package de.ct.client.creator;

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

import de.ct.client.helper.Marshaller;
import de.ct.shared.Product;

public abstract class Creator {

	private HttpClient client = new DefaultHttpClient();
	private Marshaller marshaller = new Marshaller();
	private HttpPost post;
	private Product productReturn = null;
	private HttpResponse response;

	public void initConnection(final String aUrlString) {
		post = new HttpPost(aUrlString);
	}

	public Product writeProduct(final Product aProduct) {
		write(aProduct);
		Product product = evaluateServerResponse(aProduct);
		return product;
	}

	private void write(final Product aProduct) {
		String product = marshaller.marshall(aProduct);
		try {
			post.setEntity(new StringEntity(product));
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

	private Product evaluateServerResponse(final Product aProduct) {
		String responseBody = null;
		try {
			responseBody = EntityUtils.toString(response.getEntity());
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(responseBody);
		productReturn = marshaller.unmarshall(responseBody, aProduct);
		return productReturn;
	}

}
