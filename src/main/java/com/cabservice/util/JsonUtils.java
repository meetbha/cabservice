/**
* The JsonUtils class is for converting object to json
*
* @author  Chetna Ghebad
* @version 1.0
* @since   2019-08-28 
*/
package com.cabservice.util;

import org.hibernate.service.spi.ServiceException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.fasterxml.jackson.annotation.JsonInclude.Include;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class JsonUtils {

	private static final Logger logger = LoggerFactory.getLogger(JsonUtils.class);

	private static ObjectMapper mapper = new ObjectMapper();

	private JsonUtils() {
	}

	/**
	 * getJsonString - This method will provide JSON string
	 * 
	 * @param data - Object of particular type
	 * @return json string
	 */
	public static String getJsonString(Object data) {
		logger.info("Start of Object to Json Conversion");
		String jsonString = null;
		if (data != null) {
			mapper.setSerializationInclusion(Include.NON_NULL);
			try {
				jsonString = mapper.writeValueAsString(data);
			} catch (JsonProcessingException e) {
				logger.error("JSON Conversion Failed");
				throw new ServiceException("JSON Conversion Failed");
			}
		}
		logger.info("End of Object to Json Conversion");
		return jsonString;
	}
}
