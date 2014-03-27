package kh.hamqthclient;

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
		HamQTHSearch response = hamQTHClient.lookupCallsign("kk6dct");
		System.out.println(response);
	}

}
