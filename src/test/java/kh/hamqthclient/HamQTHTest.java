package kh.hamqthclient;

import static org.junit.Assert.*;
import kh.hamqthclient.xml.HamQTHSearch;

import org.junit.Test;

public class HamQTHTest {

	private HamQTHClient hamQTHClient = new HamQTHClient();

	@Test
	public void testLogon() {
		hamQTHClient.logon();

	}

	@Test
	public void testCallsignLookup() {
		hamQTHClient.logon();
		HamQTHSearch search = hamQTHClient.lookupCallsign("kk6dct");
		assertNotNull(search);
		assertNotNull("search element is null", search.getSearch());
		assertNotNull("callsign element is null", search.getSearch().getCallsign());
		assertNotNull("latitude is null", search.getSearch().getLatitude());
		assertNotNull("longitude is null", search.getSearch().getLongitude());
		System.out.println(search);
	}

	@Test
	public void testBadCallsignLookup() {
		hamQTHClient.logon();
		HamQTHSearch search = hamQTHClient.lookupCallsign("test1");
		assertNotNull(search);
		System.out.println(search);
	}

}
