package de.ct.client.reader;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.util.ArrayList;
import java.util.List;

import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.DeserializationConfig;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;

import de.ct.shared.Participation;

public class ParticipationReader extends Reader {

	public List<Participation> readParticipationsForEventId(final long aEventId) {
		initConnection("http://localhost:8080/ctBackend/ctParticipation/readParticipationsForEventId");
		List<Participation> participations = getParticipations(aEventId);
		return participations;
	}

	public List<Participation> readParticipationsForUserId(final long aUserId) {
		initConnection("http://localhost:8080/ctBackend/ctParticipation/readParticipationsForUserId");
		List<Participation> participations = getParticipations(aUserId);
		return participations;
	}

	protected List<Participation> getParticipations(final long aId) {
		write(aId);
		List<Participation> participations = evaluateServerResponse();
		return participations;
	}

	protected List<Participation> evaluateServerResponse() {
		List<Participation> participations = new ArrayList<Participation>();
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
				participations = unmarshall(output);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
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
