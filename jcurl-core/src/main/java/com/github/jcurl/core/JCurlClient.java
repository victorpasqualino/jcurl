package com.github.jcurl.core;

import java.nio.ByteBuffer;

import com.github.jcurl.core.http.HttpMethod;
import com.github.jcurl.core.http.RequestOptions;
import com.github.jcurl.core.impl.JCurlClientImpl;

public interface JCurlClient {

	default JCurlClient create() {
		return new JCurlClientImpl();
	}

	/**
	 * Create an HTTP request to send to the server at the specified host and port.
	 * 
	 * @param method     the HTTP method
	 * @param port       the port
	 * @param host       the host
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> request(HttpMethod method, int port, String host, String requestURI);

	/**
	 * Create an HTTP request to send to the server at the specified host and
	 * default port.
	 * 
	 * @param method     the HTTP method
	 * @param host       the host
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> request(HttpMethod method, String host, String requestURI);

	/**
	 * Create an HTTP request to send to the server at the default host and port.
	 * 
	 * @param method     the HTTP method
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> request(HttpMethod method, String requestURI);

	/**
	 * Create an HTTP request to send to the server at the specified host and port.
	 * 
	 * @param method  the HTTP method
	 * @param options the request options
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> request(HttpMethod method, RequestOptions options);

	/**
	 * Create an HTTP request to send to the server using an absolute URI
	 * 
	 * @param method      the HTTP method
	 * @param absoluteURI the absolute URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> requestAbs(HttpMethod method, String absoluteURI);

	/**
	 * Create an HTTP GET request to send to the server at the default host and
	 * port.
	 * 
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> get(String requestURI);

	/**
	 * Create an HTTP GET request to send to the server at the specified host and
	 * port.
	 * 
	 * @param port       the port
	 * @param host       the host
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> get(int port, String host, String requestURI);

	/**
	 * Create an HTTP GET request to send to the server at the specified host and
	 * default port.
	 * 
	 * @param host       the host
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> get(String host, String requestURI);

	/**
	 * Create an HTTP GET request to send to the server using an absolute URI,
	 * specifying a response handler to receive the response
	 * 
	 * @param absoluteURI the absolute URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> getAbs(String absoluteURI);

	/**
	 * Create an HTTP POST request to send to the server at the default host and
	 * port.
	 * 
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> post(String requestURI);

	/**
	 * Create an HTTP POST request to send to the server at the specified host and
	 * port.
	 * 
	 * @param port       the port
	 * @param host       the host
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> post(int port, String host, String requestURI);

	/**
	 * Create an HTTP POST request to send to the server at the specified host and
	 * default port.
	 * 
	 * @param host       the host
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> post(String host, String requestURI);

	/**
	 * Create an HTTP POST request to send to the server using an absolute URI,
	 * specifying a response handler to receive the response
	 * 
	 * @param absoluteURI the absolute URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> postAbs(String absoluteURI);

	/**
	 * Create an HTTP PUT request to send to the server at the default host and
	 * port.
	 * 
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> put(String requestURI);

	/**
	 * Create an HTTP PUT request to send to the server at the specified host and
	 * port.
	 * 
	 * @param port       the port
	 * @param host       the host
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> put(int port, String host, String requestURI);

	/**
	 * Create an HTTP PUT request to send to the server at the specified host and
	 * default port.
	 * 
	 * @param host       the host
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> put(String host, String requestURI);

	/**
	 * Create an HTTP PUT request to send to the server using an absolute URI,
	 * specifying a response handler to receive the response
	 * 
	 * @param absoluteURI the absolute URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> putAbs(String absoluteURI);

	/**
	 * Create an HTTP DELETE request to send to the server at the default host and
	 * port.
	 * 
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> delete(String requestURI);

	/**
	 * Create an HTTP DELETE request to send to the server at the specified host and
	 * port.
	 * 
	 * @param port       the port
	 * @param host       the host
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> delete(int port, String host, String requestURI);

	/**
	 * Create an HTTP DELETE request to send to the server at the specified host and
	 * default port.
	 * 
	 * @param host       the host
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> delete(String host, String requestURI);

	/**
	 * Create an HTTP DELETE request to send to the server using an absolute URI,
	 * specifying a response handler to receive the response
	 * 
	 * @param absoluteURI the absolute URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> deleteAbs(String absoluteURI);

	/**
	 * Create an HTTP PATCH request to send to the server at the default host and
	 * port.
	 * 
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> patch(String requestURI);

	/**
	 * Create an HTTP PATCH request to send to the server at the specified host and
	 * port.
	 * 
	 * @param port       the port
	 * @param host       the host
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> patch(int port, String host, String requestURI);

	/**
	 * Create an HTTP PATCH request to send to the server at the specified host and
	 * default port.
	 * 
	 * @param host       the host
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> patch(String host, String requestURI);

	/**
	 * Create an HTTP PATCH request to send to the server using an absolute URI,
	 * specifying a response handler to receive the response
	 * 
	 * @param absoluteURI the absolute URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> patchAbs(String absoluteURI);

	/**
	 * Create an HTTP HEAD request to send to the server at the default host and
	 * port.
	 * 
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> head(String requestURI);

	/**
	 * Create an HTTP HEAD request to send to the server at the specified host and
	 * port.
	 * 
	 * @param port       the port
	 * @param host       the host
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> head(int port, String host, String requestURI);

	/**
	 * Create an HTTP HEAD request to send to the server at the specified host and
	 * default port.
	 * 
	 * @param host       the host
	 * @param requestURI the relative URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> head(String host, String requestURI);

	/**
	 * Create an HTTP HEAD request to send to the server using an absolute URI,
	 * specifying a response handler to receive the response
	 * 
	 * @param absoluteURI the absolute URI
	 * @return an HTTP client request object
	 */
	HttpRequest<ByteBuffer> headAbs(String absoluteURI);

	/**
	 * Close the client. Closing will close down any pooled connections. Clients
	 * should always be closed after use.
	 */
	void close();

}
