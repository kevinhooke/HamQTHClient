package kh.hamqthclient.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * <pre>
 * 
 * </pre>
 * @author kev
 *
 */

//<?xml version="1.0"?>
//<HamQTH version="2.0" xmlns="http://www.hamqth.com">
//<search>
//	<callsign>kk6dct</callsign>
//	<nick>Kevin</nick>
//	<qth>Davis</qth>
//	<country>United States</country>
//	<adif>291</adif>
//	<qsl_via>Direct</qsl_via>
//	<itu>6</itu>
//	<cq>3</cq>
//	<grid>CM98DN</grid>
//	<adr_name>Kevin J Hooke</adr_name>
//	<adr_street1></adr_street1>
//	<adr_city>Davis</adr_city>
//	<adr_zip>95617</adr_zip>
//	<adr_country>United States</adr_country>
//	<adr_adif>291</adr_adif>
//	<us_state>CA</us_state>
//	<us_county>Yolo</us_county>
//	<lotw>Y</lotw>
//	<qsl>Y</qsl>
//	<eqsl>Y</eqsl>
//	<birth_year></birth_year>
//	<lic_year>2013</lic_year>
//	<latitude>38.5449065</latitude>
//	<longitude>-121.7405167</longitude>
//	<continent>NA</continent>
//	<utc_offset>8</utc_offset>
//	<lookups>39</lookups>
//	<registered>Y</registered>
//</search>
//</HamQTH>

@XmlRootElement
public class Search {

	private String callsign;
	private String nick;
	private String qth;
	private String grid;
	private String latitude;
	private String longitude;
	
	public Search()
	{
		
	}

	@XmlElement(name="callsign", namespace="http://www.hamqth.com")
	public String getCallsign() {
		return callsign;
	}

	public void setCallsign(String callsign) {
		this.callsign = callsign;
	}

	@XmlElement(name="nick", namespace="http://www.hamqth.com")
	public String getNick() {
		return nick;
	}

	public void setNick(String nick) {
		this.nick = nick;
	}

	@XmlElement(name="qth", namespace="http://www.hamqth.com")
	public String getQth() {
		return qth;
	}

	public void setQth(String qth) {
		this.qth = qth;
	}

	@XmlElement(name="grid", namespace="http://www.hamqth.com")
	public String getGrid() {
		return grid;
	}

	public void setGrid(String grid) {
		this.grid = grid;
	}

	@XmlElement(name="latitude", namespace="http://www.hamqth.com")
	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	@XmlElement(name="longitude", namespace="http://www.hamqth.com")
	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
	
}
