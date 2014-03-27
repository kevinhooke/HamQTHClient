package kh.hamqthclient.xml;

import java.io.IOException;
import java.io.InputStream;
import java.lang.annotation.Annotation;
import java.lang.reflect.Type;

import javax.ws.rs.ProcessingException;
import javax.ws.rs.WebApplicationException;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.MultivaluedMap;
import javax.ws.rs.ext.MessageBodyReader;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Unmarshaller;

public class HamQTHMessageBodyReader implements MessageBodyReader<HamQTHLogonJaxb> {

	@Override
	public boolean isReadable(Class<?> type, Type genericType,
			Annotation[] annotations, MediaType mediaType) {
		return type == HamQTHLogonJaxb.class;
	}

	@Override
	public HamQTHLogonJaxb readFrom(Class<HamQTHLogonJaxb> type, Type genericType,
			Annotation[] annotations, MediaType mediaType,
			MultivaluedMap<String, String> httpHeaders, InputStream entityStream)
			throws IOException, WebApplicationException {

		try {
			JAXBContext jaxbContext = JAXBContext
					.newInstance(HamQTHLogonJaxb.class);
			Unmarshaller um = jaxbContext.createUnmarshaller();
			um.setEventHandler(new javax.xml.bind.helpers.DefaultValidationEventHandler());
			HamQTHLogonJaxb myBean = (HamQTHLogonJaxb) um.unmarshal(entityStream);
			return myBean;
		} catch (JAXBException jaxbException) {
			throw new ProcessingException("Error deserializing a HamQthLogon.",
					jaxbException);
		}
	}

}
