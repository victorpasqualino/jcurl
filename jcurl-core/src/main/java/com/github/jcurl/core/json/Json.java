package com.github.jcurl.core.json;

import java.nio.ByteBuffer;
import java.util.Iterator;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.fasterxml.jackson.datatype.jdk8.Jdk8Module;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.fasterxml.jackson.datatype.jsr353.JSR353Module;

public class Json {

	public static ObjectMapper mapper = new ObjectMapper();
	public static ObjectMapper prettyMapper = new ObjectMapper();

	static {
		
		mapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);

		prettyMapper.configure(JsonParser.Feature.ALLOW_COMMENTS, true);
		prettyMapper.configure(SerializationFeature.INDENT_OUTPUT, true);

		JSR353Module jsr353Module = new JSR353Module();
		mapper.registerModule(jsr353Module);
		prettyMapper.registerModule(jsr353Module);
		
		Jdk8Module jdk8Module = new Jdk8Module();
		mapper.registerModule(jdk8Module);
		prettyMapper.registerModule(jdk8Module);
		
		JavaTimeModule javaTimeModule = new JavaTimeModule();
		mapper.registerModule(javaTimeModule);
		prettyMapper.registerModule(javaTimeModule);
	}

	/**
	 * Encode a POJO to JSON using the underlying Jackson mapper.
	 *
	 * @param obj a POJO
	 * @return a String containing the JSON representation of the given POJO.
	 * @throws JsonProcessingException 
	 * @throws EncodeException if a property cannot be encoded.
	 */
	public static String encode(Object obj) throws EncodeException {
		try {
			return mapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new EncodeException("Failed to encode as JSON: " + e.getMessage());
		}
	}

	/**
	 * Encode a POJO to JSON using the underlying Jackson mapper.
	 *
	 * @param obj a POJO
	 * @return a Buffer containing the JSON representation of the given POJO.
	 * @throws EncodeException if a property cannot be encoded.
	 */
	public static ByteBuffer encodeToBuffer(Object obj) throws EncodeException {
		try {
			return ByteBuffer.wrap(mapper.writeValueAsBytes(obj));
		} catch (Exception e) {
			throw new EncodeException("Failed to encode as JSON: " + e.getMessage());
		}
	}

	/**
	 * Encode a POJO to JSON with pretty indentation, using the underlying Jackson
	 * mapper.
	 *
	 * @param obj a POJO
	 * @return a String containing the JSON representation of the given POJO.
	 * @throws EncodeException if a property cannot be encoded.
	 */
	public static String encodePrettily(Object obj) throws EncodeException {
		try {
			return prettyMapper.writeValueAsString(obj);
		} catch (Exception e) {
			throw new EncodeException("Failed to encode as JSON: " + e.getMessage());
		}
	}

	/**
	 * Decode a given JSON string to a POJO of the given class type.
	 * 
	 * @param str   the JSON string.
	 * @param clazz the class to map to.
	 * @param       <T> the generic type.
	 * @return an instance of T
	 * @throws DecodeException when there is a parsing or invalid mapping.
	 */
	public static <T> T decodeValue(String str, Class<T> clazz) throws DecodeException {
		try {
			return mapper.readValue(str, clazz);
		} catch (Exception e) {
			throw new DecodeException("Failed to decode: " + e.getMessage());
		}
	}

	/**
	 * Decode a given JSON string to a POJO of the given type.
	 * 
	 * @param str  the JSON string.
	 * @param type the type to map to.
	 * @param      <T> the generic type.
	 * @return an instance of T
	 * @throws DecodeException when there is a parsing or invalid mapping.
	 */
	public static <T> T decodeValue(String str, TypeReference<T> type) throws DecodeException {
		try {
			return mapper.readValue(str, type);
		} catch (Exception e) {
			throw new DecodeException("Failed to decode: " + e.getMessage(), e);
		}
	}

	/**
	 * Decode a given JSON buffer to a POJO of the given class type.
	 * 
	 * @param buf  the JSON buffer.
	 * @param type the type to map to.
	 * @param      <T> the generic type.
	 * @return an instance of T
	 * @throws DecodeException when there is a parsing or invalid mapping.
	 */
	public static <T> T decodeValue(ByteBuffer buf, TypeReference<T> type) throws DecodeException {
		try {
			return mapper.readValue(buf.array(), type);
		} catch (Exception e) {
			throw new DecodeException("Failed to decode:" + e.getMessage(), e);
		}
	}

	/**
	 * Decode a given JSON buffer to a POJO of the given class type.
	 * 
	 * @param buf   the JSON buffer.
	 * @param clazz the class to map to.
	 * @param       <T> the generic type.
	 * @return an instance of T
	 * @throws DecodeException when there is a parsing or invalid mapping.
	 */
	public static <T> T decodeValue(ByteBuffer buf, Class<T> clazz) throws DecodeException {
		try {
			return mapper.readValue(buf.array(), clazz);
		} catch (Exception e) {
			throw new DecodeException("Failed to decode:" + e.getMessage(), e);
		}
	}

	static <T> Stream<T> asStream(Iterator<T> sourceIterator) {
		Iterable<T> iterable = () -> sourceIterator;
		return StreamSupport.stream(iterable.spliterator(), false);
	}

}
