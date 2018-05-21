package com.github.jcurl.core.impl;

import java.nio.Buffer;
import java.util.Map;

import javax.json.JsonObject;

import com.github.jcurl.core.HttpRequest;
import com.github.jcurl.core.HttpResponse;
import com.github.jcurl.core.codec.BodyCodec;
import com.github.jcurl.core.http.CaseInsensitiveHeaders;
import com.github.jcurl.core.http.HttpMethod;

public class HttpRequestImpl<T> implements HttpRequest<T> {

	private final JCurlClientImpl client;
	private Map<String, String> pathParams;
	private Map<String, String> queryParams;
	private HttpMethod method;
	private String protocol;
	private int port;
	private String host;
	private String uri;
	private Map<String, String> headers;
	private long timeout = -1;
	private BodyCodec<T> codec;
	private boolean ssl;

	HttpRequestImpl(JCurlClientImpl client, HttpMethod method, boolean ssl, int port, String host, String uri, BodyCodec<T> codec) {
		this(client, method, null, ssl, port, host, uri, codec);
	}

	HttpRequestImpl(JCurlClientImpl client, HttpMethod method, String protocol, boolean ssl, int port, String host, String uri, BodyCodec<T> codec) {
		this.client = client;
		this.method = method;
		this.protocol = protocol;
		this.codec = codec;
		this.port = port;
		this.host = host;
		this.uri = uri;
		this.ssl = ssl;
	}

	private HttpRequestImpl(HttpRequestImpl<T> other) {
		this.client = other.client;
		this.method = other.method;
		this.protocol = other.protocol;
		this.port = other.port;
		this.host = other.host;
		this.timeout = other.timeout;
		this.uri = other.uri;
		this.headers = other.headers != null ? new CaseInsensitiveHeaders(other.headers) : null;
		this.queryParams = other.queryParams != null ? new CaseInsensitiveHeaders(other.queryParams) : null;
		this.pathParams = other.pathParams != null ? new CaseInsensitiveHeaders(other.pathParams) : null;
		this.codec = other.codec;
	}

	@Override
	public HttpRequest<T> method(HttpMethod value) {
		// TODO Auto-generated method stub
		return this;
	}

	@Override
	public HttpRequest<T> port(int value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public <U> HttpRequest<U> as(BodyCodec<U> responseCodec) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpRequest<T> host(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpRequest<T> uri(String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpRequest<T> putHeader(String name, String value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpRequest<T> putHeaders(Map<String, String> headers) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpRequest<T> ssl(boolean value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpRequest<T> timeout(long value) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpRequest<T> addQueryParam(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpRequest<T> addQueryParams(Map<String, String> queryParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpRequest<T> addPathParam(String paramName, String paramValue) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpRequest<T> addPathParams(Map<String, String> pathParams) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpResponse<T> sendBuffer(Buffer body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpResponse<T> sendJsonObject(JsonObject body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpResponse<T> sendJson(Object body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpResponse<T> sendForm(Map<String, String> body) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public HttpResponse<T> send() {
		// TODO Auto-generated method stub
		return null;
	}

	private void send(String contentType, Object body) {
//		HttpContext ex = new HttpContext(this, contentType, body);
//		ex.interceptAndSend();
		
		// TODO Auto-generated method stub
	}

}
