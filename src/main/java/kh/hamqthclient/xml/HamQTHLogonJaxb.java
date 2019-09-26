package kh.hamqthclient.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="HamQTH", namespace="http://www.hamqth.com")
public class HamQTHLogonJaxb {

	private Session session;

	//TODO: note error when ns not defined on element
	/*
	 * DefaultValidationEventHandler: [ERROR]: unexpected element (uri:"http://ns-url", local:"element name").
	 */
	@XmlElement(name="session", namespace="http://www.hamqth.com")
	public Session getSession() {
		return session;
	}

	public void setSession(Session session) {
		this.session = session;
	}

	
}
