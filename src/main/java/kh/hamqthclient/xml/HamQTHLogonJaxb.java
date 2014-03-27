package kh.hamqthclient.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlSchema;

@XmlRootElement(name="HamQTH", namespace="http://www.hamqth.com")
public class HamQTHLogonJaxb {

	private Session session;

	//TODO: note error when ns not defined on element
	@XmlElement(name="session", namespace="http://www.hamqth.com")
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	
}
