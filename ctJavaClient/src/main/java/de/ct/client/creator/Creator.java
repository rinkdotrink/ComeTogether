package de.ct.client.creator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import de.ct.client.helper.Marshaller;
import de.ct.shared.Product;

public abstract class Creator {

	protected HttpURLConnection conn = null;
	private Marshaller marshaller = new Marshaller();

	protected void initConnection(final String aUrlString) {
		URL url = null;
		try {
			url = new URL(aUrlString);
		} catch (MalformedURLException e) {
			e.printStackTrace();
		}
		try {
			conn = (HttpURLConnection) url.openConnection();
		} catch (IOException e) {
			e.printStackTrace();
		}
		conn.setDoOutput(true);
		try {
			conn.setRequestMethod("POST");
		} catch (ProtocolException e) {
			e.printStackTrace();
		}
		conn.setRequestProperty("Content-Type", "application/json");
	}

	protected void write(final Product aProduct) {
		String json = marshaller.marshall(aProduct);
		OutputStream os = null;
		try {
			os = conn.getOutputStream();
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			os.write(json.getBytes());
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			os.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		conn.disconnect();
	}

	protected Product evaluateServerResponse(final Product aProduct) {
		Product product = null;
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
				product = marshaller.unmarshall(output, aProduct);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return product;
	}

	protected Product writeProduct(final Product aProduct) {
		write(aProduct);
		Product product = evaluateServerResponse(aProduct);
		return product;
	}

}
