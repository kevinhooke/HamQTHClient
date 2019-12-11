package kh.hamqthclient;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;

import kh.hamqthclient.xml.HamQTHLogonJaxb;
import kh.hamqthclient.xml.HamQTHMessageBodyReader;
import kh.hamqthclient.xml.HamQTHSearch;
import kh.hamqthclient.xml.HamQTHSearchMessageBodyReader;

public class HamQTHClient {

	private static final String PROGRAM_NAME = "KK6DCT_CALLSIGN_LOOKUP";
	private String sessionId;
	private WebTarget target;
	private Properties properties = new Properties();

	private void createLogonClient()
	{
		Client client = ClientBuilder.newBuilder().register(HamQTHMessageBodyReader.class).build();
		WebTarget target = client.target("http://www.hamqth.com").path("xml.php");
		this.target = target;
	}

	private void createSearchClient()
	{
		Client client = ClientBuilder.newBuilder().register(HamQTHSearchMessageBodyReader.class).build();
		WebTarget target = client.target("http://www.hamqth.com").path("xml.php");
		this.target = target;
	}

	public HamQTHSearch logon()
	{
		this.createLogonClient();
		HamQTHSearch logonSession = null;
		InputStream is = this.getClass().getClassLoader().getResourceAsStream("hamqthclient.properties");
		try
		{
			this.properties.load(is);
		}
		catch(IOException ioe)
		{
			throw new HamQTHClientPropertiesNotFoundException("Could not read properties file: hamqthclient.properties", ioe);
		}
		

		this.target.queryParam("u", (String)this.properties.get("usercallsign"))
				.queryParam("p", (String)this.properties.get("password"));
		

		Invocation.Builder requestBuilder = this.target.queryParam("u", (String)this.properties.get("usercallsign"))
				.queryParam("p", (String)this.properties.get("password")).request(MediaType.TEXT_HTML);
		
		//debug - return xml as a String
		//String resultXml = requestBuilder.get(String.class);
		//System.out.println(resultXml);
		
		//unmarshall xml to HamQTHLogonJaxb
		HamQTHLogonJaxb hamQTHLogon = requestBuilder.get(HamQTHLogonJaxb.class);

		System.out.println("sessionId: " + hamQTHLogon.getSession().getSessionId());
		this.sessionId = hamQTHLogon.getSession().getSessionId();
		
		return logonSession;
	}

	public HamQTHSearch lookupCallsign(String callsign) {
		this.createSearchClient();
		Invocation.Builder requestBuilder = buildGetRequest(callsign);

		//debug - return xml as a String
//		String resultXml = requestBuilder.get(String.class);
//		System.out.println(resultXml);

		HamQTHSearch result = requestBuilder.get(HamQTHSearch.class);
		
		//check for empty result, logon has timed out
		if(result.getSearch() == null) {
			System.out.println("WARN: HamQTHClient empty result, logon timed out?");
			//refresh logon call and retry 1 time
			this.logon();
			//rebuild request
			requestBuilder = buildGetRequest(callsign);
			result = requestBuilder.get(HamQTHSearch.class);
			if(result.getSearch() == null){
				System.out.println("ERROR: HamQTHClient result still null after logon refresh");
			}
			else {
				System.out.println("INFO: logon refreshed, search result returned ok");
			}
		}
		return result;
	}

	private Invocation.Builder buildGetRequest(String string) {
		Invocation.Builder requestBuilder = this.target.queryParam("id", this.sessionId)
				.queryParam("callsign", string)
				.queryParam("prg", PROGRAM_NAME)
				.request(MediaType.TEXT_HTML);
		return requestBuilder;
	}
	
}
