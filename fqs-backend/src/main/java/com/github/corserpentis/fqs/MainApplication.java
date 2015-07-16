package com.github.corserpentis.fqs;

import java.io.IOException;
import java.io.InputStream;
import java.net.URL;
import java.util.Properties;

import javax.annotation.Nonnull;

import org.glassfish.hk2.utilities.binding.AbstractBinder;
import org.glassfish.jersey.server.ResourceConfig;
import org.glassfish.jersey.server.model.Resource;

import com.fasterxml.jackson.jaxrs.json.JacksonJaxbJsonProvider;
import com.github.corserpentis.fqs.ws.ApiRootResource;

/**
 * Far Square Space WEB application main entry point.
 *
 * @author Kirill V. Karavaev
 */
public class MainApplication extends ResourceConfig {

	/** Name of a file that contains application properties. */
	private static final String PROPERTIES_FILE = "properties.xml";

	/**
	 * Constructs application instance.
	 * @throws ApplicationException
	 *         indicates initialization error
	 */
	public MainApplication() throws ApplicationException {
		Properties applicationProperties = initializeProperties();
		// Registering services, filter, providers
		register(JacksonJaxbJsonProvider.class);
		register(DefaultExceptionMapper.class);
		register(ContentNegotiationFilter.class);
		register(new InjectionsBinder(applicationProperties));
		// Registering WEB services
		registerResources(Resource.from(ApiRootResource.class));
	}

	/**
	 * Loads application properties from a classpath resource.
	 * @return the application {@link Properties properties} container
	 * @throws ApplicationException
	 *         if the properties file cannot be read
	 */
	private Properties initializeProperties() throws ApplicationException {
		// Locating classpath resource
		URL propertiesFile = MainApplication.class.getResource("/" + PROPERTIES_FILE);
		if (propertiesFile == null) {
			throw new ApplicationException("Unable to find properties file " + PROPERTIES_FILE);
		}
		// Reading properties file
		Properties properties = new Properties();
		try (InputStream stream = propertiesFile.openStream()) {
			properties.loadFromXML(stream);
		} catch (IOException e) {
			throw new ApplicationException("Unable to read properties file", e);
		}
		return properties;
	}

	/**
	 * Binder of the injectable internal services.
	 */
	private static final class InjectionsBinder extends AbstractBinder {

		@Nonnull
		private final Properties properties;

		private InjectionsBinder(Properties properties) {
			this.properties = properties;
		}

		@Override
		protected void configure() {
			// TODO Bind services
		}
	}

}
