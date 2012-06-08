package de.ct.client.reader;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;

import org.apache.http.HttpResponse;
import org.apache.http.ParseException;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.util.EntityUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import de.ct.shared.Participation;

public class ParticipationReader {
	
	private HttpClient client = new DefaultHttpClient();
	private HttpPost post;
	private HttpResponse response;
	private List<Participation> participations;

	public void initConnection(final String aUrlString) {
		post = new HttpPost(aUrlString);
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

	private List<Participation> evaluateServerResponse() {
		List<Participation> participations = new ArrayList<Participation>();
		String responseBody = null;
		try {
			responseBody = EntityUtils.toString(response.getEntity());
		} catch (ParseException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(responseBody);
		participations = unmarshall(responseBody);
		
		return participations;
	}
	



	
	protected List<Participation> getProduct(final long aId) {
		write(aId);
		participations = evaluateServerResponse();
		return participations;
	}


	public List<Participation> readParticipationsForEventId(final long aEventId) {
		initConnection("http://10.0.2.2:8080/ctBackend/ctParticipation/readParticipationsForEventId");
		List<Participation> participations = getParticipations(aEventId);
		return participations;
	}

	public List<Participation> readParticipationsForUserId(final long aUserId) {
		initConnection("http://10.0.2.2:8080/ctBackend/ctParticipation/readParticipationsForUserId");
		List<Participation> participations = getParticipations(aUserId);
		return participations;
	}

	protected List<Participation> getParticipations(final long aId) {
		write(aId);
		List<Participation> participations = evaluateServerResponse();
		return participations;
	}

	
	public List<Participation> unmarshall(final String aJson) {
		ObjectMapper mapper = new ObjectMapper();
		mapper.configure(
				DeserializationConfig.Feature.FAIL_ON_UNKNOWN_PROPERTIES, false);
		List<Participation> participations = null;
		try {
			participations = mapper.readValue(aJson,
					new TypeReference<List<Participation>>() {
					});
		} catch (JsonParseException e) {
			e.printStackTrace();
		} catch (JsonMappingException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return participations;
	}

}
