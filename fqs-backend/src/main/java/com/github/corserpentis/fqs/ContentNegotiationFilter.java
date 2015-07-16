package com.github.corserpentis.fqs;

import java.util.HashMap;

import javax.annotation.Priority;
import javax.ws.rs.Priorities;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.core.MediaType;

import org.glassfish.jersey.server.filter.UriConnegFilter;

/**
 * URI-based content negotiation filter.
 *
 * @author Kirill V. Karavaev
 */
@PreMatching
@Priority(Priorities.HEADER_DECORATOR)
public class ContentNegotiationFilter extends UriConnegFilter {

	/**
	 * Constructs new filter instance. This constructor should only be used by Jersey runtime.
	 */
	public ContentNegotiationFilter() {
		super(new HashMap<>(), new HashMap<>());
		mediaTypeMappings.put("json", MediaType.APPLICATION_JSON_TYPE);
		mediaTypeMappings.put("xml", MediaType.APPLICATION_XML_TYPE);
	}

}
