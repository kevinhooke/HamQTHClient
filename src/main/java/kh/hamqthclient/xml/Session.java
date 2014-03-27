package kh.hamqthclient.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Session {

	private String sessionId;

	@XmlElement(name="session_id", namespace="http://www.hamqth.com")
	public String getSessionId() {
		return sessionId;
	}


	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	
	
}
