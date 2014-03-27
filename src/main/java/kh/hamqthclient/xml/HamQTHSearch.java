package kh.hamqthclient.xml;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="HamQTH", namespace="http://www.hamqth.com")
public class HamQTHSearch {
	
	private Search search;


	public HamQTHSearch()
	{
		
	}
	@XmlElement(name="search", namespace="http://www.hamqth.com")
	public Search getSearch() {
		return this.search;
	}

	public void setSearch(Search search) {
		this.search = search;
	}
	
}
