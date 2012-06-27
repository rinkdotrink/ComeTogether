package de.ct.client.login;

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
import de.ct.shared.User;

public abstract class Login {

	private HttpClient client = new DefaultHttpClient();
	private HttpPost post;
	private HttpResponse response;
	private Marshaller marshaller = new Marshaller();

	public void initConnection(final String aUrlString) {
		post = new HttpPost(aUrlString);
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
		Marshaller marshaller = new Marshaller();
		Product product = marshaller.unmarshall(responseBody, aProduct);
		return product;
	}

	
	protected Product getProduct(final User aUser, final Product aProduct) {
		write(aUser);
		Product product = evaluateServerResponse(aProduct);
		return product;
	}

}
