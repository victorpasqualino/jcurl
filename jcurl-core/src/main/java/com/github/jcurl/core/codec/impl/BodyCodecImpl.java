package com.github.jcurl.core.codec.impl;

import java.nio.ByteBuffer;
import java.nio.charset.StandardCharsets;
import java.util.function.Function;

import javax.json.JsonArray;
import javax.json.JsonObject;
import javax.json.bind.JsonbBuilder;

import com.github.jcurl.core.codec.BodyCodec;
import com.github.jcurl.core.json.Json;


public class BodyCodecImpl<T> implements BodyCodec<T> {

	public static final Function<ByteBuffer, Void> VOID_DECODER = buff -> null;
	public static final Function<ByteBuffer, String> UTF8_DECODER = buff -> new String(buff.array(), StandardCharsets.UTF_8);
	public static final Function<ByteBuffer, JsonObject> JSON_OBJECT_DECODER = buff -> JsonbBuilder.create().fromJson(buff.toString(), JsonObject.class);
	public static final Function<ByteBuffer, JsonArray> JSON_ARRAY_DECODER = buff -> JsonbBuilder.create().fromJson(buff.toString(), JsonArray.class);

	public static final BodyCodec<String> STRING = new BodyCodecImpl<>(UTF8_DECODER);
	public static final BodyCodec<Void> NONE = new BodyCodecImpl<>(VOID_DECODER);
	public static final BodyCodec<ByteBuffer> BUFFER = new BodyCodecImpl<>(Function.identity());
	public static final BodyCodec<JsonObject> JSON_OBJECT = new BodyCodecImpl<>(JSON_OBJECT_DECODER);
	public static final BodyCodec<JsonArray> JSON_ARRAY = new BodyCodecImpl<>(JSON_ARRAY_DECODER);

	public static BodyCodecImpl<String> string(String encoding) {
		return new BodyCodecImpl<>(buff -> buff.toString());
	}

	public static <T> BodyCodec<T> json(Class<T> type) {
		return new BodyCodecImpl<>(jsonDecoder(type));
	}

	public static <T> Function<ByteBuffer, T> jsonDecoder(Class<T> type) {
		return buff -> Json.decodeValue(buff.toString(), type);
	}

	private final Function<ByteBuffer, T> decoder;

	public BodyCodecImpl(Function<ByteBuffer, T> decoder) {
		this.decoder = decoder;
	}

	@Override
	public T decode(ByteBuffer buffer) {
		return decoder.apply(buffer);
	}

}
