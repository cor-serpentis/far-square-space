package com.github.corserpentis.fqs.ws;

import javax.annotation.ParametersAreNonnullByDefault;
import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import com.github.corserpentis.fqs.ApplicationException;

/**
 * Far Square Space API root resource.
 *
 * @author Kirill V. Karavaev
 */
@Path("/api")
public class ApiRootResource {

	/**
	 * Constructs resource instance. Called by Jersey.
	 */
	@Inject
	@ParametersAreNonnullByDefault
	public ApiRootResource() {
	}

	@GET
	@Path("test")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML })
	public TestResponse test() throws ApplicationException {
		return new TestResponse();
	}

	@XmlRootElement
	public static class TestResponse {
		@XmlElement
		public String hello = "universe";
	}

}
