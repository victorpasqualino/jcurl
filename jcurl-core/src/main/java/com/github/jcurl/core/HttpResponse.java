package com.github.jcurl.core;

import java.nio.ByteBuffer;
import java.util.List;
import java.util.Map;

import javax.json.JsonArray;
import javax.json.JsonObject;

import com.github.jcurl.core.codec.impl.BodyCodecImpl;
import com.github.jcurl.core.http.HttpVersion;

public interface HttpResponse<T> {

	/**
	 * @return the version of the response
	 */
	HttpVersion version();

	/**
	 * @return the status code of the response
	 */
	int statusCode();

	/**
	 * @return the status message of the response
	 */
	String statusMessage();

	/**
	 * @return the headers
	 */
	Map<String, String> headers();

	/**
	 * Return the first header value with the specified name
	 *
	 * @param headerName the header name
	 * @return the header value
	 */
	String getHeader(String headerName);

	/**
	 * @return the Set-Cookie headers (including trailers)
	 */
	List<String> cookies();

	/**
	 * @return the response body in the format it was decoded.
	 */
	T body();

	/**
	 * @return the response body decoded as a {@link Buffer}
	 */
	ByteBuffer bodyAsBuffer();

	/**
	 * @return the response body decoded as a {@code String}
	 */
	default String bodyAsString() {
		ByteBuffer b = bodyAsBuffer();
		return b != null ? BodyCodecImpl.UTF8_DECODER.apply(b) : null;
	}

	/**
	 * @return the response body decoded as a {@code String} given a specific
	 *         {@code encoding}
	 */
	default String bodyAsString(String encoding) {
		ByteBuffer b = bodyAsBuffer();
		return b != null ? b.toString() : null;
	}

	/**
	 * @return the response body decoded as a json object
	 */
	default JsonObject bodyAsJsonObject() {
		ByteBuffer b = bodyAsBuffer();
		return b != null ? BodyCodecImpl.JSON_OBJECT_DECODER.apply(b) : null;
	}

	/**
	 * @return the response body decoded as a json array
	 */
	default JsonArray bodyAsJsonArray() {
		ByteBuffer b = bodyAsBuffer();
		return b != null ? BodyCodecImpl.JSON_ARRAY_DECODER.apply(b) : null;
	}

	/**
	 * @return the response body decoded as the specified {@code type} with the
	 *         Jackson mapper.
	 */
	default <R> R bodyAsJson(Class<R> type) {
		ByteBuffer b = bodyAsBuffer();
		return b != null ? BodyCodecImpl.jsonDecoder(type).apply(b) : null;
	}

}
