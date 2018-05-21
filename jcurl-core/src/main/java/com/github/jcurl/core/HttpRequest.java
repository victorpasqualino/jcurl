package com.github.jcurl.core;

import java.nio.Buffer;
import java.util.Map;

import javax.json.JsonObject;

import com.github.jcurl.core.codec.BodyCodec;
import com.github.jcurl.core.http.HttpMethod;

public interface HttpRequest<T> {

	/**
	 * Configure the request to use a new method {@code value}.
	 *
	 * @return a reference to this, so the API can be used fluently
	 */
	HttpRequest<T> method(HttpMethod value);

	/**
	 * Configure the request to use a new port {@code value}.
	 *
	 * @return a reference to this, so the API can be used fluently
	 */
	HttpRequest<T> port(int value);

	/**
	 * Configure the request to decode the response with the {@code responseCodec}.
	 *
	 * @param responseCodec the response codec
	 * @return a reference to this, so the API can be used fluently
	 */
	<U> HttpRequest<U> as(BodyCodec<U> responseCodec);

	/**
	 * Configure the request to use a new host {@code value}.
	 *
	 * @return a reference to this, so the API can be used fluently
	 */
	HttpRequest<T> host(String value);

	/**
	 * Configure the request to use a new request URI {@code value}.
	 *
	 * @return a reference to this, so the API can be used fluently
	 */
	HttpRequest<T> uri(String value);

	/**
	 * Configure the request to add a new HTTP header.
	 *
	 * @param name  the header name
	 * @param value the header value
	 * @return a reference to this, so the API can be used fluently
	 */
	HttpRequest<T> putHeader(String name, String value);
	
	/**
	 * Configure the request to add a new HTTP headers.
	 *
	 * @param headers  the headers to be added
	 * @return a reference to this, so the API can be used fluently
	 */
	HttpRequest<T> putHeaders(Map<String, String> headers);


	HttpRequest<T> ssl(boolean value);

	/**
	 * Configures the amount of time in milliseconds after which if the request does
	 * not return any data within the timeout period an
	 * {@link java.util.concurrent.TimeoutException} fails the request.
	 * <p>
	 * Setting zero or a negative {@code value} disables the timeout.
	 *
	 * @param value The quantity of time in milliseconds.
	 * @return a reference to this, so the API can be used fluently
	 */
	HttpRequest<T> timeout(long value);

	/**
	 * Add a query parameter to the request.
	 *
	 * @param paramName  the param name
	 * @param paramValue the param value
	 * @return a reference to this, so the API can be used fluently
	 */
	HttpRequest<T> addQueryParam(String paramName, String paramValue);
	
	/**
	 * Add many query parameters to the request.
	 *
	 * @param queryParams  the queryParams to be added
	 * @return a reference to this, so the API can be used fluently
	 */
	HttpRequest<T> addQueryParams(Map<String, String> queryParams);
	
	/**
	 * Add a path parameter to the request.
	 *
	 * @param paramName  the param name
	 * @param paramValue the param value
	 * @return a reference to this, so the API can be used fluently
	 */
	HttpRequest<T> addPathParam(String paramName, String paramValue);
	
	/**
	 * Add many path parameters to the request.
	 *
	 * @param pathParams  the pathParams to be added
	 * @return a reference to this, so the API can be used fluently
	 */
	HttpRequest<T> addPathParams(Map<String, String> pathParams);
	
	/**
	 * Like {@link #send(Handler)} but with an HTTP request {@code body} buffer.
	 *
	 * @param body the body
	 */
	HttpResponse<T> sendBuffer(Buffer body);

	/**
	 * Like {@link #send(Handler)} but with an HTTP request {@code body} object
	 * encoded as json and the content type set to {@code application/json}.
	 *
	 * @param body the body
	 */
	HttpResponse<T> sendJsonObject(JsonObject body);

	/**
	 * Like {@link #send()} but with an HTTP request {@code body} object
	 * encoded as json and the content type set to {@code application/json}.
	 *
	 * @param body the body
	 */
	HttpResponse<T> sendJson(Object body);

	/**
	 * Like {@link #send(Handler)} but with an HTTP request {@code body} multimap
	 * encoded as form and the content type set to
	 * {@code application/x-www-form-urlencoded}.
	 * <p>
	 * When the content type header is previously set to {@code multipart/form-data}
	 * it will be used instead.
	 *
	 * @param body the body
	 */
	HttpResponse<T> sendForm(Map<String, String> body);

	/**
	 * Send a request, the {@code handler} will receive the response as an
	 * {@link HttpResponse}.
	 */
	HttpResponse<T> send();

}
