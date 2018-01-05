package gov.dot.its.jpo.sdcsdw.message_validator_webapp.rest;

import java.io.FileNotFoundException;
import java.lang.reflect.InvocationTargetException;
import java.net.MalformedURLException;
import java.util.Collections;
import java.util.List;

import org.codehaus.jettison.json.JSONException;
import org.junit.Test;

import gov.dot.its.jpo.sdcsdw.message_validator_webapp.rest.Configuration;
import gov.dot.its.jpo.sdcsdw.message_validator_webapp.rest.SemiValidator;
import gov.dot.its.jpo.sdcsdw.message_validator_webapp.rest.DecodeMessageResource.EncodeVersion;

public class ConfigurationTest {

	@Test
	public void test() throws JSONException, MalformedURLException, FileNotFoundException, SecurityException, IllegalArgumentException, ClassNotFoundException, NoSuchMethodException, IllegalAccessException, InvocationTargetException {
		Configuration configuration = new Configuration();
		SemiValidator validator = new SemiValidator();
		@SuppressWarnings("unchecked")
		List<String> messages = (List<String>)validator.getMessageTypes();
		configuration.addConfiguration(EncodeVersion.v23.getValue(), messages);
		Collections.sort(messages, Collections.reverseOrder());
		configuration.addConfiguration("2.4", messages);
		configuration.setDefaultIndex(1);
		System.out.println(configuration.toString(3));
	}

}
