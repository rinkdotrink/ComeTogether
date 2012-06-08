package de.ct.client.reader;

import java.io.BufferedReader;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;

import de.ct.client.helper.Marshaller;
import de.ct.shared.Product;

public abstract class Reader {

	protected HttpURLConnection conn;
	private Marshaller marshaller = new Marshaller();

	protected void initConnection(final String aUrlString) {
		String request = aUrlString;
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

	protected Product getProduct(final long aId, final Product aProduct) {
		write(aId);
		Product product = evaluateServerResponse(aProduct);
		return product;
	}

}
