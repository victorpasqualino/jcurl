package com.github.jcurl.core.codec;

import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.util.function.Function;

import javax.json.JsonArray;
import javax.json.JsonObject;

import com.github.jcurl.core.codec.impl.BodyCodecImpl;

public interface BodyCodec<T> {

	/**
	 * @return the UTF-8 string codec
	 */
	static BodyCodec<String> string() {
		return BodyCodecImpl.STRING;
	}

	/**
	 * A codec for strings using a specific {@code encoding}.
	 *
	 * @param encoding the encoding
	 * @return the codec
	 */
	static BodyCodec<String> string(String encoding) {
		return BodyCodecImpl.string(encoding);
	}

	/**
	 * @return the {@link Buffer} codec
	 */
	static BodyCodec<ByteBuffer> buffer() {
		return BodyCodecImpl.BUFFER;
	}

	/**
	 * @return the {@link JsonObject} codec
	 */
	static BodyCodec<JsonObject> jsonObject() {
		return BodyCodecImpl.JSON_OBJECT;
	}

	/**
	 * @return the {@link JsonArray} codec
	 */
	static BodyCodec<JsonArray> jsonArray() {
		return BodyCodecImpl.JSON_ARRAY;
	}

	/**
	 * Create and return a codec for Java objects encoded using Jackson mapper.
	 *
	 * @return a codec for mapping POJO to Json
	 */
	static <U> BodyCodec<U> json(Class<U> type) {
		return BodyCodecImpl.json(type);
	}

	/**
	 * @return a codec that simply discards the response
	 */
	static BodyCodec<Void> none() {
		return BodyCodecImpl.NONE;
	}

	/**
	 * Create a codec that buffers the entire body and then apply the {@code decode}
	 * function and returns the result.
	 *
	 * @param decode the decode function
	 * @return the created codec
	 */
	static <T> BodyCodec<T> create(Function<ByteBuffer, T> decode) {
		return new BodyCodecImpl<>(decode);
	}
	
	/**
	 * @param buffer the buffer to be decoded
	 * @return the decoded buffer
	 */
	T decode(ByteBuffer buffer);

}
